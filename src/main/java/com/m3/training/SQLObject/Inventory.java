package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="INVENTORY")
public class Inventory implements DatabaseObject {

    @Id
    @Column(name="INVENTORY_ID")
    private long inventoryID;

    @Column(name="FILM_ID")
    private long filmID;

    @Column(name="STORE_ID")
    private long storeID;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    public long getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(long inventoryID) {
        this.inventoryID = inventoryID;
    }

    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public long getStoreID() {
        return storeID;
    }

    public void setStoreID(long storeID) {
        this.storeID = storeID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", filmID=" + filmID +
                ", storeID=" + storeID +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
