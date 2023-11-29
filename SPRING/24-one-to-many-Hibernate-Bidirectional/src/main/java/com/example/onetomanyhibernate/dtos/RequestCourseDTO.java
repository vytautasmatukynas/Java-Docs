package com.example.onetomanyhibernate.dtos;

public class RequestCourseDTO {

    private String title;

    public RequestCourseDTO() { }

    public RequestCourseDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "UpdateCourseDTO{" +
                "title='" + title + '\'' +
                '}';
    }
}
