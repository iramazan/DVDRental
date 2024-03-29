package com.m3.training.SQLObject;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="RENTAL")
public class Rental implements DatabaseObject {

    @Id
    @Column(name="RENTAL_ID")
    private long rentalID;

    @Column(name="RENTAL_DATE")
    private Date rentalDate;

    @Column(name="INVENTORY_ID")
    private long inventoryID;

    @Column(name="CUSTOMER_ID")
    private long customerID;

    @Column(name="RETURN_DATE")
    private Date returnDate;

    @Column(name="STAFF_ID")
    private long staffID;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    /*@OneToMany
    @JoinColumn(name = "Rental_id")
    private List<Payment> payments;*/

    public long getRentalID() {
        return rentalID;
    }

    public void setRentalID(long rentalID) {
        this.rentalID = rentalID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public long getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(long inventoryID) {
        this.inventoryID = inventoryID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

  /*  public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }*/

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID=" + rentalID +
                ", rentalDate=" + rentalDate +
                ", inventoryID=" + inventoryID +
                ", customerID=" + customerID +
                ", returnDate=" + returnDate +
                ", staffID=" + staffID +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
