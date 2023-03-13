package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.AuthorityNotFoundException;
import com.sda.study.springbootpractice.models.Authority;

import java.util.List;

public interface AuthorityService {


    /**
     * To find all authorities
     * @return list of authorities
     */
    List<Authority> findAllAuthorities();

    /**
     * To find authority by name
     * @param name authority name
     * @return Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;


    /**
     * To create an authority
     * @param authority Authority
     */
    void createAuthority(Authority authority);

}
