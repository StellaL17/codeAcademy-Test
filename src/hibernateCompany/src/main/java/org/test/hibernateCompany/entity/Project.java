package org.test.hibernateCompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	private Integer pNumber;
	
	@Column(unique = true, nullable = false)
	private String pName;
	
	@Column
	private String pLocation;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpNumber() {
		return pNumber;
	}

	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}

	public String getpLocation() {
		return pLocation;
	}

	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}

	public Project(Integer pNumber, String pName, String pLocation) {
		super();
		this.pNumber = pNumber;
		this.pName = pName;
		this.pLocation = pLocation;
	}

	public Project() {
		super();
	}

}
