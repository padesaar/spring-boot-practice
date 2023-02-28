package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.TeacherNotFoundException;
import com.sda.study.springbootpractice.models.Teacher;

import java.util.List;

/**
 * Interface to handle all School related operations
 * CRUD - create, read, update, delete + restore(extra)
 */

public interface TeacherService {

    /**
     * To create a new teacher
     * @param teacher Teacher
     */
    void createTeacher(Teacher teacher);

    /**
     * To find a teacher by id
     *
     * @param id Teacher id
     * @return Teacher
     */
    Teacher findTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To find a teacher by a name
     *
     * @param name Teacher name
     * @return Teacher
     */
    Teacher findTeacherByName(String name) throws TeacherNotFoundException;

    /**
     * To find all teachers
     * @return List of teachers
     */
    List<Teacher> findAllTeachers();

    /**
     * To update an existing teacher
     * @param teacher
     */
    void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

    /**
     * To delete a teacher by ID
     * @param id Teacher ID
     */
    void deleteTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To restore a teacher by ID
     * @param id Teacher ID
     */
    void restoreTeacherById(Long id) throws TeacherNotFoundException;
}