<%@page import="com.hari.model.Order"%>
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
Order o = new Order();
try{
	o = (Order) session.getAttribute("thisOrderPay");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
if(o != null){
	%>
		<form action = "entry/payment/addPayment" method = "POST">
			<input type = "text" name = "oid" value = "<%=o.getOid() %>" hidden/>
			oid: <%=o.getOid()%><br/>
			<input type = "text" name = "cost" value = "<%=o.getPrice() %>" hidden/>
			<img src = "<%=o.getImage() %>" height = "150px" width = "150px"/><br/>
			cost: <%=o.getPrice() %><br/>
			address: <textarea name = "address"></textarea><br/>
			<input type = "submit" value = "Add Payment"/>
		</form>
	<%
}

%>
</body>
</html>