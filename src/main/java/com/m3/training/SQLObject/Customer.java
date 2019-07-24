package com.m3.training.SQLObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import oracle.sql.DATE;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="STORE_ID")
	private long storeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADDRESS_ID")
	private long addressId;
	
	@Column(name="ACTIVE")
	private char active;
	
	@Column(name="CREATE_DATE")
	private DATE createDate;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public char getActive() {
		return active;
	}
	public void setActive(char active) {
		this.active = active;
	}
	public DATE getCreateDate() {
		return createDate;
	}
	public void setCreateDate(DATE createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}


}
