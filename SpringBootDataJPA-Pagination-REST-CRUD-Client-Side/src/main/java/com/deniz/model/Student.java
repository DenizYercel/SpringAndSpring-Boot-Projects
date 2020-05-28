package com.deniz.model;

import java.sql.Date;

import org.springframework.hateoas.RepresentationModel;

//@Embeddable
public class Student extends RepresentationModel{
	

//	@JsonProperty("id")
	private Integer id;

//	@JsonProperty("first_name")
    private String isim;

	//@JsonProperty("last_name")
    private String soyisim;

	//@JsonProperty("email")
    private String email;

	//@JsonProperty("statu")
    private Integer statu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", email=" + email + ", statu=" + statu
				+ "]";
	}

	

	
    
}
