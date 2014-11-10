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
<div style="color: teal;font-size: 30px">Admin Forgot password</div>
<s:form action="doAdminForpass.html" method="post" commandName="command" onsubmit="validateLoginForm()">
	<table border="1">
	<tr>
		<td>E-Mailid</td>
		<td><s:input path="userName"/> </td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
	</table>
</s:form>
</body>
</html>