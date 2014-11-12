<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td colspan="3">Welcome...${sessionuser}</td>
	</tr>
	<tr>
		<td><a href="Home.html">Home</a></td>
		<td><a href="Profile.html">Profile</a></td>
		<td><a href="#">Logout</a></td>
	</tr>
</table>
	
</body>
</html>