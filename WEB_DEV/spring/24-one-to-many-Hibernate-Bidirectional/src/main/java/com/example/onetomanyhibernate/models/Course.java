package com.example.onetomanyhibernate.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    /*
     * Represents a many-to-one relationship between entities.
     * This annotation indicates that the class where this annotation is used has a many-to-one
     * relationship with another entity.
     *
     * - @ManyToOne: Specifies the type of the relationship, indicating that many instances
     *   of this entity can be associated with a single instance of the related entity (Instructor).
     *
     * - @JoinColumn(name = "instructor_id"): Specifies the foreign key column in the
     *   current entity's table that is used to establish the many-to-one relationship. In this case,
     *   it indicates that the "instructor_id" column in this entity's table is used to refer to the
     *   primary key of the related entity (Instructor).
     *
     * - @JsonBackReference: The @JsonBackReference annotation is used to handle bidirectional
     *   relationships during JSON serialization. It is placed on the "back" side of the relationship
     *   (the "many" side), and it prevents infinite recursion caused by the bidirectional relationship
     *   when serializing to JSON. In this case, it indicates that the serialization of the "instructor"
     *   property in this entity should be ignored to break the loop.
     */
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course() { }

    public Course(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
