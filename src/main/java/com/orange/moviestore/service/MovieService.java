package com.orange.moviestore.service;

import com.orange.moviestore.model.Movie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    public List<Movie> getMovieList() {
        Movie movie1 = new Movie();
        movie1.setTitle("Titanic");
        movie1.setYear("1997");
        movie1.setDirector("James Cameron");

        Movie movie2 = new Movie();
        movie2.setTitle("Matrix");
        movie2.setYear("1999");
        movie2.setDirector("Wachovski");

        return Arrays.asList(movie1, movie2);
    }
}
