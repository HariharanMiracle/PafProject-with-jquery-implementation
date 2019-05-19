<%@page import="com.hari.model.Product"%>
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
	Product p = (Product) session.getAttribute("thisProd");
	if(p != null){
		%>
			<form style = "text-align: center" action="entry/product/editProduct" method="POST">
					<h1>Edit Product</h1>
					<input type="text" name="pid" value = "<%=p.getPid() %>" hidden/>
					<label>pname:</label> <input type="text" name="pname" value = "<%=p.getPname() %>" required/><br/>
					<label>price:</label> <input type="text" name="price" value = "<%=p.getPrice() %>" required/><br/>
					<label>description:</label> 
					<textarea name = "description"><%=p.getDescription()%></textarea><br/>
					<input type="text" name="mid" value = "<%=p.getMid()%>" hidden/><br/>
					<input type="submit" value="Submit"/>
				</form>
		<%
	}
	else{
		out.println("Something went wrong");
	}
%>

</body>
</html>