package com.hari.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hari.model.Member;
import com.hari.MemberDao.*;

@RestController
@RequestMapping("/member")

public class MemberController implements MemberControllerInt {
	
	Connection con = null;
	
	@Override
	@RequestMapping(value = "/anc", method = RequestMethod.POST)
    public Member insert(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("type") String type) {
        Member mem = new Member(id, name, password, type);

        String url = "jdbc:mysql://localhost/test";
        String username = "root";
        String pw = "";
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection(url, username, pw);
        	String sql="INSERT INTO `member`(`mid`, `mname`, `password`, `mtype`) VALUES ('"+id+"','"+name+"','"+password+"', '"+type+"')";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Member added...");
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        return mem;
    }

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Member test(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("type") String type) {
		// TODO Auto-generated method stub
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			MemberDao dao=(MemberDao)ctx.getBean("mdao");
			Member mem = new Member(id,name,password,type);
			int status=dao.addMember(mem);
			System.out.println("Member added");
			return mem;
			//return null;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Error");
			return null;
		}
	}

}
