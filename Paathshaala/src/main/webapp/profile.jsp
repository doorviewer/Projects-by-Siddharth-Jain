<%@page import="com.entities.User"%>
<%@page errorPage="error_page.jsp" %>

<%
User user = (User)session.getAttribute("currentUser");

if(user == null) {
	response.sendRedirect("login_page.jsp");
}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- Linking CSS file -->
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.banner-background{
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 88%, 72% 100%, 43% 90%, 0 100%, 0 0);
	}
</style>
<meta charset="ISO-8859-1">
<title>Welcome to Paathshala</title>
</head>
<body>
<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"> <span class="fa fa-bank"></span> Paathshaala</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"> <span class="fa fa-bolt"></span> LearnCoding</a>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <span class="fa fa-graduation-cap"></span> Browse Courses
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Programming Language</a></li>
            <li><a class="dropdown-item" href="#">Project Implementation</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Data Structures and Algorithms</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><span class="fa fa-paper-plane"></span> Contact Us</a>
        </li>
<!--         <li class="nav-item">
          <a href="login_page.jsp" class="nav-link"><span class="fa fa-user-circle-o"></span> Login</a>
        </li> -->
      </ul>
<!--       <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form> -->
      <ul class="navbar-nav mr-right">
      
      
                      <li class="nav-item">
          <a href="" class="nav-link">&nbsp &nbsp &nbsp &nbsp &nbsp<span class="fa fa-user-circle"></span> <%=user.getName() %> </a>
        </li>
      
              <li class="nav-item">
          <a href="LogoutServlet" class="nav-link">&nbsp &nbsp &nbsp &nbsp &nbsp<span class="fa fa-rocket"></span> Log out</a>
        </li> 
        
      </ul>
    </div>
  </div>
</nav>

<!-- Jquery CDN and JS Bootstrap CDN -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- linking js file -->
<script src="js/myjs.js" type="text/javascript"></script>
</body>
</html>