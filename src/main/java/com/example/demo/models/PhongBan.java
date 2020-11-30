package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="phongban")
public class PhongBan {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private  Long id;
	@NotEmpty(message="khong de trong ten")
	@Size(max = 100)
	@Column(name="name")
	private String name;
	@NotEmpty(message="khong de trong ma")
	@Size(max = 100)
	@Column(name="mapb")
	private String mapb;
	@Column(name="isdelete")
	private int isdelete;
	public PhongBan() {
		super();
	}
	
	public PhongBan(@NotEmpty(message = "khong de trong") @Size(max = 100) String name) {
		super();
		this.name = name;
	}

	public PhongBan(@NotEmpty @Size(max = 100) String name, @NotEmpty @Size(max = 100) String mapb) {
		super();
		this.name = name;
		this.mapb = mapb;
	}

	public PhongBan(Long id, String name, String mapb, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.mapb = mapb;
		this.isdelete = isdelete;
	}
	public PhongBan(Long id) {
		super();
		this.id = id;
	}
	public PhongBan(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
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
	public String getMapb() {
		return mapb;
	}
	public void setMapb(String mapb) {
		this.mapb = mapb;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
