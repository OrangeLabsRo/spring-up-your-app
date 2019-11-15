package com.orange.moviestore.service;

import com.orange.moviestore.client.OMDBClient;
import com.orange.moviestore.configs.MovieConfigurations;
import com.orange.moviestore.dtos.MovieDto;
import com.orange.moviestore.dtos.RatingDto;
import com.orange.moviestore.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OMDBDownloader {
    private OMDBClient client;
    private String[] availableMovies;
    private String apiKey;

    public OMDBDownloader(
            OMDBClient client,
            MovieConfigurations configs,
            @Value("${omdb.api-key}") String apiKey) {

        this.client = client;
        availableMovies = configs.getMovieList();
        this.apiKey = apiKey;
    }

    public List<Movie> getAllMovies() {
        List<Movie> results = new ArrayList<>();

        for (String movieName : availableMovies) {
            MovieDto movieDto = client.searchByTitle(movieName, apiKey);
            Movie movie = new Movie();

            movie.setTitle(movieDto.title);
            movie.setDirector(movieDto.director);
            movie.setImageURL(movieDto.poster);
            //04 Oct 2019
            movie.setRelease(LocalDate.parse(
                    movieDto.released,
                    DateTimeFormatter.ofPattern("dd MMM yyyy")));
            movie.setActors(splitActors(movieDto));
            movie.setAverageRating(calculateAverageRating(movieDto));

            results.add(movie);
        }

        return results;
    }

    private double calculateAverageRating(MovieDto movieDto) {
        double sum = 0;
        for (RatingDto ratingDto : movieDto.ratingDtos) {
            sum = sum + parseAndNormalizeRating(ratingDto.value);
        }

        return sum / movieDto.ratingDtos.size();
    }

    private double parseAndNormalizeRating(String rating) {
        double value;
        if (rating.endsWith("%")) {
            value = Double.parseDouble(rating.substring(0, rating.length() - 1));
        } else if (rating.contains("/")) {
            String[] split = rating.split("/");
            double score = Double.parseDouble(split[0]);
            double maxScore = Double.parseDouble(split[1]);
            value = score * (100 / maxScore);
        } else {
            value = Double.parseDouble(rating);
        }
        return value;
    }

    private Set<String> splitActors(MovieDto movieDto) {
        Set<String> actorsSet = new HashSet<>();

        String[] splitActors = movieDto.actors.split(", ");
        actorsSet.addAll(Arrays.asList(splitActors));
        return actorsSet;
    }
}
