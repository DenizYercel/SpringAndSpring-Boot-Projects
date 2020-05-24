package com.deniz.entity;


public class Ogrenci {
	
	
	private Integer id;
	
	
	private String isim;
	
	
	private String soyisim;
	
	
	private Integer ogrenciNo;
	
	
	
	private Integer isDelete;
	
	
	public Ogrenci() {
		super();
	}
	
	

	public Ogrenci(String isim, String soyisim, Integer ogrenciNo, Integer isDelete) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenciNo = ogrenciNo;
		this.isDelete = isDelete;
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
