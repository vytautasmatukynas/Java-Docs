package com.example.serverandsqlconnection.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
 * The @Entity annotation marks this class as a JPA entity, representing a table in a relational database.
 *
 * By default, each entity class maps a database table with the same name in the default schema of
 * database. You can customize this mapping using the name, schema, and catalog attributes of the @Table annotation.
 * "@Table(name="user", schema="testdb")"
 *
 * The @Data annotation from Lombok generates getters, setters, toString, equals, hashCode,
 * and a constructor with all non-null fields.
 *
 * The @NoArgsConstructor annotation generates empty constructor.
 * The @AllArgsConstructor annotation generates full constructor.
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
