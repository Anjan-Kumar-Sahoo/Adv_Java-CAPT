package JPAandHibernate;

import java.util.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "STU_Table")
public class Student {
	
	@EmbeddedId //composite Key
	private StudentID stuid;
	private String name;
	private int age;
	@Embedded //merging column
	private Address address;
	@ElementCollection // create table of this data
	private List<String> subjects;
	public StudentID getStuid() {
		return stuid;
	}
	public void setStuid(StudentID stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Student(StudentID stuid, String name, int age, Address address, List<String> subjects) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.subjects = subjects;
	}
	
	public Student()
	{
		
	}
	
}
