<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- This line imports the spring tags with the prefix of form 
	 We will be using one of these spring tags to refer to header.jsp file -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- for the spring tag to work VIMP -->
	
<%@include file="/WEB-INF/views/commonTemplate/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>
			<p class="lead">Checkout all the available products !</p>
		</div>
	
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb </th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Category</th>
					<th>Product Status</th>
					<th>Product Description</th>
					<th></th> <!-- for glyphicon -->
				</tr>
			</thead>
			
			<c:forEach items="${productList}" var="product"> 
			<!-- items should be same as the attributeName in addAttribut in controller-->
				<tr>
					<td> <img src="<c:url value="/UploadedDataIsMappedHere/${product.prod_id}.png" /> " alt="image"
                             style="width:100%"/> </td>
					<td>${product.prod_name}</td> <!-- 'product' should be same as var -->
					<td>${product.prod_price}</td> <!-- Also 'product' is mainly the Model obj(attached to the view) defined in Home_Controller.java (if there was only 1 obj. present)-->
					<td>${product.prod_category}</td>
					<td>${product.prod_status}</td>
					<td>${product.prod_desc}</td>
					<td><a href="<spring:url value="/productList/viewProduct/${product.prod_id}" />" > <span class="glyphicon glyphicon-chevron-right"></span></a></td>
					
					<!-- When u hover over the glyphicon, you can see the actual link generated at the bottom -->
					<!-- Its a DYNAMIC URL - We are generating the URL here -->
					<!-- This will make sure that the current product id is mapped to the glyphicon link -->
				</tr>
			</c:forEach>
		</table>

<%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>

	