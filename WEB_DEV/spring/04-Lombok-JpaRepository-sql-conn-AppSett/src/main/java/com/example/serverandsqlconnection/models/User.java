package com.example.serverandsqlconnection.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    The @Entity annotation marks this class as a JPA entity, representing a table in a relational database.

    By default, each entity class maps a database table with the same name in the default schema of
    database. You can customize this mapping using the name, schema, and catalog attributes of the @Table annotation.
    "@Table(name="user", schema="testdb")"

    LOMBOK Annotations <----
    @Getter and @Setter:
        Description: Automatically generates getter and setter methods for class properties. For example, placing @Getter on a private property will create a public getter for that property.

    @NoArgsConstructor, @RequiredArgsConstructor, and @AllArgsConstructor:
        Description:
            @NoArgsConstructor creates an empty constructor.
            @RequiredArgsConstructor generates a constructor with final or @NonNull annotated properties.
            @AllArgsConstructor creates a constructor with all class properties.

    @Data:
        Description: A composite annotation that includes @Getter, @Setter, @RequiredArgsConstructor,
        * @ToString, and @EqualsAndHashCode. It provides comprehensive functionality for data classes.

    @Builder:
        Description: Creates a convenient and safe way to build objects using the Builder design pattern.
        * Allows creating objects by setting only the desired properties instead of all at once.

        // ############ SAMPLE #############
        // This code sets the values for the name and email fields of the User object using the builder pattern.
        User user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        // Assume you have an existing User object that you want to update
        User existingUser = // ... retrieve the existing user from the database or elsewhere

        // Use the builder pattern to create a new User object with updated values
        User updatedUser = User.builder()
                .name("Updated Name")
                .email("updated.email@example.com")
                .build();

        // Replace the existing User object with the updated one
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        // Now the existingUser object has been updated with the new values
        // ###################################

    @Slf4j:
        Description: Automatically generates a Logger object using the SLF4J (Simple Logging Facade for Java)
        * library, simplifying logging in classes.

    @Value:
        Description: Creates an immutable class. Similar to @Data, but all properties are final, and only getters
        * will be generated.

    @NonNull:
        Description: Used in conjunction with other Lombok annotations, such as @Setter or @RequiredArgsConstructor,
        * to automatically check if a property is not null. If the property is null, a NullPointerException is thrown.

    @Cleanup:
        Description: Automatically generates try-finally blocks, ensuring that resources (e.g., streams)
        * are properly closed.

    @RequiredArgsConstructor:
        Description: Automatically generates a constructor for a class based on the non-null final fields or, in
        other words, fields marked with "final" and @NonNull annotations.
 */
@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /*
     * The @Id annotation marks the 'id' field as the primary key of the entity.
     * The @GeneratedValue annotation specifies the strategy for generating primary key values,
     * and GenerationType.IDENTITY indicates automatic generation by the database.
     *
     * GenerationType.IDENTITY - database automatically assigns an incrementing number for each new entity.
     * It is typically used with databases that support auto-increment columns, such as MySQL, PostgreSQL,
     * and SQL Server.
     *
     * GenerationType.AUTO - JPA provider selects the appropriate strategy based on the database capabilities.
     * It may use identity columns, sequences, or other mechanisms depending on the underlying database.
     *
     * GenerationType.SEQUENCE -a  database sequence is used to generate unique values. This is suitable for
     * databases like Oracle that support sequences.
     *
     * GenerationType.TABLE - a separate table is used to store and generate unique key values. This is a more
     * portable solution but may be less efficient than other strategies.
     *
     *GenerationType.NONE - no automatic generation of values. The application is responsible for setting the
     * primary key before persisting the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
     * The @NotBlank annotation is a validation constraint that ensures 'name' and "email" is not null and its
     * trimmed length is greater than zero. It is part of the Jakarta Bean Validation API.
     *
     * @Column annotation is an optional annotation that enables you to customize the
     * mapping between the entity attribute and the database column.
     *
     * @Column(name = "user_name") - corresponding field in your Java entity class should be
     * mapped to a database column with the name "user_name".
     * @Column(columnDefinition = "TEXT") - columnDefinition attribute allows you
     * to provide a custom SQL fragment that is used during the creation of the table
     * @Column(length = 50) - length attribute is used to define the length of a
     * String-valued database column. This is often used when mapping a Java String field to a
     * VARCHAR column in the database.
     * @Email annotation is applied to the email field. If the value of the email field is not a valid
     * email address, a validation error message with the specified message ("Please provide a valid email
     * address") will be added to the binding result
     */
    @NotBlank(message = "Name is mandatory")
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
    @Column(length = 100, nullable = false)
    private String email;

    /*
     * The @Data annotation automatically generates a constructor with all non-null fields.
     * In this case, a constructor is not explicitly defined because Lombok generates it for you.
     * If you need custom constructor logic, you can define it manually.
     * If no custom logic is needed, you can rely on the Lombok-generated constructor.
     */

}