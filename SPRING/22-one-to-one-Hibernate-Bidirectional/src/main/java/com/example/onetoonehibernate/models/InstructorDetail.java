package com.example.onetoonehibernate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Entity class representing additional details about an instructor.
 * This class is mapped to the "instructor_detail" table in the database.
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // Define a bidirectional one-to-one relationship with the "Instructor" entity.
    // This entity represents additional details about an instructor.
    // The "mappedBy" attribute specifies the inverse side of the relationship.
    // The "mappedBy" refer to "instructorDetail" property in "Instructor" class.
    // Can add "cascade = CascadeType.ALL" or something like that, then when you delete
    // InstructorDetail you also can delete Instructor.
    @OneToOne(mappedBy = "instructorDetail")
    // In the "Instructor" entity, the "instructorDetail" field is the owning side.
    @JsonIgnore  // Add this annotation to break the loop during JSON serialization
    private Instructor instructor;



    public InstructorDetail() {}

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}