<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>List of courses</title>
</head>
<body>
	<form action="../ServletController/filter" method="post">
		<input type="text" name="filterName" id="filterName" />
		<button type="submit" class="btn btn-primary" value="filter">Filter</button>
	</form>
	<table>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listOfCourses}" var="course">
			<tr>
				<td><c:out value="${course.name}" /></td>
				<td><c:out value="${course.level}" /></td>
				<td>
					<form action="../ServletController/delete" method="post">
						<input type="hidden" name="name" value="${course.name}" /> <input
							type="hidden" name="level" value="${course.level}" />
						<button type="submit" class="btn btn-outline-danger">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="../ServletController/insert">
		<button type="submit" class="btn btn-primary">Add course</button>
	</form>
</body>
</html>
