package com.m3.training.SQLObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="CITY")
public class City implements DatabaseObject {
	
	@Id
	@Column(name="CITY_ID")
	private long cityId;
	
	@Column(name="CITY")
	private String name;
	
	@Column(name="COUNTRY_ID")
	private int countryId;
	
    @UpdateTimestamp
    @Column(name=
    "LAST_UPDATE")
    private Date lastUpdate;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "City{" +
				"cityId=" + cityId +
				", name='" + name + '\'' +
				'}';
	}
}
