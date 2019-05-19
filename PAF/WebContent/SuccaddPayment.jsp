<%@page import="com.hari.model.Member"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Member mem = (Member) session.getAttribute("member");
String un = "";
if(mem == null){
	String msg = "Login First";
	String redirectURL = "http://localhost:8081/PAF/logReg.jsp?msg="+msg;
	response.sendRedirect(redirectURL);
}
else{
	un = mem.getName();
}
%>
payment added successfully!!!
<a href = "entry/payment/editOrdeletemyPaymentView?id=<%=mem.getId() %>">Edit or delete my payments</a>
</body>
</html>