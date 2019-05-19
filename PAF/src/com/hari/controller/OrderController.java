package com.hari.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hari.dao.OrderDao;
import com.hari.dao.ProductDao;
import com.hari.model.Member;
import com.hari.model.Order;
import com.hari.model.Product;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	OrderDao odao = new OrderDao();
	ProductDao pdao = new ProductDao();
	
	@RequestMapping(value = "/orederProduct", method = RequestMethod.GET)
	public void orederProduct(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			odao=(OrderDao)ctx.getBean("odao");
			pdao=(ProductDao)ctx.getBean("pdao");
			HttpSession session=request.getSession();  
	        Member mem = (Member) session.getAttribute("member");
	        Product p = pdao.editThisProdForm(id);
	        int i = odao.orderProduct(p.getMid(), mem.getId(), id, "pending");
	        response.sendRedirect("http://localhost:8081/PAF/SuccorderProduct.jsp");
	        System.out.println("Order pending...");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@RequestMapping(value = "/orderOpp", method = RequestMethod.GET)
	public void orderOpp(HttpServletRequest request, HttpServletResponse response) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			List<Order> ordlist = new ArrayList<Order>();
			odao=(OrderDao)ctx.getBean("odao");
			HttpSession session=request.getSession();  
	        Member mem = (Member) session.getAttribute("member");
	        ordlist = odao.orderOpp(mem.getId());
	        session.setAttribute("orderaa", ordlist);
	        response.sendRedirect("http://localhost:8081/PAF/orderOpperation.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@RequestMapping(value = "/editOrder", method = RequestMethod.GET)
	public void editOrder(HttpServletRequest request, HttpServletResponse response, @RequestParam("val") String val, @RequestParam("oid") int oid) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			odao=(OrderDao)ctx.getBean("odao");
	        int i = odao.editOrder(oid, val);
	        response.sendRedirect("http://localhost:8081/PAF/addProduct.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@RequestMapping(value = "/notify", method = RequestMethod.GET)
	public void notify(HttpServletRequest request, HttpServletResponse response) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			List<Order> ordlist = new ArrayList<Order>();
			odao=(OrderDao)ctx.getBean("odao");
			HttpSession session=request.getSession();  
	        Member mem = (Member) session.getAttribute("member");
	        ordlist = odao.notify(mem.getId());
	        session.setAttribute("orderNotify", ordlist);
	        response.sendRedirect("http://localhost:8081/PAF/orderNotify.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
