package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table

public class Store {
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

    @Column(name="REGION")
    private String region;

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
