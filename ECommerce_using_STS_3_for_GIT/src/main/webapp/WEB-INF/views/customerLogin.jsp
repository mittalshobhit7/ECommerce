<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- This line is namdatory for jsp tags to function properly -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- The below 2 lines are mandatory to implement Google SignIn
	content is the client ID-->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="252620540089-d5klvj75jnmsjj3gp1ibpbpah0u378vq.apps.googleusercontent.com">

<link rel="icon" href="../../favicon.ico">

<title>Customer Login</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<!-- Carousel CSS -->
<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

<!-- user defined CSS -->
<link href="<c:url value="/resources/css/cust_login.css" />" rel="stylesheet">

<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<script>
		window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"> <\/script>')
	</script>
	<script src="<c:url value ="/resources/js/bootstrap.min.js" />" >
		
	</script>
	
<!-- For including Angular JS -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"> </script>



</head>

<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">My Music Store</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/" />">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="<c:url value="productList" />" > Products</a></li>
						<li><a href="#contact">Contact</a></li>
						<li><a href="<c:url value="customerLogin" />">Sign In</a></li>
						
						<!-- 
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
						-->
					</ul>
					
					<ul class="nav navbar-nav pull-right">
						<li><a href="<c:url value="/admin" />" >Admin</a></li>
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>
 
 <!-- till here, its the Common header file only -->


<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<div class="wrap">
<!-- strat-contact-form -->	
<div class="contact-form">
<!-- start-form -->
	<form class="contact_form" action="#" method="post" name="contact_form">
		<h1>Login Into Your Account</h1>
	    <ul>
	        <li>
	            <input type="email" class="textbox1" name="email" placeholder="info@w3layouts.com" required />
	            <span class="form_hint">Enter a valid email</span>
	             <p><img src="/resources/images/contact.png" alt=""></p>
	        </li>
	        <li>
	            <input type="password" name="website" class="textbox2" placeholder="password">
	            <p><img src="/resources/images/lock.png" alt=""></p>
	        </li>
         </ul>
       	 	<input type="submit" name="Sign In" value="Sign In"/>
			<div class="clear"></div>	
			<label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>Remember me</label>
		<div class="forgot">
			<a href="#">forgot password?</a>
		</div>	
		<div class="clear"></div>	
	</form>
<!-- end-form -->
<!-- start-account -->
<div class="account">
	<h2><a href="#">Don' have an account? Sign Up!</a></h2>
    <div class="span"><a href="#"><img src="/resources/images/facebook.png" alt=""/><i>Sign In with Facebook</i><div class="clear"></div></a></div>	
    <div class="span1"><a href="#"><img src="/resources/images/twitter.png" alt=""/><i>Sign In with Twitter</i><div class="clear"></div></a></div>
    <div class="span2 g-signin2" data-onsuccess="onSignIn"><img src="/resources/images/gplus.png" alt=""/><i>Sign In with Google+</i><div class="clear"></div></div>
    
    <!-- <div class="g-signin2" data-onsuccess="onSignIn"></div> -->
   
    <script type="text/javascript">
      	function onSignIn(googleUser) {
	      // window.location.href='success.jsp';
	      var profile = googleUser.getBasicProfile();
	      var imagurl=profile.getImageUrl();
	      var name=profile.getName();
	      var email=profile.getEmail();
	      document.getElementById("myImg").src = imagurl;
	      document.getElementById("name").innerHTML = name;
	      document.getElementById("myP").style.visibility = "hidden";
	      document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'
	   }
   </script>
   
   <button onclick="myFunction()">Sign Out</button>
   
   <script>
   	   function myFunction() {
	      gapi.auth2.getAuthInstance().disconnect();
	      location.reload();
	   }
   </script>
   
</div>	
<!-- end-account -->
<div class="clear"></div>	
</div>
<!-- end-contact-form -->

<!-- footer -->
<%@include file="/WEB-INF/views/commonTemplate/footer.jsp" %>

</div>
