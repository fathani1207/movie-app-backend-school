package com.example.moviebackend.dao;

import com.example.moviebackend.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Long> {
    Person findByUsername(String username);
}
