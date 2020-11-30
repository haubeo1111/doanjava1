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
@Table(name="khongdilam")
public class KhongDiLam {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="idnhanvien")
	private long idnhanvien;
	@Column(name="lydo")
	private String lydo;
	@Column(name="vangkhongphep")
	private int vangkhongphep;
	@Column(name="vangcophep")
	private int vangcophep;
	@Column(name="vangnghiphep")
	private int vangnghiphep;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaykhongdilam;
	@Column(name="isdelete")
	private int isdelete;
	
	public KhongDiLam(long id) {
		super();
		this.id = id;
	}
	public KhongDiLam(long idnhanvien, Date ngaykhongdilam) {
		super();
		this.idnhanvien = idnhanvien;
		this.ngaykhongdilam = ngaykhongdilam;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdnhanvien() {
		return idnhanvien;
	}
	public void setIdnhanvien(long idnhanvien) {
		this.idnhanvien = idnhanvien;
	}
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	public int getVangkhongphep() {
		return vangkhongphep;
	}
	public void setVangkhongphep(int vangkhongphep) {
		this.vangkhongphep = vangkhongphep;
	}
	public int getVangcophep() {
		return vangcophep;
	}
	public void setVangcophep(int vangcophep) {
		this.vangcophep = vangcophep;
	}
	public int getVangnghiphep() {
		return vangnghiphep;
	}
	public void setVangnghiphep(int vangnghiphep) {
		this.vangnghiphep = vangnghiphep;
	}
	public Date getNgaykhongdilam() {
		return ngaykhongdilam;
	}
	public void setNgaykhongdilam(Date ngaykhongdilam) {
		this.ngaykhongdilam = ngaykhongdilam;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public KhongDiLam() {
		super();
	}
	public KhongDiLam(long id, long idnhanvien, String lydo, int vangkhongphep, int vangcophep, int vangnghiphep,
			Date ngaykhongdilam, int isdelete) {
		super();
		this.id = id;
		this.idnhanvien = idnhanvien;
		this.lydo = lydo;
		this.vangkhongphep = vangkhongphep;
		this.vangcophep = vangcophep;
		this.vangnghiphep = vangnghiphep;
		this.ngaykhongdilam = ngaykhongdilam;
		this.isdelete = isdelete;
	}
	public KhongDiLam(long id, long idnhanvien, int isdelete) {
		super();
		this.id = id;
		this.idnhanvien = idnhanvien;
		this.isdelete = isdelete;
	}
	
}
