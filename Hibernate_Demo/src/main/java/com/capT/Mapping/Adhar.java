package com.capT.Mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Adhar {
	@Id
	private int id;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String loc) {
		this.location = loc;
	}
}
