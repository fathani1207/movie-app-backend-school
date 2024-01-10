package com.example.moviebackend.controller;

import com.example.moviebackend.dao.CommentDao;
import com.example.moviebackend.entities.Comment;
import com.example.moviebackend.service.CommentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public List<Comment> getCommentsByMovie(@PathVariable("id") long movie_id){
        return this.commentService.getCommentsByMovie(movie_id);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return this.commentService.save(comment);
    }

    @DeleteMapping
    public void deleteComment(@PathParam("id") long id){
        this.commentService.deleteById(id);
    }


}
