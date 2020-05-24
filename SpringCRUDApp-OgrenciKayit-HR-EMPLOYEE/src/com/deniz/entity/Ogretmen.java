package com.deniz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "OGRETMEN")
public class Ogretmen {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_ogretmen",sequenceName = "OGRETMEN_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_ogretmen")
	private Integer ogretmenId;
	
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	
	@Column(name = "LAST_NAME")
	private  String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	
	

	public Ogretmen() {
		super();
	}

	public Integer getOgretmenId() {
		return ogretmenId;
	}

	public void setOgretmenId(Integer ogretmenId) {
		this.ogretmenId = ogretmenId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "" + ogretmenId +"";
	}
	
	
	

}
