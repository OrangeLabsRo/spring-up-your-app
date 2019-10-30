package com.orange.moviestore.controller;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMyMovies() {
        return service.getMovieList();
    }
}
