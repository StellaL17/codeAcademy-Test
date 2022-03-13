package org.test.hibernateRelations.compositeKey.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentId implements Serializable{
	
	
	private Long id;
	
	
	private String index;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	public StudentId(Long id, String index) {
		super();
		this.id = id;
		this.index = index;
	}


	public StudentId() {
		super();
	}
	
	
	

}
