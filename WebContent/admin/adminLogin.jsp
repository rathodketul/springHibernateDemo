<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
	function validateLoginForm() {
		if (document.getElementById('chkRememberMe').checked) {
			var userName=document.getElementById('userName').value;
			var password=document.getElementById('password').value;
			setCookie("userName", userName, 10);
			setCookie("password", password, 10);
        }
	}
	function getCookie(c_name) {
		var c_value = document.cookie;
		var c_start = c_value.indexOf(" " + c_name + "=");
		if (c_start == -1) {
			c_start = c_value.indexOf(c_name + "=");
		}
		if (c_start == -1) {
			c_value = null;
		} else {
			c_start = c_value.indexOf("=", c_start) + 1;
			var c_end = c_value.indexOf(";", c_start);
			if (c_end == -1) {
				c_end = c_value.length;
			}
			c_value = unescape(c_value.substring(c_start, c_end));
		}
		return c_value;
	}
	function checkCookie(){
		var emialid=getCookie('userName');
		var password=getCookie('password');
		document.getElementById('userName').value = emialid;
		document.getElementById('password').value = password;
	}
	function setCookie(c_name, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value = escape(value)
				+ ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
		document.cookie = c_name + "=" + c_value;
	}
</script>
</head>
<body onload="checkCookie()">
<div style="color: teal;font-size: 30px">Admin Login</div>
<s:form action="doAdminLogin.html" method="post" commandName="command" onsubmit="validateLoginForm()">
	<table border="1">
	<tr>
		<td>UserName</td>
		<td><s:input path="userName"/> </td>
	</tr>
	<tr>
		<td>Password</td>
		<td><s:password path="password"/> </td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">Remember Me<input type="checkbox" id="chkRememberMe"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">Forgot Password <a href="adminForgotpass.html">Click Here</a></td>
	</tr>
	</table>
</s:form>
</body>
</html>