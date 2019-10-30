package com.orange.moviestore;

import com.orange.moviestore.controller.MovieController;
import com.orange.moviestore.model.Movie;

import java.util.List;

public class View {
    private MovieController movieController;

    public View(MovieController movieController) {
        this.movieController = movieController;
    }

    public void printMovies() {
        final List<Movie> myMovies = movieController.getMyMovies();
        System.out.println("User Movies: ");
        for (int i = 0; i < myMovies.size(); i++) {
            System.out.println("\t" + i + ". " + myMovies.get(i).getTitle());
        }
    }
}
