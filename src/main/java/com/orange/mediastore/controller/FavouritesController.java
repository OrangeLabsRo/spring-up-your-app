package com.orange.mediastore.controller;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.service.FavouritesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.orange.mediastore.configuration.MediaConstants.API_V1;

@RestController
@RequestMapping(API_V1)
public class FavouritesController {

    private FavouritesService favouritesService;

    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @GetMapping(value = "/favourites")
    public Set<Media> getFavourites() {
        return favouritesService.getFavourites();
    }

    public void addToFavourites(String mediaId) {

    }

    public void removeFromFavourites(String mediaId) {

    }
}
