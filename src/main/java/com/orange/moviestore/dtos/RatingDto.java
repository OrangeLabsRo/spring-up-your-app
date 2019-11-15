package com.orange.moviestore.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingDto {
    @JsonProperty("Source")
    public String source;
    @JsonProperty("Value")
    public String value;
}
