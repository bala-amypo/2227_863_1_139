package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(Course course) {

        if (course.getCredits() == null || course.getCredits() <= 0) {
            throw new ValidationException("Credits must be greater than 0");
        }

        if (courseRepository.existsByCodeIgnoreCase(course.getCode())) {
            throw new ValidationException("Course code already exists");
        }

        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {

        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));
    }

    @Override
    public Course getCourseByCode(String code) {

        return courseRepository.findByCodeIgnoreCase(code)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));
    }
}
