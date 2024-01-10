package com.example.moviebackend.service;


import com.example.moviebackend.entities.Movie;

public interface PersonService {
    void addFavorite(long person_id, Movie movie);
    void deleteFavoriteMovie(long person_id, long movie_id);
}
