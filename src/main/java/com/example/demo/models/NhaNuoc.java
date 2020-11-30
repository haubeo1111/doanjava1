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
@Table(name="nhanuoc")
public class NhaNuoc {
@Id
@Column(name="id")
private long id;
@Column(name="luongcoban")
private long luongcoban;
@Column(name="bhtainan")
private int bhtainan;
@Column(name="bhyte")
private int bhyte;
@Column(name="quydoan")
private long quydoan;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date nam;
@Column(name="isdelete")
private int isdelete;

public Date getNam() {
	return nam;
}
public void setNam(Date nam) {
	this.nam = nam;
}
public NhaNuoc(long id, Date nam) {
	super();
	this.id = id;
	this.nam = nam;
}
public NhaNuoc(long id, long luongcoban, int bhtainan, int bhyte, long quydoan, Date nam, int isdelete) {
	super();
	this.id = id;
	this.luongcoban = luongcoban;
	this.bhtainan = bhtainan;
	this.bhyte = bhyte;
	this.quydoan = quydoan;
	this.nam = nam;
	this.isdelete = isdelete;
}
public long getQuydoan() {
	return quydoan;
}
public void setQuydoan(long quydoan) {
	this.quydoan = quydoan;
}
public NhaNuoc(long id, long luongcoban, int bhtainan, int bhyte, long quydoan, int isdelete) {
	super();
	this.id = id;
	this.luongcoban = luongcoban;
	this.bhtainan = bhtainan;
	this.bhyte = bhyte;
	this.quydoan = quydoan;
	this.isdelete = isdelete;
}
public NhaNuoc(long id, long luongcoban, int bhtainan, int bhyte, int isdelete) {
	super();
	this.id = id;
	this.luongcoban = luongcoban;
	this.bhtainan = bhtainan;
	this.bhyte = bhyte;
	this.isdelete = isdelete;
}
public NhaNuoc(long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public NhaNuoc(long id) {
	super();
	this.id = id;
}
public NhaNuoc() {
	super();
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getLuongcoban() {
	return luongcoban;
}
public void setLuongcoban(long luongcoban) {
	this.luongcoban = luongcoban;
}
public int getBhtainan() {
	return bhtainan;
}
public void setBhtainan(int bhtainan) {
	this.bhtainan = bhtainan;
}
public int getBhyte() {
	return bhyte;
}
public void setBhyte(int bhyte) {
	this.bhyte = bhyte;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

}
