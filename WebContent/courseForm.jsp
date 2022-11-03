<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Form course</title>
</head>
<body>
	<div class="container">
		<form action="../ServletController/add" method="post">
			<table>
				<tr>
					<th>Name</th>
					<th>Level</th>
				</tr>
				<tr>
					<td><input type="text" name="name" /></td>
					<td><input type="text" name="level" /></td>
				</tr>
			</table>
			<div class="okButton">
				<button type="submit" class="btn btn-primary">Accept</button>
			</div>
		</form>
	</div>
</body>
</html>