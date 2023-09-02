<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.sql.*" %>
<%@ page import = "com.helper.ConnectionProvider" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Paathshaala</title>
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
</head>
<body>

<!-- navbar -->
<%@include file="normal_navbar.jsp" %>
<!-- navbar -->

<!-- banner -->
<div class="container-fluid p-0 m-0 banner-background">
<div class="jumbotron primary-background text-white">
<div class="container" style="height: 340px;">
<h3 class="display-3">Welcome to Paathshaala</h3>
<!-- <h3 style="font-size:25px">LearnCoding</h3> -->
<p>Welcome to Paathshaala, a space to learn.</p>
	<p>A programming language is a system of notation for writing computer programs. Most programming languages are text-based formal languages, but they may also be graphical. They are a kind of computer language.</p></p>
	<p>The description of a programming language is usually split into the two components of syntax (form) and semantics (meaning), which are usually defined by a formal language.</p>
	<button class="btn btn-outline-light btn-lg"><span class="fa fa-rocket"></span> Start</button>
	<a href="login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span> Login</a>
</div>
</div>
</div>
<!-- banner -->

<!-- Cards -->
<br>	
<div class="container">
	<div class="row">
	
		<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="https://media.hswstatic.com/eyJidWNrZXQiOiJjb250ZW50Lmhzd3N0YXRpYy5jb20iLCJrZXkiOiJnaWZcL2phdmEtY29kZS5qcGciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjgyOH0sInRvRm9ybWF0IjoiYXZpZiJ9fQ==" class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Java programming</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
		
				<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="https://cdn.activestate.com/wp-content/uploads/2021/12/python-coding-mistakes.jpg" class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Python programming</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
				
				<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="https://res.cloudinary.com/practicaldev/image/fetch/s--H0AdlIEN--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://thepracticaldev.s3.amazonaws.com/i/srnvrd7vfeeq5qpxnabq.png" class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Data structures and algorithms</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
		
	</div>
	
<br>

<div class="row">
	
		<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="..." class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Java programming</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
		
				<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="..." class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Java programming</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
				
				<div class="col-md-4">
			<div class="card" style="width: 18rem;">
  			<img src="..." class="card-img-top" alt="...">
  				<div class="card-body">
    			<h5 class="card-title">Java programming</h5>
    			<p class="card-text">Learn core java, with added questions for practice.</p>
    			<a href="#" class="btn btn-primary">Read more</a>
  				</div>
			</div>
		</div>
		
	</div>


</div>
<!-- Cards -->
<!-- Jquery CDN and JS Bootstrap CDN -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- linking js file -->
<script src="js/myjs.js" type="text/javascript"></script>

</body>
</html>