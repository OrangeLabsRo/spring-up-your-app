package com.orange.mediastore.service;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.model.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class FavouritesService {

    private UserService userService;

    private MediaService mediaService;

    public FavouritesService(UserService userService, MediaService mediaService) {
        this.userService = userService;
        this.mediaService = mediaService;
    }

    public Set<Media> getFavourites() {
        User user = userService.currentUser();
        Set<String> favouritesIds = user.getFavouritesIds();
        if(favouritesIds == null) {
            return Collections.emptySet();
        }
        return mediaService.getMoviesByIds(favouritesIds);
    }

    public void addToFavourites(String mediaId) {
        User user = userService.currentUser();
        Set<String> favouritesIds = user.getFavouritesIds();
        if(favouritesIds == null) {
            favouritesIds = new HashSet<>();
        }
        favouritesIds.add(mediaId);
        user.setFavouritesIds(favouritesIds);
        userService.save(user);
    }

    public void remove(String mediaId) {
        User user = userService.currentUser();
        Set<String> favouritesIds = user.getFavouritesIds();
        if(favouritesIds == null) {
            return;
        }
        if(favouritesIds.remove(mediaId)) {
            user.setFavouritesIds(favouritesIds);
            userService.save(user);
        }
    }
}
