package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseSerices {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCourseResponse findStudentByIdCourse(Long idCourse);
}