package com.capT.ExtraAnnotations;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="Book_Table")
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="Book_Name",  unique = true, nullable = false)
	private String name;
	@Column(updatable = false)
	private String author;
	@CreationTimestamp
	private LocalDate created_datetime;
	@UpdateTimestamp
	private LocalDate updated_datetime;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getCreated_datetime() {
		return created_datetime;
	}
	public LocalDate getUpdated_datetime() {
		return updated_datetime;
	}
}
