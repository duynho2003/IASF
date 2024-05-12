<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Laptop Shop</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h1>NEW LAPTOP</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/laptops">Back to
				Laptop list</a>
		</h2>
		<div>
			<form:form action="${pageContext.request.contextPath}/laptops/update"
				method="post" modelAttribute="laptop" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<td><form:hidden path="id" /> <form:hidden path="image" /></td>
					</tr>
					<tr>
						<td>Laptop title:</td>
						<td><form:input path="title" /></td>
						<td><form:errors path="title" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Laptop brand:</td>
						<td><form:input path="brand" /></td>
						<td><form:errors path="brand" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td><form:input path="price" /></td>
					</tr>
					<tr>
						<td>Image:</td>
						<td><img
							src="${pageContext.request.contextPath}${laptop.imageUri}"
							width="128"></img></td>
					</tr>
					<tr>
						<td>Select a file to upload:</td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>