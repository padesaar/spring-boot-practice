package com.sda.study.springbootpractice.exceptions;

public class AuthorityNotFoundException extends Exception {

        private static final long serialVersionUID = 1L;

        public AuthorityNotFoundException(String name) {
            super(String.format("User not found for username: %s", name));
        }

    }

