package org.test.hibernateCompany.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="dependent")
public class Dependent {
	
	@EmbeddedId
	private DependentId dependentId;

	@Column
	private char sex;
	
	@Column(name="Bdate")
	private Date bDate;
	
	@Column
	private String relationship;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("essn")
	private Employee employee; 

	public DependentId getDependentId() {
		return dependentId;
	}

	public void setDependentId(DependentId dependentId) {
		this.dependentId = dependentId;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Dependent(DependentId dependentId, char sex, Date bDate, String relationship) {
		super();
		this.dependentId = dependentId;
		this.sex = sex;
		this.bDate = bDate;
		this.relationship = relationship;
	}

	public Dependent() {
		super();
	}

}
