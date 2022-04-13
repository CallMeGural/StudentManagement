package student;

import java.sql.Date;

public class Student {
	int id;
	String name,surname;
	Date dob;
	String city;
	
	
	public Student() {}
	
	public Student(int id, String name, String surname,Date dob, String city) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.dob = dob;
	}
	
	public Student(String name, String surname, Date dob, String city) {
		super();
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.city = city;
	}

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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
