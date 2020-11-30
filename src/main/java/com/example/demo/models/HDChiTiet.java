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
@Table(name="hdchitiet")
public class HDChiTiet {
@Id
@Column(name="id")
private Long id;
@Column(name="soluong")
private Integer soluong;
@Column(name="price")
private Long price;
@Column(name="note")
private String note;
@Column(name="tinhtrang")
private int tinhtrang;
@Column(name="sanphamid")
private Long sanphamid;
@Column(name="hoadonid")
private Long hoadonid;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
@Column(name="ngaydat",nullable = true)
private Date ngaydat;
@Column(name="isdelete")
private Integer isdelete;
public HDChiTiet() {
	super();
}


public Date getNgaydat() {
	return ngaydat;
}


public void setNgaydat(Date ngaydat) {
	this.ngaydat = ngaydat;
}


public HDChiTiet(Long id, Integer soluong, Long price, String note, int tinhtrang, Long sanphamid, Long hoadonid,
		Date ngaydat, Integer isdelete) {
	super();
	this.id = id;
	this.soluong = soluong;
	this.price = price;
	this.note = note;
	this.tinhtrang = tinhtrang;
	this.sanphamid = sanphamid;
	this.hoadonid = hoadonid;
	this.ngaydat = ngaydat;
	this.isdelete = isdelete;
}


public int getTinhtrang() {
	return tinhtrang;
}

public void setTinhtrang(int tinhtrang) {
	this.tinhtrang = tinhtrang;
}

public HDChiTiet(Long id, Integer soluong, Long price, String note, int tinhtrang, Long sanphamid, Long hoadonid,
		Integer isdelete) {
	super();
	this.id = id;
	this.soluong = soluong;
	this.price = price;
	this.note = note;
	this.tinhtrang = tinhtrang;
	this.sanphamid = sanphamid;
	this.hoadonid = hoadonid;
	this.isdelete = isdelete;
}

public HDChiTiet(Long id, Integer soluong, Long price, String note, Long sanphamid, Long hoadonid, Integer isdelete) {
	super();
	this.id = id;
	this.soluong = soluong;
	this.price = price;
	this.note = note;
	this.sanphamid = sanphamid;
	this.hoadonid = hoadonid;
	this.isdelete = isdelete;
}

public HDChiTiet(Long id, Integer isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public HDChiTiet(Long id) {
	super();
	this.id = id;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getSoluong() {
	return soluong;
}
public void setSoluong(Integer soluong) {
	this.soluong = soluong;
}
public Long getPrice() {
	return price;
}
public void setPrice(Long price) {
	this.price = price;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public Long getSanphamid() {
	return sanphamid;
}
public void setSanphamid(Long sanphamid) {
	this.sanphamid = sanphamid;
}
public Long getHoadonid() {
	return hoadonid;
}
public void setHoadonid(Long hoadonid) {
	this.hoadonid = hoadonid;
}
public Integer getIsdelete() {
	return isdelete;
}
public void setIsdelete(Integer isdelete) {
	this.isdelete = isdelete;
}

}
