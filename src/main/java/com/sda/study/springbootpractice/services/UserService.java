package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.UserNotFoundException;
import com.sda.study.springbootpractice.models.User;

import java.util.List;

public interface UserService {

    /**
     *
     * Find all users
     * @return List of users
     */
    List<User> findAllUsers();

    /**
     * To find user by username
     * @param username username
     * @return User
     */
    User findUserByUsername(String username) throws UserNotFoundException;

    /**
     * To create a new user
     * @param user User
     */
    void createUser(User user);

}
