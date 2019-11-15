package com.orange.moviestore.controller;

import com.orange.moviestore.client.OMDBClient;
import com.orange.moviestore.dtos.MovieDto;
import com.orange.moviestore.model.Movie;
import com.orange.moviestore.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private MovieService movieService;

//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }
    private OMDBClient omdbClient;

    public MovieController(OMDBClient omdbClient) {
        this.omdbClient = omdbClient;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDto getDtos() {
        return omdbClient.searchByTitle("joker", "37a4cb");
    }
}
