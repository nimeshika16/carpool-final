<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="js/validate.js" type="text/javascript"></script>
<title>ADD Car</title>
</head>
<body>

	<div class="login-card">
		
		<form action="CarServ" method="post">
		<div class="box">
		<h2>
		hello
		<%=session.getAttribute("userid")%>
		add your car
	</h2>
			<input type="text" name="regno"
				placeholder="Enter Car Registration No" class="email" > <input type="text"
				name="carname" placeholder="Enter Car Name" class="email" > <input
				type="text" name="seat" placeholder="Enter No of Seats" class="email" > <input
				type="text" name="source" placeholder="Enter Source" class="email"> <input
				type="text" name="destination" placeholder="Enter destination" class="email" >
				<input
				type="time" name="time" id="time" PLACEHOLDER="ENTER TIME" required / class="email"> <br>
			<input type="submit" name="login" 
				value="submit" class="btn">
				</div>
		</form>

	</div>

</body>
</html>