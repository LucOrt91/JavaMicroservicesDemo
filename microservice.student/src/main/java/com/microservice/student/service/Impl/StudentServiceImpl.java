package com.microservice.student.service.Impl;

import com.microservice.student.entity.Student;
import com.microservice.student.persistence.StudenteRepository;
import com.microservice.student.service.IStudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studenteRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studenteRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studenteRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studenteRepository.findAllByCourseId(idCourse);
    }
}
