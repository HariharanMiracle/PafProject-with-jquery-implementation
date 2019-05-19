package com.hari.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hari.model.*;

public interface MemberControllerImpl {
	public Member register(HttpServletRequest request, HttpServletResponse response, String name, String password, String type, String address,  String mail, int contactNumber);
	public void delete();
	public void update(HttpServletRequest request, HttpServletResponse response, String name, String type, String add, String mail, int cno)throws ServletException, IOException;
	public void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public Member myProfile(HttpServletRequest request, HttpServletResponse response, String name);
	public Member generateUpdateForm(String name, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public void deactivate(String name, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
