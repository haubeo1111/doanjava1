package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="chucnang")
public class ChucNang {
@Id
@Min(0)
@Column(name="id")
private Long id;
@NotBlank(message="Không Được Để Trống")

@Size(max = 100)
@Column(name="tencn")
private String tencn;
@NotBlank(message="Không Được Để Trống")
@Size(max =100)
@Column(name="cnurl")
private String cnurl;
@NotBlank(message="Không Được Để Trống")
@Size(max =100)
@Column(name="macn")
private String macn;


@Min(1) 
@Column(name="cncha")
private Long cncha;
@NotBlank(message="Không Được Để Trống")
@Size(max =50,message="Không Được Quá Dài")
@Column(name="mota")
private String mota;
@NotBlank(message="Không Được Để Trống")
@Size(max =100)
@Column(name="maapi")
private String maapi;

@Column(name="congkhai")
private boolean congkhai;

@Column(name="isdelete")
private int isdelete;


public ChucNang(@Min(0) Long id, @NotBlank @Size(max = 100) String tencn, @NotBlank @Size(max = 100) String cnurl,
		@NotBlank @Size(max = 100) String macn, @Min(1) Long cncha, @NotBlank @Size(max = 150) String mota,
		@NotBlank @Size(max = 100) String maapi, boolean congkhai, int isdelete) {
	super();
	this.id = id;
	this.tencn = tencn;
	this.cnurl = cnurl;
	this.macn = macn;
	this.cncha = cncha;
	this.mota = mota;
	this.maapi = maapi;
	this.congkhai = congkhai;
	this.isdelete = isdelete;
}
public ChucNang() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTencn() {
	return tencn;
}
public void setTencn(String tencn) {
	this.tencn = tencn;
}
public String getCnurl() {
	return cnurl;
}
public void setCnurl(String cnurl) {
	this.cnurl = cnurl;
}
public String getMacn() {
	return macn;
}
public void setMacn(String macn) {
	this.macn = macn;
}
public Long getCncha() {
	return cncha;
}
public void setCncha(Long cncha) {
	this.cncha = cncha;
}
public String getMota() {
	return mota;
}
public void setMota(String mota) {
	this.mota = mota;
}
public String getMaapi() {
	return maapi;
}
public void setMaapi(String maapi) {
	this.maapi = maapi;
}
public boolean isCongkhai() {
	return congkhai;
}
public void setCongkhai(boolean congkhai) {
	this.congkhai = congkhai;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}




public ChucNang(Long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public ChucNang(@Min(0) Long id) {
	super();
	this.id = id;
}



}
