package com.example.demo.addclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name="chucnangid")
public class ChucNangID {
	@Id
	@Column(name="id")
	private long id;
    @Null
	@Column(name="idcn",nullable = true)
	private long idcn;
    @Null
   	@Column(name="tencn",nullable = true)
   	private String tencn;
    

public ChucNangID(long id, @Null long idcn, @Null String tencn) {
		super();
		this.id = id;
		this.idcn = idcn;
		this.tencn = tencn;
	}
public ChucNangID(long id, @Null long idcn) {
		super();
		this.id = id;
		this.idcn = idcn;
	}
public ChucNangID() {
		super();
	}
	public ChucNangID(long id) {
		super();
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdcn() {
		return idcn;
	}
	public void setIdcn(long idcn) {
		this.idcn = idcn;
	}
	public String getTencn() {
		return tencn;
	}
	public void setTencn(String tencn) {
		this.tencn = tencn;
	}
	

	
}
