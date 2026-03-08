package com.capT.StudentMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(nullable = false, unique = true)
	private String email;
	private String course;
	private double marks;
	@Lob
	private byte[] profileImage;
	@Lob
	private byte[] assignmentFile;
	private String role;
	private String password;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public byte[] getAssignmentFile() {
		return assignmentFile;
	}
	public void setAssignmentFile(byte[] assignmentFile) {
		this.assignmentFile = assignmentFile;
	}
	public int getId() {
		return id;
	}
	
	
}
