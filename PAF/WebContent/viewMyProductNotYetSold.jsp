<%@page import="java.util.ArrayList"%>
<%@page import="com.hari.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="org.apache.commons.*" %>
   <%@ page import="sun.misc.BASE64Encoder" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> prodlist = new ArrayList<Product>();
try{
	prodlist = (List) session.getAttribute("myProdNYS");
}
catch(Exception e){
	System.out.println("Error in jsp: " + e);
}
%><h2><u>Products not yet sold</u></h2><%
int i = 0;
for(Product prod : prodlist){
	%><h3>Product Name: <%=prod.getPname() %></h3><%
	%><h3>Price: <%=prod.getPrice() %></h3><%
	%><h3>Description: <%=prod.getDescription() %></h3><%
	%><img src = "<%=prod.getImage() %>" height = "150px" width = "150px"/><%
	%><a href = "entry/product/deleteThisProd?id=<%=prod.getPid()%>">Delete</a>&nbsp;&nbsp;&nbsp;<%
	%><a href = "entry/product/editThisProdForm?id=<%=prod.getPid()%>">Edit</a>&nbsp;&nbsp;&nbsp;<%
i++;
}
if(i == 0){
	out.println("No products posted yet");
}
%>
</body>

                                                                                                           
</html>