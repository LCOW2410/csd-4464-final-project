package com.example.moviecatalogue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private int id;
    private String title;
    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("poster_path")
    private String posterPath;

    // Getters and possibly setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getOverview() { return overview; }
    public String getReleaseDate() { return releaseDate; }
    public double getVoteAverage() { return voteAverage; }
    public String getPosterPath() { return posterPath; }
}
