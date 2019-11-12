package com.orange.mediastore.client;


import com.orange.mediastore.dtos.MediaDto;
import com.orange.mediastore.dtos.SeasonEpisodesDto;

public interface OMDBClient {

    MediaDto searchByTitle(String title, String key);

    SeasonEpisodesDto getSeasonEpisodesById(String mediaId, Integer seasonNumber, String key);
}
