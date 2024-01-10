package com.example.moviebackend.dao;

import com.example.moviebackend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Long> {
}
