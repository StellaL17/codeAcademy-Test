package org.test.hibernateCompany.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DependentId implements Serializable {
	
	private Integer essn;
	
	private String dependentName;

	public Integer getEssn() {
		return essn;
	}

	public void setEssn(Integer essn) {
		this.essn = essn;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public DependentId(Integer essn, String dependentName) {
		super();
		this.essn = essn;
		this.dependentName = dependentName;
	}

	public DependentId() {
		super();
	}
	
}
