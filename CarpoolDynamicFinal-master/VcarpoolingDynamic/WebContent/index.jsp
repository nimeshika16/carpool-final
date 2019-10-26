<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtusa Carpool Sign In</title>

<!-- External Style Sheet Link -->
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/animation.css" type="text/css">

<!-- Bootstrap Link -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- jQuery Script Link -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Bootstrap Responsive Link -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="js/validate.js" type="text/javascript"></script>

</head>
<body>

<h1 class="titles">CARPOOL LOGIN</h1>

	<div class="wrapper fadeInDown">
		<div id="formContent">
	<form method="post" action="FindCarServlet">
		<div class="box">x
			

					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn second" type="text" name="source" required="required" id="source" placeholder="enter source" class="email" /> 
						</div>
					</div>
			
			<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn third" id="destination" type="text" name="destination" required="required" placeholder="enter your destination" class="email" />
						</div>
					</div>
			

			<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn fourth" type="time" name="time" required="required" id="time"  class="email" placeholder="enter departure time"/>
						</div>
					</div>
			

			<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn fifth" type="text" name="seats" required="required" id="seats" placeholder="enter no of seats" class="email" />
						</div>
					</div>
			 
				
				<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
							<input class="fadeIn sixth" type="submit" value="Find Cars" class="btn">
						</div>
					</div>

		</div>
		<!-- End Box -->

	</form>
	</div>
</div>


</body>
</html>