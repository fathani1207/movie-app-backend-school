package com.example.moviebackend.controller;


import com.example.moviebackend.dao.MovieDao;
import com.example.moviebackend.dao.PersonDao;
import com.example.moviebackend.entities.Movie;
import com.example.moviebackend.entities.Person;
import com.example.moviebackend.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonService personService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PersonController(PersonDao personDao, PersonService personService, BCryptPasswordEncoder passwordEncoder) {
        this.personDao = personDao;
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") long id) {
        return this.personDao.findById(id).get();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Person person) {
        Person person1 = this.personDao.findByUsername(person.getUsername());

        if (person1 == null) {
            return ResponseEntity.status(401).body("Invalid username");
        }

        if (!passwordEncoder.matches(person.getPassword(), person1.getPassword())) {
            return ResponseEntity.status(402).body("Invalid password");
        }
        return ResponseEntity.ok(person1);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        try {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            Person savedPerson = personDao.save(person);
            return ResponseEntity.ok(savedPerson);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
    }

    @PutMapping("/{id}")
    public Person modifyPerson(@PathVariable("id") long id, @RequestBody Person person) {
        Person person1 = this.personDao.findById(id).get();
        person1.setCommentList(person.getCommentList());
        person1.setName(person.getName());
        person1.setFavoriteList(person.getFavoriteList());
        this.personDao.save(person1);
        return this.personDao.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") long id) {
        this.personDao.deleteById(id);
    }

    @PostMapping("favorite/{id}")
    public Person addFavorite(@PathVariable("id") long person_id, @RequestBody Movie movie) {
        this.personService.addFavorite(person_id, movie);
        return this.personDao.findById(person_id).get();
    }

    @DeleteMapping("favorite/{id}")
    public Person deleteFavoriteMovie(@PathVariable("id") long person_id, @PathParam("movie_id") long movie_id) {
        this.personService.deleteFavoriteMovie(person_id, movie_id);
        return this.personDao.findById(person_id).get();
    }
}
