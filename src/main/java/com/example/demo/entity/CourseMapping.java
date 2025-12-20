package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Table(name="course_mappings")
@Entity
public class CourseMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_course_id", nullable = false)
    private Course sourceCourse;

    @ManyToOne
    @JoinColumn(name = "target_course_id", nullable = false)
    private Course targetCourse;

    private String equivalencyType;
    private String minGradeRequired;

    public CourseMapping(Course sourceCourse, Course targetCourse, String equivalencyType, String minGradeRequired) {
        this.sourceCourse = sourceCourse;
        this.targetCourse = targetCourse;
        this.equivalencyType = equivalencyType;
        this.minGradeRequired = minGradeRequired;
    }
}
