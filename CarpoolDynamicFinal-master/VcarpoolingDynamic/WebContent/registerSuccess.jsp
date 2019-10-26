<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtusa Carpool Registration Success</title>

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

</head>
<body>

	<h1 class="titles" class="fadeIn first">CARPOOL REGISTER</h1>

	<div class="wrapper fadeInDown">
		<div id="formContent">

<form method="post" action="LoginContolServlet"onsubmit="store()">
		<div class="box">


			<h2 style="color:green">Registration Successful, your id is <%=session.getAttribute("userid") %> now Login</h2>

			<!-- user name text box -->
					<div class="row">
						<input class="fadeIn second" type="text" name="userid" required="required" id="userid" placeholder="enter user ID" class="email" /> 
						</div>
					</div>

			<!-- password text box -->
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn third" id="password"
				type="password" name="password" required="required"	placeholder="enter your password" class="email" /> 
						</div>
					</div>
			
				
			<!-- login button -->
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn fourth"
				type="submit" value="Sign in" class="btn">
	
					</div>
				 
<!-- already signed in -->
				  <div id="formFooter" class="fadeIn fifth">
     <a href="register.jsp">Sign Up</a>
    </div>

		</div>
		<!-- End Box -->

	</form>
</div>
</div>

</body>
</html>


