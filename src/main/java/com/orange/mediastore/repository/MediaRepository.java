package com.orange.mediastore.repository;

import com.orange.mediastore.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<Media, String> {
}
