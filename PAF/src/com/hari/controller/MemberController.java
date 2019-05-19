package com.hari.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.swing.text.Document;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hari.dao.*;
import com.hari.model.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")

public class MemberController implements MemberControllerImpl {
	
	private Connection con = null;
	Member mem;
	MemberDao dao;
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public Member register(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("type") String type, @RequestParam("add") String add, @RequestParam("mail") String mail, @RequestParam("cno") int cno) {
		// TODO Auto-generated method stub
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			int id = 1;
			String status2 = "Active";
			dao=(MemberDao)ctx.getBean("mdao");
			mem = new Member(id, name, password, type, add, mail, cno, status2);
			int status=dao.registerMember(mem);
			String url;
			if(status == -99) {
				System.out.println("Member failed to add");
				url = "http://localhost:8081/PAF/AddMemFail.jsp";
			}
			else{
				System.out.println("Member added");
				url = "http://localhost:8081/PAF/AddMemSucc.jsp?memN="+name;
			}
			
			redirect(url, request, response);
			return mem;
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
	}

	@Override
	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
        	response.sendRedirect(url);
        }
        catch (Exception e) {
            // TODO: handle exception
        	//response.sendRedirect("http://localhost:8081/PAF/logReg.jsp");
            System.out.println("Failed");
        }
	}

	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	@Override
	public Member myProfile(HttpServletRequest request, HttpServletResponse response,  @RequestParam("name") String name) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			String url;
			dao=(MemberDao)ctx.getBean("mdao");
			mem = dao.getMem(name);
			url = "http://localhost:8081/PAF/myprofile.jsp?name="+mem.getName()+"&type="+mem.getType()+"&address="+mem.getAddress()+"&mail="+mem.getMail()+"&num="+mem.getContactNumber()+"&status="+mem.getStatus();
			redirect(url, request, response);
			return mem;
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			return mem;
		}
	}

	@Override
	@RequestMapping(value = "/generateUpdateForm", method = RequestMethod.GET)
	public Member generateUpdateForm(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			dao=(MemberDao)ctx.getBean("mdao");
			mem = dao.getMem(name);
			String url, msg;
			if(mem == null) {
				System.out.println("Something went wrong");
				msg = "Something went wrong";
				url = "http://localhost:8081/PAF/editMyProfile.jsp?msg="+msg;
			}
			else{
				System.out.println("Member found");
				String number = Integer.toString(mem.getContactNumber());
				url = "http://localhost:8081/PAF/editMyProfile.jsp?type="+mem.getType()+"&address="+mem.getAddress()+"&mail="+mem.getMail()+"&num="+number+"&password="+mem.getPassword();
				//url = "http://localhost:8081/PAF/editMyProfile.jsp?type="+mem.getType()+"&password="+mem.getPassword()+"&address="+mem.getAddress()+"&mail="+mem.getMail()+"&num="+mem.getContactNumber()+"&status="+mem.getStatus();
			}
			redirect(url, request, response);
			return mem;
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			String msg = "Something went wrong";
			String url = "http://localhost:8081/PAF/editMyProfile.jsp?msg="+msg;
			redirect(url, request, response);
			return null;
		}
	}

	@Override
	@RequestMapping(value = "/updateMemeber", method = RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response,  @RequestParam("name") String name,  @RequestParam("type") String type, @RequestParam("add") String add, @RequestParam("mail") String mail, @RequestParam("cno") int cno) throws ServletException, IOException {
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			dao=(MemberDao)ctx.getBean("mdao");
			mem = new Member(1, name, "null", type, add, mail, cno, "null");
			int status=dao.updateMember(mem);
			String url = "";
			if(status == -99) {
				System.out.println("Member failed to update");
			}
			else{
				System.out.println("Member updated");
				url = "http://localhost:8081/PAF/UpdMemSucc.jsp";
			}
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	@RequestMapping(value = "/deactivate", method = RequestMethod.GET)
	public void deactivate(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			dao=(MemberDao)ctx.getBean("mdao");
			String url = "";
			String msg = "Your account is deactivated";
			int status = dao.deactivate(name);
			if(status == -99) {
				System.out.println("Member failed to deactivate");
			}
			else{
				System.out.println("Member deactivated");
				url = "http://localhost:8081/PAF/logReg.jsp?msg="+msg;
			}
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}


	
	/*
	@Override
	@RequestMapping(value = "/anc", method = RequestMethod.POST)
    public Member insert(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("type") String type, @RequestParam("add") String add, @RequestParam("mail") String mail, @RequestParam("cno") int cno) {
        int id = 1;
		Member mem = new Member(id, name, password, type, add, mail, cno);

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
*/
}
