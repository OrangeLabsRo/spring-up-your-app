package com.orange.moviestore;

import com.orange.moviestore.controller.MovieController;
import com.orange.moviestore.model.Movie;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class View {
    private MovieController movieController;

    public View(MovieController movieController) {
        this.movieController = movieController;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void printMovies() {
        final List<Movie> myMovies = movieController.getMyMovies();
        System.out.println("User Movies: ");
        for (int i = 0; i < myMovies.size(); i++) {
            System.out.println("\t" + i + ". " + myMovies.get(i).getTitle());
        }
    }
}
