package com.deniz.springboot.project.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "kitap")
public class Kitap {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="kitap_adi")
	private String kitapAdi;
	
	@Column(name="yazar")
	private String yazar;
	
	@Column(name="verilis_tarihi")
	private Date verTarihi;
	
	@Column(name="iade_tarihi")
	private Date iadTarihi;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ogrenci_id")
	private Ogrenci ogrenci;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public Date getVerTarihi() {
		return verTarihi;
	}

	public void setVerTarihi(Date verTarihi) {
		this.verTarihi = verTarihi;
	}

	public Date getIadTarihi() {
		return iadTarihi;
	}

	public void setIadTarihi(Date iadTarihi) {
		this.iadTarihi = iadTarihi;
	}

	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
	
	
}
