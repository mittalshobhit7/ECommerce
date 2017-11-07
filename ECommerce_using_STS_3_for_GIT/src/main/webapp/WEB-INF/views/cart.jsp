<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<%@include file="/WEB-INF/views/commonTemplate/header.jsp" %>


<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h2>Your Cart</h2>
					
					<p> These are your Selected items</p>
				</div>
			</div>
		</section>
		
		<section class="container" data-ng-app="cartApp" data-ng-controller = "cartCtrl" data-ng-init = "initCartId('${cartId}')"> <!-- shud be same as the module defined in controller.js -->
			<!-- this means that we hv access to cartApp module functinos of controller.js within the 'section' tag here -->
			
			<div> <!-- We can directly use cartId bcoz it is coming from CartItem_Controller.java-->
			
				<div>
					<button class="btn btn-danger pull-left" data-ng-click = "clearCart()">
						<span class="glyphicon glyphicon-remove-sign"></span>Clear Cart !
					</button>
				</div>
				
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
										
					<tr data-ng-repeat = "item in cart.cartItems_map">
						<td>{{item.product.prod_name}}</td>
						<td>{{item.product.prod_price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href="#" class="label label-danger" data-ng-click="removeFromCart(item.product.prod_id)">
							<span class="glyphicon glyphicon-remove"></span>REMOVE</a></td>
							<!--this will invoke removeFromCart method in controller.js file -->
					<tr>
					
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
						<th></th>
					</tr>
					
					
				</table>
				
				<a href="<spring:url value="/productList" />" class="btn btn-primary" >Continue Shopping</a>
			</div>			
		</section>
	</div>
</div>

<!-- To include this file -->
<script src = "<c:url value="/resources/js/controller.js" />" > </script>

<!-- FOOTER -->
<%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>