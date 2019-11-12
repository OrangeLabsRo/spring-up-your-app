package com.orange.mediastore.service;

import com.orange.mediastore.model.Movie;
import com.orange.mediastore.repository.MovieRepository;
import org.springframework.stereotype.Service;

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
