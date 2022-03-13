package org.test.hibernateCompany.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	private Integer ssn;
	
	@Column(nullable = false)
	private String fName;
	
	@Column
	private char minit;
	
	@Column(nullable = false)
	private String lName;
	
	@Column
	private Date birthDate;
	
	@Column(length = 30)
	private String address;
	
	@Column
	private char sex;
	
	@Column
	private double salary;
	
	@Column
	private Integer superSsn;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public char getMinit() {
		return minit;
	}

	public void setMinit(char minit) {
		this.minit = minit;
	}

	public Integer getSuperSsn() {
		return superSsn;
	}

	public void setSuperSsn(Integer superSsn) {
		this.superSsn = superSsn;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(Integer ssn, String fName, char minit, String lName, Date birthDate, String address, char sex,
			double salary, Integer superSsn) {
		super();
		this.ssn = ssn;
		this.fName = fName;
		this.minit = minit;
		this.lName = lName;
		this.birthDate = birthDate;
		this.address = address;
		this.sex = sex;
		this.salary = salary;
		this.superSsn = superSsn;
	}

	public Employee() {
		super();
	}
	

}
