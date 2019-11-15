package com.orange.moviestore.client;

import com.orange.moviestore.dtos.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "omdb-client", url = "${omdb.url}")
public interface OMDBClient {

    @GetMapping("/?apiKey={apiKey}&t={title}")
    MovieDto searchByTitle(@PathVariable("title") String title,
                           @PathVariable("apiKey") String apiKey);
}
