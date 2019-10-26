<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="com.sun.prism.Image"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtusa Carpool Booking</title>

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
Object obj=session.getAttribute("bookCars");
Car cars=(Car)obj;
%>

</head>
<body>

	<h1 class="titles" class="fadeIn first">CONFIRM RIDE</h1>

	<div class="wrapper fadeInDown">
		<div id="formContent">

<form action="ConfirmControlServlet" method="post" class="table">
	<table border="1" align="center">
	<tr><td>
	<label>Car Number</label></td><td><input type="text" readonly="readonly"  name="bCarNo" value=<%=cars.getRegNo() %> /></td></tr>
	<tr><td>
	<label>Car Name</label></td><td><input type="text" readonly="readonly"  id= "bCarName" value=<%=cars.getCarName() %> /></td></tr>
	<tr><td>
	<label>Source</label></td><td><input type="text" readonly="readonly"  id ="bCarSource" value=<%=cars.getSource() %> /></td></tr>
	<tr><td>	
	<label>Destination</label></td><td><input type="text" readonly="readonly"  id ="bCarDest" value=<%=cars.getDestination() %> /></td></tr>
	<tr><td>
	<label>Departure Time</label></td><td><input type="text" readonly="readonly" id="bCarTime" value=<%=cars.getDeptTime() %> /></td></tr>
	<tr><td>
	<label>Seats Selected</label></td><td><input type="text" readonly="readonly"  name="bSeatsAvailable" value=<%=session.getAttribute("seats")%> /></td></tr>
	<tr><td>
	<label>Fare to be paid</label></td><td><input type="text" readonly="readonly"  id="fare" value="40" /></td></tr>
	<tr align="center"> <td align="center" colspan="2">
	<input type="submit" value="Confirm" onclick="widows.print()" /></td></tr>
	</table>
	</form>

</div>
</div>

</body>
</html>
