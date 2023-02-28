package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.models.Student;

import java.util.List;

/**
 * To handle all Student related operations
 *
 */
public interface StudentService {
    /**
     * To create a new student
     * @param student Student
     */
    void createStudent(Student student);

    /**
     * To find a student by Id
     * @param id Student Id
     * @return Student
     */
    Student findStudentById(Long id) throws StudentNotFoundException;

    /**
     * To find a Student by Name
     * @param name Student name
     * @return Student
     */
    Student findStudentByName(String name) throws StudentNotFoundException;

    /**
     *
     * To find all Students
     * @return list of Students
     */
    List<Student> findAllStudents();

    /**
     *
     * To update an excisting Student
     * @param student Student
     */
    void updateStudent(Student student) throws StudentNotFoundException;

    /**
     * To delete Student by Id
     * @param id School Id
     */
    void deleteStudentById(Long id) throws StudentNotFoundException;

    /**
     * To Restore a Student by ID
     * @param id Student Id
     */
    void restoreStudentById(Long id) throws StudentNotFoundException;
}