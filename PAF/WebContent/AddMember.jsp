<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Member</h1>
	<form action="entry/member/insert" method="POST">
		id: <input type="text" name="id"/><br/>
		name: <input type="text" name="name"/><br/>
		password: <input type="text" name="password"/><br/>
		type: <input type="text" name="type"/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>