<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Virtusa Carpool Login</title>

<!-- External Style Sheet Link -->
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/animation.css" type="text/css">

<!-- Bootstrap Link -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- JS Script Link -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Bootstrap Responsive Link -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="js/validate.js" type="text/javascript"></script>
	
<%
Object obj=request.getAttribute("message");
String message="";
if(obj!=null)
	message=(String)obj;
%>
</head>
<body>

	<h1 class="titles">CARPOOL LOGIN</h1>
	<div class="wrapper fadeInDown">
		<div id="formContent">

<form action="LoginContolServlet" method="post">
<div class="box">

<h3 style="color:red;"><%=message%></h3>

<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							 <input type="text" name="userid" id="userid" required="required"
				placeholder="enter user id" class="email" />
						</div>
					</div>

               <div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email" />
						</div>
					</div>
				
				<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							 <input type="submit" value="Sign in" class="btn" onclick="return regValidate(password,password1);">
						</div>
					</div>
				
				<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
				
							 <a href="register.jsp">Sign Up</a> 
						</div>
					</div>
				

</div>

</form>
</div>
</div>

</body>
</html>


