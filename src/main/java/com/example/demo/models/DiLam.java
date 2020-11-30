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
@Table(name="dilam")
public class DiLam {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="idnhanvien")
	private long idnhanvien;
	@Column(name="ditre")
	private int ditre;
	@Column(name="vesom")
	private int vesom;
	@Column(name="uutu")
	private int uutu;
	@Column(name="tinhtrang")
	private String tinhtrang;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaydilam;
	@Column(name="sotien")
	private long sotien;
	@Column(name="isdelete")
	private int isdelete;
	public DiLam(long id, long idnhanvien, int ditre, int vesom, int uutu, String tinhtrang, Date ngaydilam,
			long sotien, int isdelete) {
		super();
		this.id = id;
		this.idnhanvien = idnhanvien;
		this.ditre = ditre;
		this.vesom = vesom;
		this.uutu = uutu;
		this.tinhtrang = tinhtrang;
		this.ngaydilam = ngaydilam;
		this.sotien = sotien;
		this.isdelete = isdelete;
	}
	
	public DiLam(long id, long idnhanvien, int ditre, int vesom, int uutu, Date ngaydilam, int isdelete) {
		super();
		this.id = id;
		this.idnhanvien = idnhanvien;
		this.ditre = ditre;
		this.vesom = vesom;
		this.uutu = uutu;
		this.ngaydilam = ngaydilam;
		this.isdelete = isdelete;
	}

	public DiLam(long id) {
		super();
		this.id = id;
	}
	public DiLam() {
		super();
	}
	public DiLam(long idnhanvien, Date ngaydilam) {
		super();
		this.idnhanvien = idnhanvien;
		this.ngaydilam = ngaydilam;
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
	public int getDitre() {
		return ditre;
	}
	public void setDitre(int ditre) {
		this.ditre = ditre;
	}
	public int getVesom() {
		return vesom;
	}
	public void setVesom(int vesom) {
		this.vesom = vesom;
	}
	public int getUutu() {
		return uutu;
	}
	public void setUutu(int uutu) {
		this.uutu = uutu;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public Date getNgaydilam() {
		return ngaydilam;
	}
	public void setNgaydilam(Date ngaydilam) {
		this.ngaydilam = ngaydilam;
	}
	public long getSotien() {
		return sotien;
	}
	public void setSotien(long sotien) {
		this.sotien = sotien;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	
	
}
