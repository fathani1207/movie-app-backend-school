package com.example.moviebackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Favorite {

    @EmbeddedId
    private FavoriteId favoriteId;

    @ManyToOne
    @MapsId("person_id")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @MapsId("movie_id")
    @JoinColumn(name = "movie_id")
    Movie movie;

    public Favorite(){}

    public Favorite(Person person, Movie movie) {
        this.person = person;
        this.movie = movie;
        this.favoriteId = new FavoriteId(this.movie.getId(),this.person.getId());
    }

    @JsonIgnore
    public FavoriteId getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(FavoriteId favoriteId) {
        this.favoriteId = favoriteId;
    }

    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId=" + favoriteId +
                ", person=" + person +
                ", movie=" + movie +
                '}';
    }
}
