package com.orange.mediastore.controller;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.service.MediaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private MediaService service;

    public MovieController(MediaService service) {
        this.service = service;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getMyMovies() {
        return service.getMediaList();
    }
}
