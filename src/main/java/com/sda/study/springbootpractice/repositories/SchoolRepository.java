package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
