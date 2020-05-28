package com.deniz.domain;

import javax.persistence.*;

@Entity
@Table(name="OGRENCI")
public class Student {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "ogrenci_seq", sequenceName = "SEQ_OGRENCI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogrenci_seq")
    private Integer id;


    @Column(name = "FIRST_NAME")
    private String isim;


    @Column(name = "LAST_NAME")
    private String soyisim;


    @Column(name = "STATU")
    private Integer statu;


    @Column(name = "EMAIL")
    private String email;


    public Student() {

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

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", statu=" + statu +
                ", email='" + email + '\'' +
                '}';
    }
}


