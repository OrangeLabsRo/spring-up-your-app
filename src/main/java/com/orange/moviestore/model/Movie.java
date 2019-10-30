package com.orange.moviestore.model;

import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;

    private String title;

    private String director;

    private String year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
