package com.m3.training.SQLObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FILM_TEXT")
public class FilmText implements DatabaseObject{
	
	@Column(name="FILE_ID")
	private long filmId;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FilmText{" +
				"filmId=" + filmId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
