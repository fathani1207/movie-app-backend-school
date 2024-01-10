package com.example.moviebackend.service;

import com.example.moviebackend.dao.FavoriteDao;
import com.example.moviebackend.dao.MovieDao;
import com.example.moviebackend.dao.PersonDao;
import com.example.moviebackend.entities.Favorite;
import com.example.moviebackend.entities.FavoriteId;
import com.example.moviebackend.entities.Movie;
import com.example.moviebackend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{

    private final PersonDao personDao;
    private final MovieDao movieDao;
    private final FavoriteDao favoriteDao;

    @Autowired
    public PersonServiceImp(PersonDao personDao, MovieDao movieDao, FavoriteDao favoriteDao) {
        this.personDao = personDao;
        this.movieDao = movieDao;
        this.favoriteDao = favoriteDao;
    }

    @Override
    public void addFavorite(long person_id, Movie movie) {
        this.movieDao.save(movie);
        Person person = this.personDao.findById(person_id).get();
        Favorite favorite = new Favorite(person,movie);
        System.out.println(favorite);
        this.favoriteDao.save(favorite);
    }

    @Override
    public void deleteFavoriteMovie(long person_id, long movie_id){
        this.favoriteDao.deleteById(new FavoriteId(movie_id,person_id));
    }
}
