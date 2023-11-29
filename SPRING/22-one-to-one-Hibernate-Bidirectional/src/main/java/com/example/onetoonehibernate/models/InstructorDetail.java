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

    /*
     * Define a bidirectional one-to-one relationship with the "Instructor" entity.
     * This entity represents additional details about an instructor.
     *
     * - The "mappedBy" attribute specifies the inverse side of the relationship.
     * - The "mappedBy" refers to the "instructorDetail" property in the "Instructor" class.
     *   It indicates that the "instructorDetail" field in "Instructor" is the owning side of the relationship.
     *
     * - "cascade = CascadeType.ALL": When operations like persist, merge, remove, refresh, or detach
     *   are performed on this entity, they will be cascaded to the associated "Instructor" entity.
     *   For example, if you delete an "InstructorDetail," the associated "Instructor" will also be deleted.
     *   Without "cascade = CascadeType.ALL" if you delete an "InstructorDetail," the associated "Instructor"
     *   will not be deleted.
     *
     * - "fetch = FetchType.LAZY": Indicates that the associated "Instructor" entity will be fetched lazily,
     *   meaning it won't be loaded from the database until explicitly accessed.
     *
     * - In the "Instructor" entity, the "instructorDetail" field is the owning side.
     *
     * - The @JsonIgnore annotation is added to break the loop during JSON serialization.
     *   It prevents infinite recursion caused by the bidirectional relationship when serializing to JSON.
     */
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
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