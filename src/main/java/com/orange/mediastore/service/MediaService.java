package com.orange.mediastore.service;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.repository.MediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    private MediaRepository mediaRepository;

    public List<Media> getMediaList() {
        return mediaRepository.findAll();
    }
}
