package com.capT.Injections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	@Value("1")
	private int id;
	@Value("Anjan")
	private String name;
	@Autowired
	private AdharCard card;
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
	public AdharCard getCard() {
		return card;
	}
	public void setCard(AdharCard card) {
		this.card = card;
	}
}
