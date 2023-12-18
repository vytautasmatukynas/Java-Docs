package com.example.basicrestapisampewithsecurity.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * Service class for handling JWT (JSON Web Token) operations.
 */
@Service
public class JwtService {

    // Secret key used to sign and verify JWTs (NOTE: This should be kept secret in a real application)
    private static final String SECRET_KEY = "pass123";

    /**
     * Extracts the username from the JWT token.
     *
     * @param token The JWT token.
     * @return The extracted username.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts a specific claim from the JWT token using a claims resolver function.
     *
     * @param token           The JWT token.
     * @param claimsResolver  The claims resolver function.
     * @param <T>             The type of the claim.
     * @return The extracted claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Generates a JWT token for the provided user details.
     *
     * @param userDetails The user details.
     * @return The generated JWT token.
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Generates a JWT token for the provided user details with extra claims.
     *
     * @param extraClaims   Extra claims to include in the token.
     * @param userDetails   The user details.
     * @return The generated JWT token.
     */
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        long nowMillis = System.currentTimeMillis();
        Date issuedAt = new Date(nowMillis);

        long expirationMillis = nowMillis + 24 * 3600 * 1000; // Set the token expiration 24 hours
        Date expiration = new Date(expirationMillis);

        // Extract user roles from the UserDetails object
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Set<String> userRoles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        // Build the JWT token with claims and sign it
        return Jwts.builder()
                .claims(extraClaims)
                .claim("roles", userRoles) // Include user roles in the JWT token
                .subject(userDetails.getUsername()) // Include user username in the JWT token
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(setSignInKey())
                .compact();
    }

    /**
     * Validates whether the provided JWT token is valid for the given user details.
     *
     * @param token         The JWT token.
     * @param userDetails   The user details.
     * @return True if the token is valid, false otherwise.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Check if the provided JWT token is expired.
     *
     * @param token The JWT token to check for expiration.
     * @return True if the token is expired, false otherwise.
     */
    private boolean isTokenExpired(String token) {
        // Compare the expiration date of the token with the current date
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extract the expiration date from the JWT token.
     *
     * @param token The JWT token from which to extract the expiration date.
     * @return The expiration date.
     */
    private Date extractExpiration(String token) {
        // Extract the expiration claim from the token
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extract all claims (payload) from the JWT token.
     *
     * @param token The JWT token from which to extract claims.
     * @return All claims (payload) from the token.
     */
    private Claims extractAllClaims(String token) {
        // Parse and verify the signed JWT token, then extract and return its payload (claims)
        return Jwts.parser()
                .verifyWith(setSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Set the signing key used for JWT token verification.
     *
     * @return The secret key for JWT token verification.
     */
    private SecretKey setSignInKey() {
        // Decode the base64-encoded secret key string into a byte array
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        // Ensure the key has at least 256 bits (32 bytes)
        if (keyBytes.length < 32) {
            // If the key is less than 256 bits, pad it with zeros
            byte[] paddedKeyBytes = new byte[32];
            System.arraycopy(keyBytes, 0, paddedKeyBytes, 0, keyBytes.length);
            keyBytes = paddedKeyBytes;
        }

        // Create and return the HMAC SHA secret key
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
