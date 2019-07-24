package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STORE")
public class Store implements DatabaseObject {
    @Id
    @Column(name="STORE_ID")
    private long storeID;

    @Column(name="MANAGER_STAFF_ID")
    private long managerStaffID;

    @Column(name="ADDRESS_ID")
    private long addressID;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    @ManyToMany
    @JoinTable (
            name = "inventory",
            joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private List<Film> films = new ArrayList<>();

    public long getStoreID() {
        return storeID;
    }

    public void setStoreID(long storeID) {
        this.storeID = storeID;
    }

    public long getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(long managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public long getAddressID() {
        return addressID;
    }

    public void setAddressID(long addressID) {
        this.addressID = addressID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeID=" + storeID +
                ", managerStaffID=" + managerStaffID +
                ", addressID=" + addressID +
                ", lastUpdate=" + lastUpdate +
                ", films=" + films +
                '}';
    }
}
