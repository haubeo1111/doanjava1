package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="phieunhapkho")
public class PhieuNhapKho {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(generator = "bigid")
    @GenericGenerator(name = "bigid",strategy = "com.example.demo.dto.IDGenerator")
	@Column(name="id")
	private long id;
	@Column(name="maphieu")
	private String maphieu;
	@Column(name="tenphieu")
	private String tenphieu;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date ngaytao;
	@Column(name="isdelete")
	private int isdelete;
	
	public PhieuNhapKho(long id) {
		super();
		this.id = id;
	}
	public PhieuNhapKho(long id, String maphieu, String tenphieu, Date ngaytao, int isdelete) {
		super();
		this.id = id;
		this.maphieu = maphieu;
		this.tenphieu = tenphieu;
		this.ngaytao = ngaytao;
		this.isdelete = isdelete;
	}
	public PhieuNhapKho() {
		super();
	}
	public PhieuNhapKho(long id, String maphieu, String tenphieu, Date ngaytao) {
		super();
		this.id = id;
		this.maphieu = maphieu;
		this.tenphieu = tenphieu;
		this.ngaytao = ngaytao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public String getTenphieu() {
		return tenphieu;
	}
	public void setTenphieu(String tenphieu) {
		this.tenphieu = tenphieu;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
