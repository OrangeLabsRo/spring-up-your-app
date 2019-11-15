package com.orange.moviestore.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("movie-store")
public class MovieConfigurations {
    private String[] movieList;

    public String[] getMovieList() {
        return movieList;
    }

    public void setMovieList(String[] movieList) {
        this.movieList = movieList;
    }
}
