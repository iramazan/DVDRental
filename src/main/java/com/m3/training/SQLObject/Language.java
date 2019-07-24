package com.m3.training.SQLObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="LANGUAGE")
public class Language {

	@Column(name="LANGUAGE_ID")
	private long languageId;
	
	@Column(name="LANGUAGE")
	private String language;
	
    @UpdateTimestamp
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Language{" +
				"languageId=" + languageId +
				", language='" + language + '\'' +
				", lastUpdate=" + lastUpdate +
				'}';
	}
}
