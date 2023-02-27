package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;

import java.util.List;

/**
 * Interface to handle all School related operations
 * CRUD - create, read, update, delete + restore(extra)
 */

public interface SchoolService {

    /**
     * To create a new school
     * @param school School
     */
    void createSchool(School school);

    /**
     * To find a school by id
     * @param id Shcool id
     * @return School
     */
    School findSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To find a school by a name
     * @param name School name
     * @return School
     */
    School findSchoolByName(String name) throws SchoolNotFoundException;

    /**
     * To find all schools
     * @return List of schools
     */
    List<School> findAllSchools();

    /**
     * To update an existing school
     * @param school
     */
    void updateSchool(School school) throws SchoolNotFoundException;

    /**
     * To delete a school by ID
     * @param id School ID
     */
    void deleteSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To restore a school by ID
     * @param id School ID
     */
    void restoreSchoolById(Long id) throws SchoolNotFoundException;
}
