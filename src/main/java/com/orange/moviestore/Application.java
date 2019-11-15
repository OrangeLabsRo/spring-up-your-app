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
        SpringApplication.run(Application.class,args);
    }

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setId("1");
        movie1.setTitle("Titatnic");
        movie1.setDirector("James Cameron");
        movie1.setYear(1999L);

        Movie movie2 = new Movie();
        movie2.setId("2");
        movie2.setTitle("Matirx");
        movie2.setDirector("WAtchauskiaskfnals");
        movie2.setYear(2001L);

        movieRepository.save(movie1);
        movieRepository.save(movie2);
    }
}
