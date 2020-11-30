package com.example.demo.dto;

public class phucaplist {
private String tenphucap ;
private Long sotien;
public phucaplist(String tenphucap, Long sotien) {
	super();
	this.tenphucap = tenphucap;
	this.sotien = sotien;
}
public String getTenphucap() {
	return tenphucap;
}
public void setTenphucap(String tenphucap) {
	this.tenphucap = tenphucap;
}
public Long getSotien() {
	return sotien;
}
public void setSotien(Long sotien) {
	this.sotien = sotien;
}

}
