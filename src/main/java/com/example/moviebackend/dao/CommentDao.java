package com.example.moviebackend.dao;

import com.example.moviebackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {
    List<Comment> findCommentsByMovie_Id(long id);
}
