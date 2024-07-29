package com.microservice.course.controller;

import com.microservice.course.service.ICourseSerices;

import com.microservice.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseSerices courseSerices;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
        courseSerices.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses() {
        return ResponseEntity.ok(courseSerices.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseSerices.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseSerices.findStudentByIdCourse(idCourse));
    }
}
