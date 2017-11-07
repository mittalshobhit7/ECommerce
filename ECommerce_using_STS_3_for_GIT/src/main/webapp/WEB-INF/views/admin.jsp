<%@include file="/WEB-INF/views/commonTemplate/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>
        
        <!-- This is to check if 'admin' is currently logged in -->
        <c:if test="${pageContext.request.userPrincipal.name != null}" >
        	<h2>
        		Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />" > LOGOUT </a>
        	</h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" />" >Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>


        <%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>

