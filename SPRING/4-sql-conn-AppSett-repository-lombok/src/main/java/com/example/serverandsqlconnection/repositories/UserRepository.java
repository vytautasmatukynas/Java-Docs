package com.example.serverandsqlconnection.repositories;


import com.example.serverandsqlconnection.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameAndEmailContainingIgnoreCase(String name, String email);

    /*
    SOME OTHER Query SAMPLES methods for finding entities
     */
//    // FIND BY <----
//    // Find users by name
//    List<User> findByName(String name);
//
//    // Find a user by email
//    Optional<User> findByEmail(String email);
//
//    // Find users by name, ignoring case
//    List<User> findByNameIgnoreCase(String name);
//
//    // Find users by name, exact match
//    List<User> findByNameEquals(String name);
//
//    // Find users by email containing a specific substring, ignoring case
//    List<User> findByEmailContainingIgnoreCase(String partialEmail);
//
//    // Find users by name and email
//    List<User> findByNameAndEmail(String name, String email);
//
//    // Find users by name or email
//    List<User> findByNameOrEmail(String name, String email);
//
//    // Find users by name containing a specific substring, ignoring case
//    List<User> findByNameContainingIgnoreCase(String partialName);
//
//    // Find users by name containing a specific substring and email containing a specific substring, ignoring case
//    List<User> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(String partialName, String partialEmail);
//
//    // Find users by name or email, ordered by name
//    List<User> findByNameOrEmailOrderByName(String name, String email);

//    // COUNT BY <----
//    // Find the count of users by name
//    long countByName(String name);
//
//    // Find the count of users by email
//    long countByEmail(String email);
//
//    // Find the count of users by name containing a specific substring, ignoring case
//    long countByNameContainingIgnoreCase(String partialName);

//    // EXISTS BY <----
//    // Check if a user with a specific name exists
//    boolean existsByName(String name);
//
//    // Check if a user with a specific email exists
//    boolean existsByEmail(String email);

//    // DELETE BY <----
//    // Delete users by name
//    void deleteByName(String name);
//
//    // Delete a user by email
//    void deleteByEmail(String email);

//    // CUSTOM QUERY <----
//    // Custom query to find users by name and email
//    @Query("SELECT u FROM User u WHERE u.name = :name AND u.email = :email")
//    List<User> findByNameAndEmail(@Param("name") String name, @Param("email") String email);


/*
    Query Creation:
        findBy...: Used to specify the properties used in the query.
        findBy...And...: Used to combine multiple properties with an AND.
        findBy...Or...: Used to combine multiple properties with an OR.
        findBy...OrderBy...: Used to order the results by a specific property.
        findFirstBy...: Used to retrieve the first result.

    Null Handling:
        findBy...IsNull: Used to find entities where the specified property is null.
        findBy...IsNotNull: Used to find entities where the specified property is not null.

    Like Clauses:
        findBy...Like...: Used for a SQL LIKE clause.
        findBy...NotLike...: Used for a SQL NOT LIKE clause.

    Starting/Ending with:
        findBy...StartingWith...: Used for a SQL LIKE 'prefix%' clause.
        findBy...EndingWith...: Used for a SQL LIKE '%suffix' clause.
        findBy...Containing...: Used for a SQL LIKE '%substring%' clause.

    Ignoring Case:
        findBy...IgnoreCase: Used to perform a case-insensitive search.

    Ordering:
        findBy...OrderBy...Asc: Used for ordering results in ascending order.
        findBy...OrderBy...Desc: Used for ordering results in descending order.

    Counting:
        countBy...: Used to count the number of entities matching the criteria.

    Limiting Results:
        findFirst...: Used to limit the result to the first entity.
        findTop...: Used to limit the result to the first N entities.

    Find the First Entity:
        findFirstBy...: Returns the first entity that matches the specified criteria.
        findFirst3By...: Returns the first 3 entities that match the specified criteria.

    Find the Top N Entities:
        findTopBy...: Returns the top entity that matches the specified criteria.
        findTop3By...: Returns the top 3 entities that match the specified criteria.

    Find the First N Entities:
        findFirst3By...: Returns the first 3 entities that match the specified criteria.
        findFirst5By...: Returns the first 5 entities that match the specified criteria.
 */

//    // Query Creation some more SAMPLES
//    // Find users by email
//    List<User> findByEmail(String email);
//
//    // Find users by name and email
//    List<User> findByNameAndEmail(String name, String email);
//
//    // Find users by name or email
//    List<User> findByNameOrEmail(String name, String email);
//
//    // Find users by email and order them by creation date in descending order
//    List<User> findByEmailOrderByCreatedAtDesc(String email);
//
//    // Find the first user by email
//    User findFirstByEmail(String email);

//    // Null Handling <---
//    // Find users where email is null
//    List<User> findByEmailIsNull();
//
//    // Find users where email is not null
//    List<User> findByEmailIsNotNull();

//    // Like Clauses <---
//    // Find users whose name is like a given pattern
//    List<User> findByNameLike(String name);
//
//    // Find users whose name is not like a given pattern
//    List<User> findByNameNotLike(String name);

//    // Starting/Ending with <---
//    // Find users whose email starts with a given prefix
//    List<User> findByEmailStartingWith(String prefix);
//
//    // Find users whose email ends with a given suffix
//    List<User> findByEmailEndingWith(String suffix);
//
//    // Find users whose email contains a given substring
//    List<User> findByEmailContaining(String substring);

//    // Ignoring Case <---
//    // Find users by name, case-insensitive
//    List<User> findByNameIgnoreCase(String name);

//    // Ordering <---
//    // Find users by email and order them by creation date in ascending order
//    List<User> findByEmailOrderByCreatedAtAsc(String email);
//
//    // Find users by email and order them by creation date in descending order
//    List<User> findByEmailOrderByCreatedAtDesc(String email);

//    // Counting <---
//    // Count the number of users with a specific email
//    long countByEmail(String email);

//    // Limiting Results <---
//    // Find the first user by name
//    User findFirstByName(String name);
//
//    // Find the top 3 users by name
//    List<User> findTop3ByName(String name);
//
//    // Find the top user by email
//    User findTopByEmail(String email);
//
//    // Find the top 3 users by email
//    List<User> findTop3ByEmail(String email);
//
//    // Find the first 3 users by name
//    List<User> findFirst3ByName(String name);
//
//    // Find the top 3 users by name, ordered by creation date in descending order
//    List<User> findTop3ByNameOrderByCreatedAtDesc(String name);
//
//    // Find the first 5 users by name
//    List<User> findFirst5ByName(String name);
//
//    // Find the first 5 users by name, ordered by creation date in descending order
//    List<User> findFirst5ByNameOrderByCreatedAtDesc(String name);


}
