<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- This line imports the spring tags with the prefix of form 
	 We will be using one of these spring tags to refer to header.jsp file -->
	 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 
<%@include file="/WEB-INF/views/commonTemplate/header.jsp"%>


	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Product Details</h1>
				<p class="lead">Here are the details of your Product !</p>
			</div>
			
			<div class="container" ng-app="cartApp">	
				<div class="row">
					<div class="col-md-5">
						<img src="<c:url value="/UploadedDataIsMappedHere/${product.prod_id}.png" />" alt="image" style="width:100%; height=100%" />
					</div>
					
					<div class="col-md-5">
						<h2>${product.prod_name}</h2> <!-- I guess this 'product' shud be same as in Home Controller for this particualr mapping -->
						<p>${product.prod_desc}</p>
						<p><h4>${product.prod_price}</h4></p>
						<p><strong>Units left in Stock:</strong>${product.prod_inStockunits}</p>
						<p>${product.prod_category}</p>
						
						<br>
						
						<c:set var="role" scope="page" value="${param.role}" /> 
						<c:set var="url" scope="page" value="/productList" />
						
						<!-- It means this whole page has access to variable role -->
						
						<c:if test="${role=='admin'}"> <!-- If admin is already logged in, show him the Inventory Page instead of normal productList pg -->
							<c:set var="url" scope="page" value="/admin/productInventory" />
						</c:if>
						
	                    <p ng-controller="cartCtrl"> <!--As defined in controller.js -->
	                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
	                        
	                        <a href="#" class="btn btn-warning btn-large"
	                           ng-click="addToCart('${product.prod_id}')">
	                           <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
	                           
	                        <a href="<spring:url value="/cart" />"
	                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
	                    </p>
					</div>
				</div>
			</div>

<!-- To include this file -->
<script src = "<c:url value="/resources/js/controller.js" />" > </script>

<%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>
