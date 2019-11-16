package com.orange.mediastore.controller;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.service.FavouritesService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/favourites")
    public void addToFavourites(@RequestParam String mediaId) {
        favouritesService.addToFavourites(mediaId);
    }

    @DeleteMapping(value = "/favourites")
    public void removeFromFavourites(@RequestParam String mediaId) {
        favouritesService.remove(mediaId);
    }
}
