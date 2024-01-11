package com.example.manytomanyhibernate.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

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
     * Represents a Teacher entity with a many-to-many relationship to Lesson entities.
     * The relationship is defined using the @ManyToMany annotation, indicating that
     * each teacher can be associated with multiple lessons, and each lesson can be
     * associated with multiple teachers. The FetchType.LAZY is used to specify that
     * the lessons should be loaded lazily (i.e., only when explicitly requested).
     *
     * The CascadeType is set to PERSIST, MERGE, DETACH, and REFRESH, indicating the
     * operations that should be cascaded to the associated lessons. For example,
     * if a teacher is persisted, the associated lessons will also be persisted.
     *
     * The @JoinTable annotation is used to define the mapping table for the
     * many-to-many relationship. The name of the mapping table is "lesson_teacher",
     * and it has two columns: "teacher_id" and "lesson_id". The joinColumns attribute
     * specifies the column in the mapping table that references the teacher, and the
     * inverseJoinColumns attribute specifies the column that references the lesson.
     *
     * The private List<Lesson> lessons field represents the collection of lessons
     * associated with the teacher. This field will be mapped to the many-to-many
     * relationship in the database.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "lesson_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<Lesson> lessons;

    public Teacher() { }

    public Teacher(String firstName, String lastName, String email) {
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> courses) {
        this.lessons = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", lessons=" + lessons +
                '}';
    }

    public void addLesson(Lesson lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        }

        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        if (lessons != null) {
            lessons.remove(lesson);
        }
    }
}