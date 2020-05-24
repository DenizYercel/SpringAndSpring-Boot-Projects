package com.deniz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "KURS")
public class Kurs {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name = "seq_kurs",sequenceName = "KURS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_kurs")
	private Integer id;
	
	@NotEmpty(message = "Lütfen kurs adýný giriniz")
	@Column(name = "KURS_ADI")
	private String kursAdi;

	@Min(value=1,message="30'dan küçük ders saati olamaz ")
	@Max(value=999,message="300'den büyük ders saati olamaz")
	@Column(name="SAAT")
	private Integer saat;
	
	@Column(name = "IS_DELETE")
	private Integer isDelete=1;
	
	@ManyToOne
	@JoinColumn(name = "OGRETMEN_ID")
	private Ogretmen ogretmen;
	

	public Kurs() {
		super();
	}


	public Kurs(@NotEmpty(message = "Lütfen kurs adýný giriniz") String kursAdi,
			@Min(value = 1, message = "30'dan küçük ders saati olamaz ") @Max(value = 999, message = "300'den büyük ders saati olamaz") Integer saat,
			Ogretmen ogretmen) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	

	public Integer getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getKursAdi() {
		return kursAdi;
	}


	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}


	public Integer getSaat() {
		return saat;
	}


	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	

	public Ogretmen getOgretmen() {
		return ogretmen;
	}






	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}






	@Override
	public String toString() {
		return "Kurs [id=" + id + ", kursAdi=" + kursAdi + ", saat=" + saat + "]";
	}
	
}
