<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Add Package</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
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
			document.getElementById("city_id").innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","getCity.html?Id="+val, true);
	xmlhttp.send();
}
</script>
</head>
<body>
<div style="color: teal;font-size: 30px">Admin Add Package</div>
<s:form action="#" method="post">
	<table border="1">
	<tr>
		<td>State</td>
		<td><s:select path="state_id" items="${states}" onchange="GetCity(this.value)"></s:select></td>
	</tr>
	<tr>
		<td>City</td>
		<td><s:select path="city_id" items="${cities}"></s:select></td>
	</tr>
	<tr>
		<td>Package Title</td>
		<td><s:input path="package_title"/> </td>
	</tr>
	<tr>
		<td>Unit</td>
		<td><s:input path="unit"/> </td>
	</tr>
	<tr>
		<td>Minumum Unit Charged</td>
		<td><s:input path="min_unit_charged"/> </td>
	</tr>
	<tr>
		<td>Journey Type</td>
		<td><s:input path="journey_type"/> </td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Add package"></td>
	</tr>
	</table>
</s:form>
</body>
</html>
