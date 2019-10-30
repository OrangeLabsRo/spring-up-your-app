package com.orange.moviestore;

import com.orange.moviestore.controller.MovieController;
import com.orange.moviestore.service.MovieService;

public class Application {

    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        MovieController movieController = new MovieController(movieService);
        View movieView = new View(movieController);

        movieView.printMovies();
    }

}