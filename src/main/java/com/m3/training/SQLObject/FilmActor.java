package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="FILM_ACTOR")

public class FilmActor implements DatabaseObject {
    @Id
    @Column(name="ACTOR_ID")
    private long actorID;

    @Column(name="FILM_ID")
    private long filmID;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    public long getActorID() {
        return actorID;
    }

    public void setActorID(long actorID) {
        this.actorID = actorID;
    }

    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actorID=" + actorID +
                ", filmID=" + filmID +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
