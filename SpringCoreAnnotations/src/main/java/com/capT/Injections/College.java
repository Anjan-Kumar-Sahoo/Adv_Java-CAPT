package com.capT.Injections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "MyCollege")
public class College {
	@Value("101")
	private int id;
	private String name;
	private String location;
	private String departemnt;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDepartemnt() {
		return departemnt;
	}
	@Value("B.Tech. CSE")
	public void setDepartemnt(String departemnt) {
		this.departemnt = departemnt;
	}
	public College(@Value("LPU") String name, @Value("Phagwara")String location) {
		
		this.name = name;
		this.location = location;	
	}	
}