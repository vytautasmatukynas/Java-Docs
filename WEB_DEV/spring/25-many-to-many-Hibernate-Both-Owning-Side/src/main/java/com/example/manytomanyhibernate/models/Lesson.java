package com.example.manytomanyhibernate.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    /*
     * Represents a Lesson entity with a many-to-many relationship to Teacher entities.
     * The relationship is defined using the @ManyToMany annotation, indicating that
     * each lesson can be associated with multiple teachers, and each teacher can be
     * associated with multiple lessons. The FetchType.LAZY is used to specify that
     * the teachers should be loaded lazily (i.e., only when explicitly requested).
     *
     * The CascadeType is set to PERSIST, MERGE, DETACH, and REFRESH, indicating the
     * operations that should be cascaded to the associated teachers. For example,
     * if a lesson is persisted, the associated teachers will also be persisted.
     *
     * The @JoinTable annotation is used to define the mapping table for the
     * many-to-many relationship. The name of the mapping table is "lesson_teacher",
     * and it has two columns: "lesson_id" and "teacher_id". The joinColumns attribute
     * specifies the column in the mapping table that references the lesson, and the
     * inverseJoinColumns attribute specifies the column that references the teacher.
     *
     * The private List<Teacher> teachers field represents the collection of teachers
     * associated with the lesson. This field will be mapped to the many-to-many
     * relationship in the database.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "lesson_teacher",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;

    public Lesson() { }

    public Lesson(String title) {
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> studentList) {
        this.teachers = studentList;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }

        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers != null) {
            teachers.remove(teacher);
        }
    }
}
