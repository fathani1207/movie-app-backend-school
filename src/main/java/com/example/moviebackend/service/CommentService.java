package com.example.moviebackend.service;

import com.example.moviebackend.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment>getCommentsByMovie(long movie_id);
    Comment save(Comment comment);
    void deleteById(long id);
}
