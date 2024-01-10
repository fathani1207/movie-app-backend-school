package com.example.moviebackend.service;

import com.example.moviebackend.dao.CommentDao;
import com.example.moviebackend.dao.MovieDao;
import com.example.moviebackend.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService{

    private final CommentDao commentDao;

    private final MovieDao movieDao;

    @Autowired
    public CommentServiceImp(CommentDao commentDao, MovieDao movieDao) {
        this.commentDao = commentDao;
        this.movieDao = movieDao;
    }

    @Override
    public List<Comment> getCommentsByMovie(long movie_id) {
        return this.commentDao.findCommentsByMovie_Id(movie_id);
    }

    @Override
    public Comment save(Comment comment) {
        this.movieDao.save(comment.getMovie());
        return this.commentDao.save(comment);
    }

    @Override
    public void deleteById(long id) {
        this.commentDao.deleteById(id);
    }
}
