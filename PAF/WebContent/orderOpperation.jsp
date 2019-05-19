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
	ordlist = (List) session.getAttribute("orderaa");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
int i = 0;
for(Order ord : ordlist){
	%><h3>Order Id: <%=ord.getOid() %></h3><%
	%><h3>Buyer Name: <%=ord.getSname() %></h3><%
	%><h3>Product name: <%=ord.getPname() %></h3><%
	%><img src = "<%=ord.getImage() %>" height = "150px" width = "150px"/><%
	%><a href = "entry/order/editOrder?val=Accept&oid=<%=ord.getOid()%>">Accept</a>&nbsp;&nbsp;&nbsp;<%
	%><a href = "entry/order/editOrder?val=Decline&oid=<%=ord.getOid()%>">Decline</a><hr/><%
	i++;
}
if(i == 0){
	out.println("No Orders");
}
%>
</body>
</html>