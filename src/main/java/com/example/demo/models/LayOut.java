package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="layout")
public class LayOut {
@Id
@Min(0)
@Column(name="id")
private Long id;
@NotBlank
@Column(name="tenanh")
private String tenanh;
public LayOut(@Min(0) Long id, @NotBlank String tenanh) {
	super();
	this.id = id;
	this.tenanh = tenanh;
}
public LayOut() {
	super();
}
public LayOut(@Min(0) Long id) {
	super();
	this.id = id;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTenanh() {
	return tenanh;
}
public void setTenanh(String tenanh) {
	this.tenanh = tenanh;
}

}
