package com.example.moviebackend.dao;

import com.example.moviebackend.entities.Favorite;
import com.example.moviebackend.entities.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteDao extends JpaRepository<Favorite, FavoriteId> {

}
