package app;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String education;
	
	private String skills;
	
	private String interests;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personId", nullable = false)
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public UserProfile(String education, String skills, String interests, Person person) {
		super();
		this.education = education;
		this.skills = skills;
		this.interests = interests;
		this.person = person;
	}

	public UserProfile() {
		super();
	}
	
	

}
