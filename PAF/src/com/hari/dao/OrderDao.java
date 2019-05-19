package com.hari.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hari.model.Order;
import com.hari.model.Product;

public class OrderDao {
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int orderProduct(int sid, int bid, int pid, String status) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `ordertbl`(`sid`, `bid`, `pid`, `status`) VALUES (?, ?, ?, ?)"); 
			ps.setInt(1,sid);
			ps.setInt(2,bid);
			ps.setInt(3,pid);
			ps.setString(4,status);
			ps.executeUpdate();
			ps.close();
			con.close();
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return -99;
	}
	
	public List<Order> orderOpp(int id)  throws SQLException{
		List<Order> ordlist = new ArrayList<Order>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "select o.*, p.pname, p.image, m.mname " + 
					"from ordertbl o, product p, member m " + 
					"where o.pid = p.pid AND m.mid = o.bid AND o.sid = " + id;
		    PreparedStatement pstm = con.prepareStatement(sql);
		    ResultSet rs = pstm.executeQuery();
		    while (rs.next()) {
					Order ord = new Order(rs.getInt("oid"), rs.getInt("sid"), rs.getInt("bid"), rs.getInt("pid"), rs.getString("pname"), rs.getString("status"));
					ord.setImage(rs.getString("image"));
					ord.setSname(rs.getString("mname"));
					ordlist.add(ord);
			}
		}
		catch(Exception e) {
			System.out.println("Error in order function: " + e);
		}
		return ordlist;
	}
	
	public int editOrder(int oid, String val) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			PreparedStatement ps=con.prepareStatement("UPDATE `ordertbl` SET `status`= '"+val+"' WHERE `oid`= '"+oid+"'"); 
			ps.executeUpdate();
			ps.close();
			con.close();
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return -99;
	}
	
	public List<Order> notify(int id)  throws SQLException{
		List<Order> ordlist = new ArrayList<Order>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "select o.*, p.pname, p.image, m.mname " + 
					"from ordertbl o, product p, member m " + 
					"where o.pid = p.pid AND m.mid = o.bid AND o.bid = " + id;
		    PreparedStatement pstm = con.prepareStatement(sql);
		    ResultSet rs = pstm.executeQuery();
		    while (rs.next()) {
					Order ord = new Order(rs.getInt("oid"), rs.getInt("sid"), rs.getInt("bid"), rs.getInt("pid"), rs.getString("pname"), rs.getString("status"));
					ord.setImage(rs.getString("image"));
					ord.setSname(rs.getString("mname"));
					ordlist.add(ord);
			}
		}
		catch(Exception e) {
			System.out.println("Error in notify function: " + e);
		}
		return ordlist;
	}
	
	public Order thisOrder(int id)  throws SQLException{
		Order o = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "select o.*, p.pname, p.image, m.mname, p.price " + 
					"from ordertbl o, product p, member m " + 
					"where o.pid = p.pid AND m.mid = o.bid AND o.oid = " + id; 
		    PreparedStatement pstm = con.prepareStatement(sql);
		    ResultSet rs = pstm.executeQuery();
		    if (rs.next()) {
					o = new Order(rs.getInt("oid"), rs.getInt("sid"), rs.getInt("bid"), rs.getInt("pid"), rs.getString("pname"), rs.getString("status"));
					o.setImage(rs.getString("image"));
					o.setSname(rs.getString("mname"));
					o.setPrice(rs.getFloat("price"));
			}
		}
		catch(Exception e) {
			System.out.println("Error in thisOrder function: " + e);
		}
		return o;
	}
}
