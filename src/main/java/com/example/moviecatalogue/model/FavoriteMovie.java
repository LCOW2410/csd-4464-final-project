package com.example.moviecatalogue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FavoriteMovie {

    @Id
    private int id;
    private String title;
    private String posterPath;  // Make sure this is exactly "posterPath"

    public FavoriteMovie() {}

    public FavoriteMovie(int id, String title, String posterPath) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
