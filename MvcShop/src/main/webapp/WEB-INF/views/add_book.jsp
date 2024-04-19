<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mvc Shop</title>
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
		<h1>NEW BOOK</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/books">Back to Books
				list</a>
		</h2>
		<div>
			<form:form action="save" method="post" modelAttribute="book">
				<table class="table">
					<tr>
						<td>Book title:</td>
						<td><form:input path="title" /></td>
						<td><form:errors path="title" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Author Name:</td>
						<td><form:input path="author" /></td>
						<td><form:errors path="author" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td><form:input path="price" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="Create"></td>
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