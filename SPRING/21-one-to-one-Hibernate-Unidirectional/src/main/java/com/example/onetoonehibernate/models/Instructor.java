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

    // This annotation indicates a one-to-one relationship between the current entity and another entity.
    @OneToOne(cascade = CascadeType.ALL)
    // This annotation specifies the column to be used for the mapping of the related entity.
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