package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudenteService studenteService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studenteService.save(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studenteService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(studenteService.findAll());
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findStudentsByCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studenteService.findByIdCourse(idCourse));
    }
}
