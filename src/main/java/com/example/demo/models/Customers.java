package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customers {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(generator = "bigid")
    @GenericGenerator(name = "bigid",strategy = "com.example.demo.dto.IDGenerator")
    private long id;
	
	@Column(name = "name")
	private String name;
    @Column(name="gender")
	private int gender;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dto;
    @NotBlank
    @Email
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
  // @Column(name="password")
    //private String password;
    @Column(name="address")
    private String address;
    @Column(name="isdelete")
   	private int isdelete;
	public Customers() {
		super();
	}
	
	public Customers(Date dto) {
		super();
		this.dto = dto;
	}

	public Date getDto() {
		return dto;
	}

	public void setDto(Date dto) {
		this.dto = dto;
	}

	public Customers(long id, String name, int gender, Date birthday, Date dto, @NotBlank @Email String email,
			String phone, String address, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.dto = dto;
		this.email = email;
		this.phone = phone;
		//this.password = password;
		this.address = address;
		this.isdelete = isdelete;
	}


	public Customers(Long id) {
		super();
		this.id = id;
	}
	
	
	public Customers(Long id, String name, int gender, Date birthday, String email, String phone,
			String address, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
//this.password = password;
		this.address = address;
		this.isdelete = isdelete;
	}
	public Customers(Long id, String name, int gender, Date birthday, String email, String phone,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		//this.password = password;
		this.address = address;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
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
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
