<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Laptops</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>Laptops MANAGEMENT</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/laptops/add">New laptops</a>
		</h2>
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline d-flex"
				action="${pageContext.request.contextPath}/laptops/search"
				method="get">
				<input class="form-control mx-2" type="search" name="searchText"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</nav>
		<div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Image</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listLaptops}" var="laptop">
							<tr>
								<td>${laptop.title}</td>
								<td>${laptop.brand}</td>
								<td>${laptop.price}</td>
								<td><img
									src="${pageContext.request.contextPath}${laptop.imageUri}"
									width="164"></img></td>
								<td><a
									href="${pageContext.request.contextPath}/laptops/edit?id=${laptop.id}">Edit</a>
									<br> <a
									href="${pageContext.request.contextPath}/laptops/delete?id=${laptop.id}">Delete</a>
								</td>
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