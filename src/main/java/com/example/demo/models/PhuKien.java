package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="phukien")
public class PhuKien {
	private static final long serialVersionUID = 1L;
@Id
@Column(name="id")
private long id;
@Column(name="mapk")
private String mapk;
@Column(name="tenpk")
private String tenpk;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date ngaynhap;
@Column(name="hinhanh")
private String hinhanh;
@Column(name="soluong")
private Long soluong;
@Column(name="giaban")
private Long giaban;
@Column(name="maloaipk")
private String maloaipk;
@Column(name="idnhapkho")
private long idnhapkho;
@Column(name="idxuatkho")
private long idxuatkho;
@Column(name="soluonght")
private long soluonght;
@Column(name="isdelete")
private int isdelete;


public long getSoluonght() {
	return soluonght;
}
public void setSoluonght(long soluonght) {
	this.soluonght = soluonght;
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Long giaban,
		String maloaipk, long idnhapkho, long idxuatkho, long soluonght, int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.maloaipk = maloaipk;
	this.idnhapkho = idnhapkho;
	this.idxuatkho = idxuatkho;
	this.soluonght = soluonght;
	this.isdelete = isdelete;
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Long giaban,
		String maloaipk, long idnhapkho, long idxuatkho, int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.maloaipk = maloaipk;
	this.idnhapkho = idnhapkho;
	this.idxuatkho = idxuatkho;
	this.isdelete = isdelete;
}
public String getMaloaipk() {
	return maloaipk;
}

public long getIdnhapkho() {
	return idnhapkho;
}
public void setIdnhapkho(long idnhapkho) {
	this.idnhapkho = idnhapkho;
}
public long getIdxuatkho() {
	return idxuatkho;
}
public void setIdxuatkho(long idxuatkho) {
	this.idxuatkho = idxuatkho;
}
public void setMaloaipk(String maloaipk) {
	this.maloaipk = maloaipk;
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Long giaban,
		String maloaipk, int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.maloaipk = maloaipk;
	this.isdelete = isdelete;
}
public PhuKien() {
	super();
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Long giaban,
		int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.isdelete = isdelete;
}
public PhuKien(long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public PhuKien(long id) {
	super();
	this.id = id;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMapk() {
	return mapk;
}
public void setMapk(String mapk) {
	this.mapk = mapk;
}
public String getTenpk() {
	return tenpk;
}
public void setTenpk(String tenpk) {
	this.tenpk = tenpk;
}
public Date getNgaynhap() {
	return ngaynhap;
}
public void setNgaynhap(Date ngaynhap) {
	this.ngaynhap = ngaynhap;
}
public String getHinhanh() {
	return hinhanh;
}
public void setHinhanh(String hinhanh) {
	this.hinhanh = hinhanh;
}
public Long getSoluong() {
	return soluong;
}
public void setSoluong(Long soluong) {
	this.soluong = soluong;
}
public Long getGiaban() {
	return giaban;
}
public void setGiaban(Long giaban) {
	this.giaban = giaban;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

}
