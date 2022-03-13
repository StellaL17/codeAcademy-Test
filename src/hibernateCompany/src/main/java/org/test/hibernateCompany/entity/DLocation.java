package org.test.hibernateCompany.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DLocation implements Serializable {
	
	private Integer dNumber;
	
	private String dLocation;

	public Integer getdNumber() {
		return dNumber;
	}

	public void setdNumber(Integer dNumber) {
		this.dNumber = dNumber;
	}

	public String getdLocation() {
		return dLocation;
	}

	public void setdLocation(String dLocation) {
		this.dLocation = dLocation;
	}

	public DLocation(Integer dNumber, String dLocation) {
		super();
		this.dNumber = dNumber;
		this.dLocation = dLocation;
	}

	public DLocation() {
		super();
	}
	

}
