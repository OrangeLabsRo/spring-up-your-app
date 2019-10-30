package com.orange.moviestore;

import com.orange.moviestore.model.Movie;
import com.orange.moviestore.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    MovieRepository movieRepository;

    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setTitle("Titanic");
        movie1.setYear("1997");
        movie1.setDirector("James Cameron");

        Movie movie2 = new Movie();
        movie2.setTitle("Matrix");
        movie2.setYear("1999");
        movie2.setDirector("Wachovski");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
    }
}