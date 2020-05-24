package com.deniz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="OGRENCI")
public class Ogrenci {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="ogrenci_seq",sequenceName = "SEQ_OGRENCI",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "ogrenci_seq")
	private Integer id;
	
	@NotEmpty(message = "Lütfen isim giriniz")
	@Column(name = "ISIM")
	private String isim;
	
	@NotEmpty(message = "Lütfen soyisim giriniz")
	@Column(name = "SOYISIM")
	private String soyisim;
	
	@Min(value=1,message="1'den küçük numara veremezsiniz")
	@Max(value=999,message="999'dan büyük numara veremezsiniz")
	@Column(name = "OGRENCI_NO")
	private Integer ogrenciNo;
	
	
	@Column(name = "IS_DELETE")
	private Integer isDelete=1;
	
	
	public Ogrenci() {
		super();
	}
	
	
	public Ogrenci(String isim, String soyisim, Integer ogrenciNo) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenciNo = ogrenciNo;
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


	public Integer getOgrenciNo() {
		return ogrenciNo;
	}


	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}


	@Override
	public String toString() {
		return "Ogrenci [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", ogrenciNo=" + ogrenciNo + "]";
	}


	
	
}
