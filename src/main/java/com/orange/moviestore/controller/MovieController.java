package com.orange.moviestore.controller;

import com.orange.moviestore.client.OMDBClient;
import com.orange.moviestore.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
//    private MovieService movieService;

//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    private OMDBClient omdbClient;

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }
}
