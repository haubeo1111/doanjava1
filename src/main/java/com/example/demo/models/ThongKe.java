package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thongke")
public class ThongKe {
	@Id
	@Column(name="name")
    private String name;
	@Column(name="soluong")
     private long soluong;
	public ThongKe(String name, long soluong) {
		super();
		this.name = name;
		this.soluong = soluong;
	}
	public ThongKe() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}


}
