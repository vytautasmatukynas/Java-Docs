package com.example.serverandsqlconnection.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    The @Entity annotation marks this class as a JPA entity, representing a table in a relational database.

    By default, each entity class maps a database table with the same name in the default schema of
    database. You can customize this mapping using the name, schema, and catalog attributes of the @Table annotation.
    "@Table(name="user", schema="testdb")"

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
 */
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /*
     * The @Id annotation marks the 'id' field as the primary key of the entity.
     * The @GeneratedValue annotation specifies the strategy for generating primary key values,
     * and GenerationType.IDENTITY indicates automatic generation by the database.
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
     */
    @NotBlank(message = "Name is mandatory")
    @Column(length = 100)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(length = 100)
    private String email;

    /*
     * The @Data annotation automatically generates a constructor with all non-null fields.
     * In this case, a constructor is not explicitly defined because Lombok generates it for you.
     * If you need custom constructor logic, you can define it manually.
     * If no custom logic is needed, you can rely on the Lombok-generated constructor.
     */

}