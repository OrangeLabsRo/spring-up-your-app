package com.orange.moviestore.service;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.repository.MovieRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledMovieRetriever {
    private OMDBDownloader downloader;
    private MovieRepository repository;

    public ScheduledMovieRetriever(OMDBDownloader downloader, MovieRepository repository) {
        this.downloader = downloader;
        this.repository = repository;
    }

    @Scheduled(fixedRateString = "45000")
    public void fillDb() {
        System.out.println("ACUMA SE PUNE IN BAZA DE DATE, BAH!");
        List<Movie> allMovies = downloader.getAllMovies();
        for (Movie movie : allMovies) {
            try {
                repository.save(movie);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("EXISTA DEJA!!!!");
            }
        }
    }
}
