<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet">
 <script type="text/javascript">
      var heap=heap||[];heap.load=function(a){window._heapid=a;var b=document.createElement("script");b.type="text/javascript",b.async=!0,b.src=("https:"===document.location.protocol?"https:":"http:")+"//cdn.heapanalytics.com/js/heap.js";var c=document.getElementsByTagName("script")[0];c.parentNode.insertBefore(b,c);var d=function(a){return function(){heap.push([a].concat(Array.prototype.slice.call(arguments,0)))}},e=["identify","track"];for(var f=0;f<e.length;f++)heap[e[f]]=d(e[f])};
      heap.load("1822735061");
    </script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function validateLoginForm() {
		if (document.getElementById('chkRememberMe').checked) {
			var email_address=document.getElementById('email_address').value;
			var password=document.getElementById('password').value;
			setCookie("email_address", email_address, 10);
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
		var emialid=getCookie('email_address');
		var password=getCookie('password');
		document.getElementById('email_address').value = emialid;
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
<div style="color: teal;font-size: 30px">Login</div>
<s:form id="login-form" action="dologin.html" method="post" commandName="command" onsubmit="validateLoginForm()">
	<table border="1">
	<tr>
		<td>UserName</td>
		<td><s:input id="email_address" path="email_address"/> </td>
	</tr>
	<tr>
		<td>Password</td>
		<td><s:password id="password" path="password"/> </td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input id="userLogin" type="submit" value="Login"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">Remember Me<input type="checkbox" id="chkRememberMe"></td>
	</tr>
	</table>
</s:form>
		<script src="js/jquery-1.7.1.min.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/validation.js"></script>
</body>
</html>