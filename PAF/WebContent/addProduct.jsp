<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.hari.model.*" %>
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
				<form style = "text-align: center" action="entry/product/addProduct" method="POST">
					<h1>Add Product</h1>
					<label>pname:</label> <input type="text" name="pname" required/><br/>
					<label>price:</label> <input type="text" name="price" required/><br/>
					<label>description:</label> 
					<textarea name = "description"></textarea><br/>
					<label>image:</label> <input type="file" name="image"/><br/>
					<input type="text" name="mid" value = "<%=mem.getId()%>" hidden/><br/>
					<input type="submit" value="Submit"/>
				</form>
</body>
</html>