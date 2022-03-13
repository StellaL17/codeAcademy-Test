package org.test.student;

public class StudentInfo {
	
	private String name;
	private String surname;
	private String street;
	private String number;
	private String city;
	
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public StudentInfo(String name, String suname, String street, String number, String city) {
		super();
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.number = number;
		this.city = city;
	}
	
	public StudentInfo() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentInfo [name=" + name + ", surname=" + surname + ", street=" + street + ", number=" + number
				+ ", city=" + city + "]";
	}
	
	

}
