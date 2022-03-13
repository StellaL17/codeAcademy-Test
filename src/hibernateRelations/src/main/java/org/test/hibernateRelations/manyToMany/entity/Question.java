package org.test.hibernateRelations.manyToMany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="question_manytomany")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="question")
	private String question;
	
	@ManyToMany(targetEntity = org.test.hibernateRelations.manyToMany.entity.Answer.class, cascade = CascadeType.ALL)
	@JoinTable(name="question_answers", joinColumns = { 
			@JoinColumn(name="question_id")},
	inverseJoinColumns = {@JoinColumn(name="answer_id")})
	private List<Answer> answers;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public Question(String question) {
		super();
		this.question = question;
	}


	public Question() {
		super();
	}
	
	
	

}
