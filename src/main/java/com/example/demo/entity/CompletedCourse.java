package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CompletedCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String grade;
    private Double credits;

    public CompletedCourse() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Double getCredits() {
        return credits;
    }
}