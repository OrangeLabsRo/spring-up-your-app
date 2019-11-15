package com.orange.moviestore.controller;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.service.OMDBDownloader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private OMDBDownloader downloader;

    public MovieController(OMDBDownloader downloader) {
        this.downloader = downloader;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies() {
        return downloader.getAllMovies();
    }
}
