package com.orange.moviestore.service;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private MovieRepository movieRepository;

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }
}
