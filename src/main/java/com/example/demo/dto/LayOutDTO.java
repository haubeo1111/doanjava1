package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class LayOutDTO {
	private Long id;
	private MultipartFile tenanh;
	public LayOutDTO(Long id, MultipartFile tenanh) {
		super();
		this.id = id;
		this.tenanh = tenanh;
	}
	public LayOutDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MultipartFile getTenanh() {
		return tenanh;
	}
	public void setTenanh(MultipartFile tenanh) {
		this.tenanh = tenanh;
	}
	
}
