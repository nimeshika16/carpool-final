<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Virtusa Carpool Register</title>

<!-- External Style Sheet Link -->
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/animation.css" type="text/css">

<!-- Bootstrap Link -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- JS Script Link -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/validate.js" type="text/javascript"></script>

<!-- Bootstrap Responsive Link -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<%
String message="";
Object obj=request.getAttribute("regMessage");
if(obj!=null)
 message=(String)request.getAttribute("regMessage");

%>

</head>
<body>


	<h1 class="titles">CARPOOL REGISTER</h1>

	<div class="wrapper fadeInDown">
		<div id="formContent">

<form method="post" action="RegistrationControlServlet" >

		<div class="box">

			<h5 style="color:red;"><%=message %></h5>

			<!-- user name text box -->
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn second" type="text" name="username" id="username" required="required" placeholder="enter user name" class="email"  pattern="[A-Za-z]{6,}" title="username should contain altleast 6 characters"/>
						</div>
					</div>
	
			
			<!--  email text box -->
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn third" type="email" name="email" id="email" required="required"
				placeholder="enter email" class="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please follow the format: characters followed by an @ sign, followed by more characters, and then a '.'"/>
						</div>
					</div>
			
			<!-- password text box -->
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn fourth" type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/> 
						</div>
					</div>
			
				
			<!-- confirm password text box -->	 
			<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn fifth" type="password" name="password1" id="password1" required="required" placeholder="re-enter your password"
				 class="email"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/>
						</div>
					</div>

				   <p id="error" style="color:red"></p>
				 
				 <!-- rider and provider radio buttons -->	 
			<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn sixth" type="radio" name="type" value="rider" checked="checked">Rider
						</div>
					</div>
				<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn sixth" type="radio" name="type" value="provider" > Provider
						</div>
					</div>
				
				<!-- login button -->
					<div class="row">
						<div class ="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn seventh" type="submit" value="Sign up" class="btn" onclick="return regValidate(password,password1);">

						</div>
					</div>

					  <div id="formFooter">
      <a href="index.html" class="fadeIn seventh">Already Registered? Log In! </a>
    </div>
				
</div>
</form>
</body>
</html>