package com.deniz.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="OGRENCI_ISLERI")
public class Ogrenci {
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="OGRENCI_NO")
	private Integer ogrenciNo;
	
	@Column(name="AD")
	private String ad;
	
	@Column(name="SOYAD")
	private String soyad;
	
	@Column(name="BASLANGIC_TARIHI")
	private Date baslDate;
	
	@Column(name="MEZUNIYET_TARIHI")
	private Date mezDate;
	
	@Column(name="OGRENCILIK_DURUMU")
	private Integer ogrencilikDurumu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Date getBaslDate() {
		return baslDate;
	}

	public void setBaslDate(Date baslDate) {
		this.baslDate = baslDate;
	}

	public Date getMezDate() {
		return mezDate;
	}

	public void setMezDate(Date mezDate) {
		this.mezDate = mezDate;
	}

	public Integer getOgrencilikDurumu() {
		return ogrencilikDurumu;
	}

	public void setOgrencilikDurumu(Integer ogrencilikDurumu) {
		this.ogrencilikDurumu = ogrencilikDurumu;
	}

}

