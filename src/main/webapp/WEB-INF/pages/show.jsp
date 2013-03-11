<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="10" >
<title>Notifications</title>
<style>
table{width:100%;border-collapse:collapse;}
td{border: 1px solid black}
thead{background-color:gray;color:white;}

</style>
</head>
<body>
<h2>WP Callback Strings</h2>
<form action="deleteall" method="POST">
	<input type="submit" name="delete all" title="delete" value="delete all"/>
</form>
<table>
<thead>
	<tr>
		<td>Date</td>
		<td>Raw</td>
		<td></td>
	</tr>
</thead>
<c:forEach items="${notifications}" var="notification">

<tr>
	<td>${notification.date}</td>
	<td>${notification.headers}</td>
	<td>
		<form action="delete" method="POST">
			<input type="hidden" name="id" value="${notification.id}"/>
			<input type="submit" name="delete" title="delete" value="delete"/>
		</form>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>
