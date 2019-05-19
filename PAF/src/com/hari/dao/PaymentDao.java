package com.hari.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hari.model.Payment;
import com.hari.model.Product;

public class PaymentDao {
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addPayment(int oid, float cost, String address) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `payment`(`oid`, `cost`, `address`) VALUES (?, ?, ?)");
			PreparedStatement ps1=con.prepareStatement("UPDATE product SET status='sold' WHERE pid = (select o.pid FROM ordertbl o WHERE o.oid = "+oid+")");
			ps.setInt(1,oid);
			ps.setFloat(2,cost);
			ps.setString(3,address);
			ps.executeUpdate();
			ps1.executeUpdate();
			ps.close();
			con.close();
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return -99;
	}
	
	public List<Payment> editOrdeletemyPaymentView(int id) {
		List<Payment> paylist = new ArrayList<Payment>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "select pay.*, m.mname, p.pname, p.image " + 
					"from payment pay, member m, ordertbl o, product p " + 
					"where pay.oid = o.oid AND o.bid = m.mid AND m.mid = "+id+" AND o.pid = p.pid";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Payment pay = new Payment(rs.getInt("payid"), rs.getInt("oid"), rs.getFloat("cost"), rs.getString("address"));
				pay.setBname(rs.getString("mname"));
				pay.setPname(rs.getString("pname"));
				pay.setImage(rs.getString("image"));
				paylist.add(pay);
			}
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return paylist;
	}
	
	public int delete(int id) {
		int i = -99;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "DELETE from payment where payid = '"+id+"'";
			String sql1 = "UPDATE product SET status = 'nys' WHERE pid = (select o.pid FROM ordertbl o, payment p where p.oid = o.oid AND p.payid = "+id+")";
			PreparedStatement pstm = con.prepareStatement(sql);
			PreparedStatement pstm1 = con.prepareStatement(sql1);
			pstm1.executeUpdate();
			i = pstm.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return i;
	}
	
	public Payment editThisPayForm(int id) {
		Payment pay = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "select * from payment where payid = " + id;
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				pay = new Payment(rs.getInt("payid"), rs.getInt("oid"), rs.getFloat("cost"), rs.getString("address"));
			}
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return pay;
	}
	
	public int edit(int id, String address) {
		int i = -99;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "UPDATE payment SET address = '"+address+"' where payid = '"+id+"'";
			PreparedStatement pstm = con.prepareStatement(sql);
			i = pstm.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return i;
	}
}
