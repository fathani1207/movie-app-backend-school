package com.example.moviebackend.entities;


import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FavoriteId implements Serializable {
    private long movie_id;

    private long person_id;

    public FavoriteId() {
    }

    public FavoriteId(long movie_id, long person_id) {
        this.movie_id = movie_id;
        this.person_id = person_id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "FavoriteId{" +
                "movie_id=" + movie_id +
                ", person_id=" + person_id +
                '}';
    }
}
