<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/commonTemplate/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">
			<h2>Please Login using Credentials</h2>
				
				<!-- these values - logout_msg, error should be same as used in login_Controller class -->
				
				<c:if test ="${not empty logout_msg}">  <!-- VIMP, Here, test,not,empty are all KEYWORDS -->
					<div class="logout_msg">${logout_msg} </div>
				</c:if>
			
			<!-- "/j_spring_security_check" is the default login processing URL, just like the logout-url -->
			<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
				
				<c:if test = "${not empty error}">
					<div class="error" style="color:#FF0000"> ${error} </div>
				</c:if>
				
				<!--The name attribute of these 2 should match with username-parameter & password-parameter of mySecurity.xml -->
				<div class="form-group">
					<label for="user">UserName: </label>
					<input type="text" id="user" name="username" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="pwd">Password: </label>
					<input type="password" id="pwd" name="password" class="form-control"/>
				</div>
				
				<button class="btn btn-primary" value="Login">Login</button>
				
				<input type="hidden" name="${csrf.parameterName}" value="${csrf.token}" />
				<!-- csrf is very critical for Security, google it & read frm spring docs -->
				 
			</form>
		</div>
	</div>
</div>










<%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>