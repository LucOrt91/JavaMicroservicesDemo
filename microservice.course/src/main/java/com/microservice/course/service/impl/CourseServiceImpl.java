package com.microservice.course.service.impl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import com.microservice.course.service.ICourseSerices;
import com.microservice.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseSerices {

    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        Course course =courseRepository.findById(idCourse).orElse(new Course());
        List<StudentDto> studentDtoList =studentClient.findAllStudentsByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .couserName(course.getName())
                .teacher(course.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }
}
