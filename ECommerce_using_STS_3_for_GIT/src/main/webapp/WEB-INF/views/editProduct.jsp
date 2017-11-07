<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/commonTemplate/header.jsp" %>


<!-- this pg is same as addProduct.jsp except for the VALUE attribute.
Since, it is an Edit page, the values must be pre-filled, hence the VALUE attribute -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">You can modify the Product details here !</p>
        </div>


		<!-- Classes checkbox-inline, form-Control, control-label are just used for better aligning    -->
		
		<!-- label is used to bind the text with the input tag i.e for e.g When you click on the text(of radio button), it is allowed -->
		
		<!-- Its a SPRING FORM 
		commandName is the Data Model to which we wanna bind this form
		enctype indicates that this form can upload files-->
		
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
        <form:hidden path="prod_id" value="${product.prod_id}" /> <!-- This id to reassign the product id to the new product-->
                   
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="prod_name" id="name" class="form-Control" value="${product.prod_name}" /> <!--form-Control to cover the width of the container-->
        	<form:errors path="prod_name" cssStyle="color:#FF0000" />
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_category" id="category"
                                                             value="instrument" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_category" id="category"
                                                             value="record" />Record</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_category" id="category"
                                                             value="accessory" />Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="prod_desc" id="description" class="form-Control" value="${product.prod_desc}" />
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="prod_price" id="price" class="form-Control" value="${product.prod_price}" />
            <form:errors path="prod_price" cssStyle="color:#FF0000" />
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_condition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_condition" id="condition"
                                                             value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_status" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="prod_status" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="prod_inStockunits" id="unitInStock" class="form-Control" value="${product.prod_inStockunits}" />
            <form:errors path="prod_inStockunits" cssStyle="color:#FF0000" />
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="prod_manufacturer" id="manufacturer" class="form-Control" value="${product.prod_manufacturer}" />
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input type="file" id="productImage" path="prod_img" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>
