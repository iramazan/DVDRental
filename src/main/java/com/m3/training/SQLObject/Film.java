package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FILM")
public class Film implements DatabaseObject{
    @Id
    @Column(name="FILM_ID")
    private long filmID;

    @Column(name="TITLE")
    private String title;

    @Lob
    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="RELEASE_YEAR")
    private String releaseYear;

    @Column(name="LANGUAGE_ID")
    private long languageID;

    @Column(name="ORIGINAL_LANGUAGE_ID")
    private Long originalLanguageID;

    @Column(name="RENTAL_DURATION")
    private long rentalDuration;

    @Column(name="RENTAL_RATE")
    private long rentalRate;

    @Column(name="LENGTH")
    private Long length;

    @Column(name="REPLACEMENT_COST")
    private long replacementCost;

    @Column(name="RATING")
    private String rating;

    @Column(name="SPECIAL_FEATURES")
    private String specialFeatures;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private List<Actor> filmsActors = new ArrayList<>();

    @ManyToMany
    @JoinTable (
            name = "film_category",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Actor> filmsCategories = new ArrayList<>();

    @ManyToMany(mappedBy = "films")
    private List<Store> storesWithThisFilm = new ArrayList<>();

    public List<Actor> getActors() {
        return filmsActors;
    }

    public void setActors(List<Actor> actors) {
        this.filmsActors = actors;
    }

    public List<Actor> getCategories() {
        return this.filmsCategories;
    }

    public void setCategories(List<Actor> categories) {
        this.filmsCategories = categories;
    }

    public List<Store> getStores() {
        return storesWithThisFilm;
    }

    public void setStores(List<Store> stores) {
        this.storesWithThisFilm = stores;
    }

    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public long getLanguageID() {
        return languageID;
    }

    public void setLanguageID(long languageID) {
        this.languageID = languageID;
    }

    public long getOriginalLanguageID() {
        return originalLanguageID;
    }

    public void setOriginalLanguageID(long originalLanguageID) {
        this.originalLanguageID = originalLanguageID;
    }

    public long getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(long rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public long getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(long rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public long getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(long replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Actor> getFilmsActors() {
        return filmsActors;
    }

    public void setFilmsActors(List<Actor> filmsActors) {
        this.filmsActors = filmsActors;
    }

    public List<Store> getStoresWithThisFilm() {
        return storesWithThisFilm;
    }

    public void setStoresWithThisFilm(List<Store> storesWithThisFilm) {
        this.storesWithThisFilm = storesWithThisFilm;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
