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
import com.hari.dao.PaymentDao;
import com.hari.dao.ProductDao;
import com.hari.model.Member;
import com.hari.model.Order;
import com.hari.model.Payment;
import com.hari.model.Product;

@RestController
@RequestMapping("/payment")

public class PaymentController {

	OrderDao odao = new OrderDao();
	PaymentDao paydao = new PaymentDao();
	
	@RequestMapping(value = "/viewPaymentCost", method = RequestMethod.GET)
	public void viewMyProductSold(HttpServletRequest request, HttpServletResponse response, @RequestParam("oid") int oid) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			Order o = new Order();
			HttpSession session=request.getSession();  
			odao=(OrderDao)ctx.getBean("odao");
			o = odao.thisOrder(oid);
			response.sendRedirect("http://localhost:8081/PAF/addPayment.jsp");
	        session.setAttribute("thisOrderPay",o);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addPayment", method = RequestMethod.POST)
	public void addPayment(HttpServletRequest request, HttpServletResponse response, @RequestParam("oid") int oid, @RequestParam("cost") float cost, @RequestParam("address") String address) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			paydao=(PaymentDao)ctx.getBean("paydao");
			int i = paydao.addPayment(oid, cost, address);
			response.sendRedirect("http://localhost:8081/PAF/SuccaddPayment.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editOrdeletemyPaymentView", method = RequestMethod.GET)
	public void editOrdeletemyPaymentView(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			paydao=(PaymentDao)ctx.getBean("paydao");
			List<Payment> paylist = new ArrayList<Payment>();
			paylist = paydao.editOrdeletemyPaymentView(id);
			HttpSession session=request.getSession();  
	        session.setAttribute("eodpvProduct",paylist);
			response.sendRedirect("http://localhost:8081/PAF/editOrDeletePaymentView.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			paydao=(PaymentDao)ctx.getBean("paydao");
			int i = paydao.delete(id);
			response.sendRedirect("http://localhost:8081/PAF/delSuccPay.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editThisPayForm", method = RequestMethod.GET)
	public void editThisPayForm(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			paydao=(PaymentDao)ctx.getBean("paydao");
			Payment pay = paydao.editThisPayForm(id);
			HttpSession session=request.getSession();  
			session.setAttribute("paymentEdit", pay);
			response.sendRedirect("http://localhost:8081/PAF/editPayForm.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editPayment", method = RequestMethod.POST)
	public void editPayment(HttpServletRequest request, HttpServletResponse response, @RequestParam("payid") int id, @RequestParam("address") String address) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			paydao=(PaymentDao)ctx.getBean("paydao");
			int i = paydao.edit(id, address);
			response.sendRedirect("http://localhost:8081/PAF/editSucc.jsp");
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}
