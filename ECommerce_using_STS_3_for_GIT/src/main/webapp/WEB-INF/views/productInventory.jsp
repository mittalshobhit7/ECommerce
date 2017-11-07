<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/commonTemplate/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/UploadedDataIsMappedHere/${product.prod_id}.png" /> " alt="image"
                             style="width:100%"/></td>    
                    <td>${product.prod_name}</td>
                    <td>${product.prod_category}</td>
                    <td>${product.prod_condition}</td>
                    <td>${product.prod_price} USD</td>
                    <td>
                    	<a href="<spring:url value="/productList/viewProduct/${product.prod_id}" />" >
                    	<span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.prod_id}" />" >
                        <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.prod_id}" />" >
                        <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct" />" class="btn btn-primary">Add Product</a>

        <%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>