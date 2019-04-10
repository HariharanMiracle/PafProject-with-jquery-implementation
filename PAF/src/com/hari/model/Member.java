package com.hari.model;

public class Member {
	private int id;
	private String name;
	private String password;
	private String type;
	public Member(int id, String name, String password, String type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
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
}
