package com.example.serverandsqlconnection.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
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

@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    private String name;

    private String email;

    /*
     * The @Data annotation automatically generates a constructor with all non-null fields.
     * In this case, a constructor is not explicitly defined because Lombok generates it for you.
     * If you need custom constructor logic, you can define it manually.
     * If no custom logic is needed, you can rely on the Lombok-generated constructor.
     */

}