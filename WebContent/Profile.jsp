<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<script type="text/javascript">
function GetCity(val){
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("city").innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","getCity.html?state_id="+val, true);
	xmlhttp.send();
}
</script>
</head>
<body>
<table border="1">
	<tr>
		<td>User Id</td>
		<td>${user.user_id}</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td>${user.first_name}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${user.last_name}</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${user.address}</td>
	</tr>
	<tr>
		<td>Email Address</td>
		<td>${user.email_address}</td>
	</tr>
	<tr>
		<td>State</td>
		<td>
			<select id="state" name="state" onchange="GetCity(this.value)">
				<c:forEach items="${state}" var="data">
					<c:choose>
      					<c:when test="${data.key == user.state_master.state_id}"><option value="${data.key}" selected>${data.value}</option></c:when>
      					<c:otherwise><option value="${data.key}">${data.value}</option></c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>City</td>
		<td>
			<select id="city" name="city">
				<c:forEach items="${city}" var="data">
					<option value="${data.key}">${data.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
</table>
</body>
</html>