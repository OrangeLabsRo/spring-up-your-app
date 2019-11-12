package com.orange.mediastore.controller;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.service.MediaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MediaController {
    private MediaService service;

    public MediaController(MediaService service) {
        this.service = service;
    }

    @GetMapping(value = "/GetMedia", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getMyMedia(@RequestParam(required = false) String title) {
        if (title != null) {
            return service.getMediaByTitle(title);
        }

        return service.getMediaList();
    }
}
