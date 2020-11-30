package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "chucvu")
public class ChucVu {
	@Id
	@Min(0)
	@Column(name = "id")
	private int id;
	@NotNull
	@NotEmpty
	@Size(max = 30)
	@Column(name = "macv", length = 30, nullable = false)
	private String macv;
	@NotNull
	@NotEmpty
	@Size(max = 150)
	@Column(name = "tencv", length = 150, nullable = false)
	private String tencv;
	@Column(name = "isdelete")
	private int isdelete;

	public ChucVu(int id) {
		super();
		this.id = id;
	}

	public ChucVu(int id, String macv, String tencv) {
		super();
		this.id = id;
		this.macv = macv;
		this.tencv = tencv;
	}

	public ChucVu(int id, String macv, String tencv, int isdelete) {
		super();
		this.id = id;
		this.macv = macv;
		this.tencv = tencv;
		this.isdelete = isdelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public String getMacv() {
		return macv;
	}

	public void setMacv(String macv) {
		this.macv = macv;
	}

	public String getTencv() {
		return tencv;
	}

	public void setTencv(String tencv) {
		this.tencv = tencv;
	}

	public ChucVu(String macv, String tencv) {
		super();
		this.macv = macv;
		this.tencv = tencv;
	}

	public ChucVu() {
		super();
	}

}
