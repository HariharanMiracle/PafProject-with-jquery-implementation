package com.hari.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginControllerImpl {
	public void login(String name, String password, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	void redirect(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
