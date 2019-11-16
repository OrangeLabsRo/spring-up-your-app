package com.orange.mediastore.service;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.model.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

}
