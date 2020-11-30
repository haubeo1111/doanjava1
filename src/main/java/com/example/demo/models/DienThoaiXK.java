package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dienthoaixk")
public class DienThoaiXK {
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(generator = "bigid")
    @GenericGenerator(name = "bigid",strategy = "com.example.demo.dto.IDGenerator")
	@Column(name="id")
	private  Long id;
	
	@Column(name="maxk")
	private long maxk;
	@NotBlank
	@Column(name="name")
	private String name;
	@Column(name="madt")
	private String madt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngayxuat;
	@Column(name="hinhanh")
	private String hinhanh;
	@Column(name="soluong")
	private Long soluong;
	@Column(name="giaban")
	private Long giaban;
    @Column(name="maloaidt")
	private String maloaidt;
    @Column(name="isdelete")
   	private int isdelete;
    
	public long getMaxk() {
		return maxk;
	}

	public DienThoaiXK( long maxk) {
		super();
		this.maxk = maxk;
	}

	public void setMaxk(long maxk) {
		this.maxk = maxk;
	}

	

	public DienThoaiXK( long maxk, @NotBlank String name, String madt, Date ngayxuat, String hinhanh,
			Long soluong, Long giaban, String maloaidt, int isdelete) {
		super();
		this.maxk = maxk;
		this.name = name;
		this.madt = madt;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}

	public DienThoaiXK(Long id, long maxk, @NotBlank String name, String madt, Date ngayxuat,
			String hinhanh, Long soluong, Long giaban, String maloaidt, int isdelete) {
		super();
		this.id = id;
		this.maxk = maxk;
		this.name = name;
		this.madt = madt;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}

	public DienThoaiXK(Long id, String name, String madt, Date ngayxuat, String hinhanh, Long soluong, Long giaban,
			String maloaidt, int isdelete) {
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

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public DienThoaiXK() {
		super();
	}
	
	public DienThoaiXK(Long id) {
		super();
		this.id = id;
	}

	public DienThoaiXK(Long id, String name, String madt, Date ngayxuat, String hinhanh,
			Long soluong,
			Long giaban,
			String maloaidt) {
		super();
		this.id = id;
		this.name = name;
		this.madt = madt;
		this.ngayxuat = ngayxuat;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
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
	public Date getNgayxuat() {
		return ngayxuat;
	}
	public void setNgayxuat(Date ngaynhap) {
		this.ngayxuat = ngaynhap;
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
	public String getMaloaidt() {
		return maloaidt;
	}
	public void setMaloaidt(String maloaidt) {
		this.maloaidt = maloaidt;
	}
    
}
