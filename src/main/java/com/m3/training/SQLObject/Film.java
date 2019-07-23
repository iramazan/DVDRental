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

    @Column(name="DESCRIPTION")
    private Clob description;

    @Column(name="RELEASE_YEAR")
    private long releaseYear;

    @Column(name="LANGUAGE_ID")
    private long languageID;

    @Column(name="ORIGINAL_LANGUAGE_ID")
    private long originalLanguageID;

    @Column(name="RENTAL_DURATION")
    private long rentalDuration;

    @Column(name="RENTAL_RATE")
    private long rentalRate;

    @Column(name="LENGTH")
    private long length;

    @Column(name="REPLACEMENT_COST")
    private long replacementCost;

    @Column(name="RATING")
    private long rating;

    @Column(name="SPECIAL_FEATURES")
    private long specialFeatures;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    @ManyToMany
    @JoinTable (
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

    public Clob getDescription() {
        return description;
    }

    public void setDescription(Clob description) {
        this.description = description;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
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

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(long replacementCost) {
        this.replacementCost = replacementCost;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(long specialFeatures) {
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

    public List<Actor> getFilmsCategories() {
        return filmsCategories;
    }

    public void setFilmsCategories(List<Actor> filmsCategories) {
        this.filmsCategories = filmsCategories;
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
