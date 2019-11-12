package com.orange.mediastore.repository;

import com.orange.mediastore.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends MongoRepository<Media, String> {
    List<Media> findAllByTitleMatchesRegex(String title);
}
