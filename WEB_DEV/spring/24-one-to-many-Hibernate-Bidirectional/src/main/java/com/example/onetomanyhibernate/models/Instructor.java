package com.example.onetomanyhibernate.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing an Instructor in a bidirectional relationship with Course entities.
 * This class is mapped to the "instructor" table in the database.
 * <p>
 * It demonstrates a bidirectional relationship where an Instructor can be associated with multiple courses
 * (one-to-many relationship) and each course refers back to the same instructor (many-to-one relationship).
 * <p>
 * The bidirectional relationship allows navigation from Instructor to Course and from Course to Instructor.
 * Check the {@code @OneToMany} annotation on the {@code courses} field for details on the one-to-many relationship.
 * <p>
 * One-to-Many Relationship Details:
 * - {@code @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)}:
 *   Specifies the one-to-many relationship with Course entities. The "courses" field in Course owns the relationship,
 *   and operations (persist, remove, merge, detach, and refresh) are cascaded to the associated Course entities.
 *   Orphan removal is enabled, meaning that if a Course is removed from the collection, it is deleted from the database
 *   if it is no longer referenced by any owning entity.
 */

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /*
     * Represents a one-to-many relationship between entities.
     * This annotation indicates that the class where this annotation is used has a one-to-many
     * relationship with another entity.
     *
     * - mappedBy = "instructor": Specifies the field in the related entity ("Course") that owns the relationship.
     *   In this case, it indicates that there is a field named "instructor" in the "Course" entity that maps this relationship.
     *
     * - cascade = CascadeType.ALL: Specifies the operations that should be cascaded to the
     *   target of the association. CascadeType.ALL means that all operations (persist, remove, merge, detach,
     *   and refresh) should be cascaded.
     *
     * - orphanRemoval = true: Specifies whether orphan removal should be applied.
     *   When set to true, it means that if an element in the collection (in this case, the "courses" collection)
     *   is removed from the collection, it should be deleted from the database. In other words, if a "Course" entity is
     *   no longer referenced by any owning entity, it will be considered as an orphan and will be removed from the database.
     *
     * - fetch = FetchType.EAGER: Specifies the fetch strategy for the association.
     *   FetchType.EAGER means that the associated "Course" entities should be loaded eagerly, i.e., they will be fetched
     *   from the database along with the "Instructor" entity, rather than lazily when the "courses" collection is accessed.
     *
     * - fetch = FetchType.LAZY: Specifies the fetch strategy for the association.
     *   FetchType.LAZY means that the associated "Course" entities will be loaded lazily, i.e., they will be fetched
     *   from the database only when the "courses" collection is accessed, rather than eagerly along with the "Instructor" entity.
     *   FetchType.LAZY is the default parameter in @OneToMany.
     *
     * - @JsonManagedReference: The @JsonManagedReference annotation is used to handle bidirectional
     *   relationships during JSON serialization. It is placed on the "owning" side of the relationship
     *   (the "one" side), and it helps Jackson to handle bidirectional references without causing infinite recursion
     *   during JSON serialization. In this case, it indicates that the serialization of the "courses" collection in this
     *   entity should be managed, and the "back" side (Course) should use @JsonBackReference to prevent infinite recursion.
     * 
     * - @JsonIgnore annotation signals that this property should
     *   be ignored during serialization and deserialization, typically used
     *   in JSON processing.
     */
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses;


    public Instructor() { }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void add(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }

        courses.add(course);

        course.setInstructor(this);
    }

}