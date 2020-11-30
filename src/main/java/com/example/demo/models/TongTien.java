package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="tongtien")
public class TongTien {
private long id;	
private long tien;
private long hoadonid;
public TongTien(long tien) {
	super();
	this.tien = tien;
}

public long getHoadonid() {
	return hoadonid;
}

public void setHoadonid(long hoadonid) {
	this.hoadonid = hoadonid;
}

public TongTien(long tien, long hoadonid) {
	super();
	this.tien = tien;
	this.hoadonid = hoadonid;
}

public long getTien() {
	return tien;
}

public void setTien(long tien) {
	this.tien = tien;
}

public TongTien() {
	super();
}

}
