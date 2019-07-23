package com.m3.training.SQLObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Column(name = "ADDRESS_ID")
	private long addressId;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "distrinct")
	private String distrinct;

	@Column(name = "CITY_ID")
	private long cityId;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "PHONE")
	private String phone;

    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrinct() {
		return distrinct;
	}

	public void setDistrinct(String distrinct) {
		this.distrinct = distrinct;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
