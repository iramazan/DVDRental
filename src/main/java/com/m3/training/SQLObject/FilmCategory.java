package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="FILM_CATEGORY")

public class FilmCategory implements DatabaseObject {
    @Id
    @Column(name="FILM_ID")
    private long filmID;

    @Column(name="CATEGORY_ID")
    private long categoryID;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "filmID=" + filmID +
                ", categoryID=" + categoryID +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
