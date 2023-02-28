package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.models.Course;
import com.sda.study.springbootpractice.models.School;

import java.util.List;


/**
 * Interface to handle all Course related operations
 * CRUD - create, read, update, delete + restore(extra)
 */

public interface CourseService {

    /**
     * To create a new course
     * @param course Course
     */
    void createCourse(Course course);

    /**
     * To find a course by id
     * @param id Course id
     * @return Course
     */
    Course findCourseById(Long id) throws CourseNotFoundException;

    /**
     * To find a course by a name
     * @param name Course name
     * @return Course
     */
    Course findCourseByName(String name) throws CourseNotFoundException;

    /**
     * To find all courses
     * @return List of courses
     */
    List<Course> findAllCourses();

    /**
     * To find all courses by school
     * @param school School
     * @return List of courses
     */
    List<Course> findAllCoursesBySchool (School school);

    /**
     * To update an existing course
     * @param course
     */
    void updateCourse(Course course) throws CourseNotFoundException;

    /**
     * To delete a course by ID
     * @param id course ID
     */
    void deleteCourseById(Long id) throws CourseNotFoundException;

    /**
     * To restore a course by ID
     * @param id Course ID
     */
    void restoreCourseById(Long id) throws CourseNotFoundException;
}
