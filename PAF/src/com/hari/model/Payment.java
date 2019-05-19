package com.hari.model;

public class Payment {
	private int payid;
	private int oid;
	private float cost;
	private String address;
	private String bname;
	private String sname;
	private String pname;
	private String image; 
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payid, int oid, float cost, String address) {
		super();
		this.payid = payid;
		this.oid = oid;
		this.cost = cost;
		this.address = address;
	}

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Payment [payid=" + payid + ", oid=" + oid + ", cost=" + cost + ", address=" + address + "]";
	}
}
