package com.example.securityconfigurationjwtbcrypt.security.services;

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

        // Set the expiration time to one hour from now
        long expirationMillis = nowMillis + 3600 * 1000; // 1 hour in milliseconds
        Date expiration = new Date(expirationMillis);

        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
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

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(setSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey setSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        // Ensure the key has at least 256 bits (32 bytes)
        if (keyBytes.length < 32) {
            byte[] paddedKeyBytes = new byte[32];
            System.arraycopy(keyBytes, 0, paddedKeyBytes, 0, keyBytes.length);
            keyBytes = paddedKeyBytes;
        }

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
