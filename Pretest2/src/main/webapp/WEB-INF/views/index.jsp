<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eBook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>eBook MANAGEMENT</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/add">Create eBook</a> || <a href="${pageContext.request.contextPath}/delete">Delete eBook</a> 
		</h2>
		<div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Author</th>
							<th>Publisher</th>
							<th>Pages</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listeBook}" var="ebook">
							<tr>
								<td>${ebook.id}</td>
								<td>${ebook.title}</td>
								<td>${ebook.author}</td>
								<td>${ebook.publisher}</td>
								<td>${ebook.page}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>