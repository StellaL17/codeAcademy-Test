package org.test.hibernateRelations.oneToOne.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="street", nullable = false)
	private String street;
	
	@Column(name="number")
	private String number;
	
	@Column(name="city")
	private String city;
	
	@OneToOne(targetEntity = org.test.hibernateRelations.oneToOne.entity.Student.class, cascade = CascadeType.ALL)
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address(String street, String number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}

	public Address() {
		super();
	}
	
	


	
	
	

}
