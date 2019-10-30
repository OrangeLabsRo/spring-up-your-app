package com.orange.moviestore.controller;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.service.MovieService;

import java.util.List;

public class MovieController {
    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    public List<Movie> getMyMovies() {
        return service.getMovieList();
    }
}
