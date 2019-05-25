<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src=Controller/jquery-3.4.1.min.js></script>
<script type="text/javascript" src=Controller/controllerMain.js></script>
</head>
<body>
<%@ page import = "javax.sql.*" %>
    <%@ page import = "com.hari.controller.LoginController" %>
	<%
		LoginController lg = new LoginController();
		String loginMsg = "Please login to continue";
		if(request.getMethod().equalsIgnoreCase("post")){
			if(lg.loginUser(request.getParameter("txtUserName"), request.getParameter("txtPassword"), request, response).equals("Success")){
				request.getRequestDispatcher("/Home.jsp").forward(request, response);
			}
			else{
				loginMsg = "Invalid credentials";
			}
		}
	%>

	<form id = "formLogin" action = "login.jsp" method = "post">
		UserName <input id = "txtUserName" name = "txtUserName" type = "text"> <br/>
		Password <input id = "txtPassword" name = "txtPassword" type = "password"> <br/>
		<input id = "btnLogin" name = "btnLogin" type = "button" value = "Login"> <br/>
		<div id = "divStsMsgLogin">
			<% out.println(loginMsg); %>
		</div>
		<br/>
		<a href = "AddMember.jsp">Register</a>
	</form>
</body>
</html>