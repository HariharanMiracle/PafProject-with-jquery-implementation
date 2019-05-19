<%@page import="com.hari.model.Payment"%>
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
Payment pay = new Payment();
try{
	pay = (Payment) session.getAttribute("paymentEdit");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
%>
<h2><u>Edit Payment</u></h2>
<form action = "entry/payment/editPayment" method = "POST">
	<input type = "text" name = "payid" value = "<%=pay.getPayid()%>" hidden/>
	<textarea name = "address"><%=pay.getAddress() %></textarea>
	<br/>
	<input type = "submit" value = "Edit"/>
</form>
</body>
</html>