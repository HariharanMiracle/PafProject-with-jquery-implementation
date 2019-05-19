package com.hari.model;

public class Member {
	private int id;
	private String name;
	private String password;
	private String type;
	private String address;
	private String mail;
	private int contactNumber;
	private String status;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int id, String name, String password, String type, String address, String mail, int contactNumber, String status) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
		this.address = address;
		this.mail = mail;
		this.contactNumber = contactNumber;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
