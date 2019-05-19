package com.hari.model;

public class Order {
	private int oid;
	private int sid;
	private int bid;
	private int pid;
	private String pname;
	private String status;
	String image;
	String sName;
	float price;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int oid, int sid, int bid, int pid, String pname, String status) {
		super();
		this.oid = oid;
		this.sid = sid;
		this.bid = bid;
		this.pid = pid;
		this.pname = pname;
		this.status = status;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSname() {
		return sName;
	}

	public void setSname(String sName) {
		this.sName = sName;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", sid=" + sid + ", bid=" + bid + ", pid=" + pid + ", pname=" + pname + ", status="
				+ status + "]";
	}
}
