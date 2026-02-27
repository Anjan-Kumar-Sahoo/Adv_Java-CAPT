package com.capT;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    private String name;
    private String cgpa;
    @Id
    private String id;
    private String collegeName;
    private String address;

    // Default Constructor (Required by Spring)
    public Student() {}

    // Getters and Setters (Required by Spring to inject data)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCgpa() { return cgpa; }
    public void setCgpa(String cgpa) { this.cgpa = cgpa; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

}
