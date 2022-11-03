<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Form course</title>
</head>
<body>
	<div class="container">
		<h2>Add course Form</h2>
		<div class="card">
			<div class="card-body">
				<form action="../ServletController/add" method="post">
					<div class="form-group row">
						<label for="name" class="col-sm-2 col-form-label">Name</label>
						<div class="col-sm-7">
							<input type="text" name="name" />
						</div>
					</div>
					<div class="form-group row">
						<label for="level" class="col-sm-2 col-form-label">Level</label>
						<div class="col-sm-7">
							<input type="text" name="level" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Accept</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>