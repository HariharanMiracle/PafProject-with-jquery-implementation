package com.hari.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import javax.websocket.Decoder.BinaryStream;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hari.model.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int postProduct(Product p, String image){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String imageUrl = "themes/images/" + image;
			PreparedStatement ps=con.prepareStatement("INSERT INTO `product` (`pname`, `price`, `description`, `mid`, `image`) VALUES (?, ?, ?, ?, ?)"); 
			ps.setString(1,p.getPname());
			ps.setFloat(2,p.getPrice());
			ps.setString(3,p.getDescription());
			ps.setInt(4,p.getMid());
			ps.setString(5,imageUrl);
			ps.executeUpdate();
			ps.close();
			con.close();
			return 1;
		}catch(Exception e){
			System.out.println("Error in prodController");
			e.printStackTrace();
			return -99;
		}
	}
	
	public List<Product> myProductNotSold(int mid)  throws SQLException{
		List<Product> prodlist = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "Select * from product where mid = '"+mid+"' AND status = 'nys'";
		    PreparedStatement pstm = con.prepareStatement(sql);
		    ResultSet rs = pstm.executeQuery();
		    while (rs.next()) {
					Product prod = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
					prodlist.add(prod);
			}
		}
		catch(Exception e) {
			System.out.println("Error in product function: " + e);
		}
		return prodlist;
	}
	
	public List<Product> myProductSold(int mid)  throws SQLException{
		List<Product> prodlist = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "Select * from product where mid = '"+mid+"' AND status = 'sold'";
		    PreparedStatement pstm = con.prepareStatement(sql);
		      //pstm.setLong(1, id);
		    ResultSet rs = pstm.executeQuery();
		    while (rs.next()) {
					Product prod = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
					prodlist.add(prod);
			}
		}
		catch(Exception e) {
			System.out.println("Error in product function: " + e);
		}
		return prodlist;
	}
	
	public List<Product> viewAllProduct(int mid) {
		List<Product> prodlist = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "Select * from product where status = 'nys' AND pid NOT IN (select o.pid from ordertbl o where o.bid = " + mid + ")";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product prod = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				prodlist.add(prod);
			}
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return prodlist;
	}
	
	public int deleteThisProduct(int id) {
		int i = -99;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "DELETE from product where pid = '"+id+"'";
			PreparedStatement pstm = con.prepareStatement(sql);
			i = pstm.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return i;
	}
	
	public Product editThisProdForm(int id) {
		Product p = new Product();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			String sql = "Select * from product where pid = '"+id+"'";
		    PreparedStatement pstm = con.prepareStatement(sql);
		    ResultSet rs = pstm.executeQuery();
		    if (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			}
		}
		catch(Exception e) {
			System.out.println("Error: " +e);
		}
		return p;
	}
	
	public int editProduct(Product p){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			PreparedStatement ps=con.prepareStatement("UPDATE `product` SET `pname`='"+p.getPname()+"', `price`='"+p.getPrice()+"', `description`='"+p.getDescription()+"' WHERE `pid`='"+p.getPid()+"'");
			ps.executeUpdate();
			ps.close();
			con.close();
			return 1;
		}catch(Exception e){
			System.out.println("Error in prodController");
			e.printStackTrace();
			return -99;
		}
	}
}
