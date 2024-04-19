<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Shop</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>BOOKS MANAGEMENT</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/books/add">New book</a>
		</h2>
		<div>
			<form:form action="${pageContext.request.contextPath}/books/addcart"
				modelAttribute="bookOrder" method="post">
				<div class="my-3 d-flex col-md-6">
					<form:select path="userId" cssClass="form-select">
						<form:option value="0" label="Select user would place order"></form:option>
						<c:forEach items="${listCustomers}" var="customer">
							<form:option value="${customer.id}" label="${customer.fullName}"></form:option>
						</c:forEach>
					</form:select>
					<input type="submit" value="Check out" class="btn btn-primary mx-3" />
				</div>
				<div>
					<table class="table">
						<thead>
							<tr>
								<th>Add to Cart</th>
								<th>Title</th>
								<th>Author</th>
								<th>Price</th>
								<th>Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listBooks}" var="book">
								<tr>
									<td><form:checkbox path="selectedBooks" value="${book.id}"
											cssClass="form-check" /></td>
									<td>${book.title}</td>
									<td>${book.author}</td>
									<td>${book.price}</td>
									<td><img
										src="${pageContext.request.contextPath}${book.imageUri}"
										width="164"></img></td>
									<td><a
										href="${pageContext.request.contextPath}/books/edit?id=${book.id}">Edit</a>
										<br> <a
										href="${pageContext.request.contextPath}/books/delete?id=${book.id}">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>