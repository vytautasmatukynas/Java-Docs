package com.example.onetoonehibernate.models;

import jakarta.persistence.*;

/**
 * Unidirectional Relationship SAMPLE:
 * If you only need to navigate from Instructor to InstructorDetail and don't need to access
 * Instructor from InstructorDetail, you might stick with a unidirectional relationship.
 * <p>
 * Only Instructor sees InstructorDetail, but InstructorDetail doesn't see Instructor.
 * No @OneToOne annotation in InstructorDetail.
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
     * @OneToOne: This annotation is used to define a one-to-one relationship between entities.
     * In this context, it suggests that the class where this annotation is used has a one-to-one
     * relationship with another entity.
     * 
     * CascadeType.ALL is used to propagate all operations (PERSIST, MERGE, REMOVE, REFRESH, DETACH)
     * from the owning entity (Instructor) to the target entity (InstructorDetail).
     * - PERSIST: When an Instructor is persisted, associated InstructorDetail will also be persisted.
     * - MERGE: When an Instructor is merged, associated InstructorDetail will also be merged.
     * - REMOVE: When an Instructor is removed, associated InstructorDetail will also be removed.
     * - REFRESH: When an Instructor is refreshed, associated InstructorDetail will also be refreshed.
     * - DETACH: When an Instructor is detached, associated InstructorDetail will also be detached.
     *
     * The @JoinColumn annotation is used to specify the mapping of the foreign key column in the
     * Instructor table to the primary key column in the referenced table (InstructorDetail).
     * - name: Specifies the name of the foreign key column in the Instructor table.
     * - referencedColumnName: Specifies the name of the primary key column in the referenced table (InstructorDetail).
     *
     * @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id") - this annotation specifies the column
     * (instructor_detail_id) in the Instructor table that is used as a foreign key to establish the relationship.
     * The foreign key column is linked to the primary key column (id) in the InstructorDetail table
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    // This private field represents an instance of the related entity (InstructorDetail).
    private InstructorDetail instructorDetail;

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

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    public void updateInstructorDetail(String youtubeChannel, String hobby) {
        if (instructorDetail == null) {
            instructorDetail = new InstructorDetail();
        }

        instructorDetail.setYoutubeChannel(youtubeChannel);
        instructorDetail.setHobby(hobby);
    }

}