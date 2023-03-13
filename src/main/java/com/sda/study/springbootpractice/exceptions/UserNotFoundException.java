package com.sda.study.springbootpractice.exceptions;

public class UserNotFoundException extends Exception {


        private static final long serialVersionUID = 1L;

        public UserNotFoundException(String username) {
            super(String.format("User not found for username: %s", username));
        }

    }

