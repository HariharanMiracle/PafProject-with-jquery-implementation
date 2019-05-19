package com.hari.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hari.dao.MemberDao;
import com.hari.dao.PaymentDao;
import com.hari.dao.ProductDao;
import com.hari.model.Member;
import com.hari.model.Payment;
import com.hari.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	Product prod;
	ProductDao pdao;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public void register(HttpServletRequest request, HttpServletResponse response, @RequestParam("pname") String pname, @RequestParam("price") float price, @RequestParam("mid") int mid, @RequestParam("description") String description, @RequestParam("image") String image) {
		// TODO Auto-generated method stub
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			int pid = 1;
			String url = "";
			String status = "nys";
			pdao=(ProductDao)ctx.getBean("pdao");
			prod = new Product(pid, pname, price, description, image, mid, status);
			int status2=pdao.postProduct(prod, image);
			if(status2 == -99) {
				System.out.println("Product failed to add");
				url = "http://localhost:8081/PAF/AddProdFail.jsp";
			}
			else{
				System.out.println("Product added");
				url = "http://localhost:8081/PAF/AddProdSucc.jsp";
			}
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
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
	
	@RequestMapping(value = "/viewMyProductNotSold")
	public void viewMyProductNotSold(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			List<Product> prodlist = new ArrayList<Product>();
			HttpSession session=request.getSession();  
			pdao=(ProductDao)ctx.getBean("pdao");
			Member mem = (Member) session.getAttribute("member");
			int mid = mem.getId();
			prodlist = pdao.myProductNotSold(mid);
			String url = "http://localhost:8081/PAF/viewMyProductNotYetSold.jsp";
	        session.setAttribute("myProdNYS",prodlist);
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/viewMyProductSold")
	public void viewMyProductSold(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			List<Product> prodlist = new ArrayList<Product>();
			HttpSession session=request.getSession();  
			pdao=(ProductDao)ctx.getBean("pdao");
			Member mem = (Member) session.getAttribute("member");
			int mid = mem.getId();
			prodlist = pdao.myProductSold(mid);
			String url = "http://localhost:8081/PAF/viewMyProductSold.jsp";
	        session.setAttribute("myProdSold",prodlist);
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/viewAllProduct")
	public void viewAllProd(HttpServletRequest request, HttpServletResponse response) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			List<Product> prodlist = new ArrayList<Product>();
			HttpSession session=request.getSession();  
			Member mem = (Member) session.getAttribute("member");
			pdao=(ProductDao)ctx.getBean("pdao");
			prodlist = pdao.viewAllProduct(mem.getId());
			String url = "http://localhost:8081/PAF/viewAllProduct.jsp";
	        session.setAttribute("allProd",prodlist);
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/deleteThisProd", method = RequestMethod.GET)
	public void deleteThisProd(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		int i;
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			pdao=(ProductDao)ctx.getBean("pdao");
			i = pdao.deleteThisProduct(id);
			String url = "http://localhost:8081/PAF/deleteThisProdSucc.jsp";
			redirect(url, request, response);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editThisProdForm", method = RequestMethod.GET)
	public void editThisProdForm(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			pdao=(ProductDao)ctx.getBean("pdao");
			Product prod = pdao.editThisProdForm(id);
			HttpSession session=request.getSession();  
			session.setAttribute("thisProd", prod);
			response.sendRedirect("http://localhost:8081/PAF/editThisProd.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public void editPayment(HttpServletRequest request, HttpServletResponse response, @RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("price") float price, @RequestParam("description") String description, @RequestParam("mid") int mid) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			pdao=(ProductDao)ctx.getBean("pdao");
			Product p = new Product(pid, pname, price, description, null, mid, null);
			int i = pdao.editProduct(p);
			response.sendRedirect("http://localhost:8081/PAF/editSucc.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}

