<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new eBook</title>
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
		<h1>NEW EBOOK</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/">Back to eBook list</a>
		</h2>
		<div>
			<form:form action="save" method="post" modelAttribute="ebook">
				<table class="table">
					<tr>
						<td>Title:</td>
						<td><form:input path="title" /></td>
						<form:errors path="title" cssClass="error" />
					</tr>
					<tr>
						<td>Author:</td>
						<td><form:input path="author" /></td>
						<form:errors path="author" cssClass="error" />
					</tr>
					<tr>
						<td>Publisher:</td>
						<td><form:input path="publisher" /></td>
						<form:errors path="publisher" cssClass="error" />
					</tr>
					<tr>
						<td>Pages:</td>
						<td><form:input path="page" /></td>
						<form:errors path="page" cssClass="error" />
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