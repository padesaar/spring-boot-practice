package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.Student;
import com.sda.study.springbootpractice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByName(String name);
}
