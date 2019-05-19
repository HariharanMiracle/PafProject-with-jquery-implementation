<%@page import="java.util.ArrayList"%>
<%@page import="com.hari.model.Order"%>
<%@page import="java.util.List"%>
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
List<Order> ordlist = new ArrayList<Order>();
try{
	ordlist = (List) session.getAttribute("orderNotify");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
int i = 0;
for(Order ord : ordlist){
	%><h3>Order Id: <%=ord.getOid() %></h3><%
	%><h3>Product name: <%=ord.getPname() %></h3><%
	%><img src = "<%=ord.getImage() %>" height = "150px" width = "150px"/><%
	%><h3>Product status: <%=ord.getStatus() %></h3><%
	if(ord.getStatus().equals("Accept")){
		%><a href = "entry/payment/viewPaymentCost?oid=<%=ord.getOid()%>">payment cost</a><hr/><%
	}
	i++;
}
if(i == 0){
	out.println("You have not ordered anything!!!");
}
%>
</body>
</html>