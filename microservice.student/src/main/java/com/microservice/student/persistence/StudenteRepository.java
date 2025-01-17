package com.microservice.student.persistence;

import com.microservice.student.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenteRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByCourseId(Long idCourse);
}
