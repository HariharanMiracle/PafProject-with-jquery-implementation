package com.hari.model;

import java.io.File;

public class Product {
	private int pid;
	private String pname;
	private float price;
	private String description;
	private String image;
	private int mid;
	private String status;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, float price, String description, String image, int mid, String status) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.image = image;
		this.mid = mid;
		this.status = status;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", description=" + description
				+ ", mid=" + mid + ", status=" + status + "]";
	}
}
