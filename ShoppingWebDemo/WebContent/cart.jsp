<%@ page import="com.revature.connection.DbCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.revature.model.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>
<%@ include file="includes/head.jsp"%>
<link rel="stylesheet" href="CssFiles/cart.css">

</head>
<body>

	<%@ include file="includes/footer.jsp"%>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price : $40</h3>
			<a class="mx-3 btn-primary" href="#">Check Out</a>
		</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Product</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td> <img src="ProductImages/headphones.jpg"  class="product-img"></td>
					<td>Headphones</td>
					<td>Electronics</td>
					<td>$140</td>
					<td>
						<form action="" method="post" class="form-inline">
							<input type="hidden" name="id" value="1" class="form-input">
							<div class="form-group d-fle justify-content-between">
								<a class="btn btn-sm btn-decre" href="#"><i
									class="fas fa-minus-square"></i></a> <input type="text"
									name="quantity" class="form-control" value="1" readonly>

								<a class="btn btn-sm btn-incre" href="#"><i
									class="fas fa-plus-square"></i></a>
							</div>
						</form>
					</td>
					<td><a class="btn btn-sm btn-danger" href="#">Remove</a></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>