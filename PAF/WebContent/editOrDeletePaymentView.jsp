<%@page import="java.util.ArrayList"%>
<%@page import="com.hari.model.Payment"%>
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
List<Payment> paylist = new ArrayList<Payment>();
try{
	paylist = (List) session.getAttribute("eodpvProduct");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
int i = 0;
for(Payment pay : paylist){
	%><img src = "<%=pay.getImage() %>" height = "150px" width = "150px"/><br/><%
	%><h3>Product Name: <%=pay.getPname() %></h3><%
	%><h3>Address: <%=pay.getAddress() %></h3><%
	%><h3>Cost: <%=pay.getCost() %></h3><%
	%><a href = "entry/payment/delete?id=<%=pay.getPayid()%>">Delete</a>&nbsp;&nbsp;&nbsp;<%
	%><a href = "entry/payment/editThisPayForm?id=<%=pay.getPayid()%>">Edit</a>&nbsp;&nbsp;&nbsp;<hr/><%
	i++;
}
if(i == 0){
	out.println("No payments");
}
%>

</body>
</html>