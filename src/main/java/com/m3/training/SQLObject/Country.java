package com.m3.training.SQLObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="COUNTRY")
public class Country implements DatabaseObject {

	@Id
	@Column(name="COUNTRY_ID")
	private long country_id;
	
	@Column(name="country")
	private String country;
	
    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;
    
	public long getCountry_id() {
		return country_id;
	}
	public void setCountry_id(long country_id) {
		this.country_id = country_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
