<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/register.css" />
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
</head>
<body>

<div id="nav-placeholder"></div> 
<script>
$(function(){
  $("#nav-placeholder").load("nav");
});
</script>

<div class="container">
        
        <div class="hero">
            <div class="text">
                <p class="gray">Welcome Back</p>
                <h1>Login to your Account <span class="blue">.</span></h1>
              
            </div>
            <form:form action="validateCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<!-- also protect the id and customerEvents from being over written -->
			<form:hidden path="id" />
            <div class="form">

                
                <div class="id">
                    <div class="input-icons">
                        <legend for="email">Email</legend>
                        <div class="icon-center">
                            <form:input path="email" class="input" type="email" id="email"/>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-envelope-fill" viewBox="0 0 16 16">
                                <path
                                    d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555ZM0 4.697v7.104l5.803-3.558L0 4.697ZM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757Zm3.436-.586L16 11.801V4.697l-5.803 3.546Z" />
                            </svg>
                        </div>
                    </div>
                    <div class="input-icons">
                        <legend for="password">Password</legend>
                        <div class="icon-center">
                            <form:input path="password" class="input" type="password" id="password"/>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-eye-fill" viewBox="0 0 16 16">
                                <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z" />
                                <path
                                    d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z" />
                            </svg>
                        </div>
                    </div>
                </div>

                <div class="buttons">
                    <button class="btn gray-btn">Back</button>
                    <button type= "submit" class="btn blue-btn">Login</button>
                </div>
                </form:form>
            </div>
        </div>
        
    </div>

</body>
</html>