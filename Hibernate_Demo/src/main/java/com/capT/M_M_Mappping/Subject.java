package com.capT.M_M_Mappping;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany
	List<Trainer> trainers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public Subject(int id, String name, List<Trainer> trainers) {
		super();
		this.id = id;
		this.name = name;
		this.trainers = trainers;
	}
	
	
	
}
