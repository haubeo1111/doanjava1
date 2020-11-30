package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class DienThoaiXKDTO {
private  Long id;
	
	private String name;
	
	private String madt;
	private long maxk;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngayxuat;
	
	private MultipartFile hinhanh;
	
	private Long soluong;
	
	private Long giaban;
   
	private String maloaidt;
	private int isdelete;
	public DienThoaiXKDTO() {
		super();
	}
	
	public DienThoaiXKDTO(Long id, String name, String madt,long maxk, Date ngayxuat, MultipartFile hinhanh,
			Long soluong, Long giaban, String maloaidt, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.madt = madt;
		this.maxk = maxk;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}
	public DienThoaiXKDTO(String name, String madt,long maxk, Date ngayxuat, MultipartFile hinhanh, Long soluong,
			Long giaban, String maloaidt, int isdelete) {
		super();
		this.name = name;
		this.madt = madt;
		this.maxk = maxk;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}
	
	public DienThoaiXKDTO(Long id, String name, String madt, Date ngayxuat, MultipartFile hinhanh, Long soluong,
			Long giaban, String maloaidt, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.madt = madt;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}

	public DienThoaiXKDTO(long maxk) {
		super();
		this.maxk = maxk;
	}
	public DienThoaiXKDTO(long maxk, Date ngayxuat) {
		super();
		this.maxk = maxk;
		this.ngayxuat = ngayxuat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
	}
	public long getMaxk() {
		return maxk;
	}
	public void setMaxk(long maxk) {
		this.maxk = maxk;
	}
	public Date getNgayxuat() {
		return ngayxuat;
	}
	public void setNgayxuat(Date ngayxuat) {
		this.ngayxuat = ngayxuat;
	}
	public MultipartFile getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(MultipartFile hinhanh) {
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
	public String getMaloaidt() {
		return maloaidt;
	}
	public void setMaloaidt(String maloaidt) {
		this.maloaidt = maloaidt;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
