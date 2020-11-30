package com.example.demo.banhang;

import java.util.Date;

public class CustomerProduct {
	private Long cartsdetail;
	private Integer quantity;
	private Long price;
	private Long giaban;
	private String note;
	private Long product;
	private Long cart;
    private String name;
	private String photo;
	private Date ngaydat;
	private Long idxuatkho;
	
	public CustomerProduct(Long cartsdetail, Integer quantity, Long price, Long giaban, String note, Long product,
			Long cart, String name, String photo, Date ngaydat, Long idxuatkho) {
		super();
		this.cartsdetail = cartsdetail;
		this.quantity = quantity;
		this.price = price;
		this.giaban = giaban;
		this.note = note;
		this.product = product;
		this.cart = cart;
		this.name = name;
		this.photo = photo;
		this.ngaydat = ngaydat;
		this.idxuatkho = idxuatkho;
	}

	public Long getGiaban() {
		return giaban;
	}

	public void setGiaban(Long giaban) {
		this.giaban = giaban;
	}

	public Long getIdxuatkho() {
		return idxuatkho;
	}

	public void setIdxuatkho(Long idxuatkho) {
		this.idxuatkho = idxuatkho;
	}

	public CustomerProduct(Long cartsdetail, Integer quantity, Long price, String note, Long product, Long cart,
			String name, String photo, Date ngaydat, Long idxuatkho) {
		super();
		this.cartsdetail = cartsdetail;
		this.quantity = quantity;
		this.price = price;
		this.note = note;
		this.product = product;
		this.cart = cart;
		this.name = name;
		this.photo = photo;
		this.ngaydat = ngaydat;
		this.idxuatkho = idxuatkho;
	}

	public CustomerProduct() {
		super();
	}
	
	public Date getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public CustomerProduct(Long cartsdetail, Integer quantity, Long price, String note, Long product, Long cart,
			String name, String photo, Date ngaydat) {
		super();
		this.cartsdetail = cartsdetail;
		this.quantity = quantity;
		this.price = price;
		this.note = note;
		this.product = product;
		this.cart = cart;
		this.name = name;
		this.photo = photo;
		this.ngaydat = ngaydat;
	}

	public CustomerProduct(Long cartsdetail, Integer quantity, Long price, String note,Long product,
			Long cart, String name, String photo) {
		super();
		this.cartsdetail = cartsdetail;
		this.quantity = quantity;
		this.price = price;
		this.note = note;
		this.product = product;
		this.cart = cart;
		this.name = name;
		this.photo = photo;
	}
	public CustomerProduct(Long cartsdetail, Integer quantity, Long price,Long product, Long cart,
			String name, String photo) {
		super();
		this.cartsdetail = cartsdetail;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.cart = cart;
		this.name = name;
		this.photo = photo;
	}
	public Long getCartsdetail() {
		return cartsdetail;
	}
	public void setCartsdetail(Long cartsdetail) {
		this.cartsdetail = cartsdetail;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getProduct() {
		return product;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public Long getCart() {
		return cart;
	}
	public void setCart(Long cart) {
		this.cart = cart;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public CustomerProduct(Integer quantity, Long price, String note, String name, String photo) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.note = note;
		this.name = name;
		this.photo = photo;
	}
	
}
