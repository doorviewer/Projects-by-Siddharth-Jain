<%@ page import = "com.entities.Message" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- Linking CSS file -->
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.banner-background{
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 88%, 72% 100%, 43% 90%, 0 100%, 0 0);
	}
</style>
</head>
<body>

<%@include file="normal_navbar.jsp" %>

<!-- making card -->
<main class="d-flex align-items-center primary-background banner-background" style="height:80vh">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
				<div class="card-header primary-background text-white">
<!-- 				    <style>
        p{text-align: center;}
    </style> -->
						<p style="font-weight: bold; text-align: center"><span class="fa fa-user-circle-o"></span>  Login</p>
						
						
						<%
						Message m = (Message)session.getAttribute("msg");
						if(m!=null){
							%>
							<div class="alert <%= m.getCssClass() %>" role="alert"><%= m.getContent() %></div>
							
							<%
							session.removeAttribute("msg");
						}
							%>
												
						</div>
					<div class="card-body">
	<form action="LoginServlet" action="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input name = "email" required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  
    
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input name = "password" required type="password" class="form-control" id="exampleInputPassword1">
  </div>
<!--   <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1"> Remember me</label>
  </div> -->
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>		
				</div>
				</div>
			</div>
		</div>
	</div>
</main>

<!-- Jquery CDN and JS Bootstrap CDN -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- linking js file -->
<script src="js/myjs.js" type="text/javascript"></script>
</body>
</html>