<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

import="com.vcarpool.model.*, java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vacrpool</title>
</head>
<body>
<% 
Object obj= session.getAttribute("resultArray");
ArrayList<Car> list = (ArrayList<Car>) obj; 
%>
 <%if(list.size()>0) { %>
<table border="1">
<tr>
	<th colspan="4">car no</th>
	<th colspan="4">car name</th>
	<th colspan="4">car source</th>
	<th colspan="4">destination</th>
	<th colspan="4">time</th> 
	<th colspan="4">Number of seats</th> 
	<th colspan="4">Book</th>
</tr>
<%for(int i=0;i<list.size();i++) { %>
<tr>
<form action="BookServlet" method="post">
 <td colspan="4" ><input type="text" readonly="readonly" id="carno" name="carno" value=<%=list.get(i).getRegNo() %> /></td>
 <td colspan="4" ><input type="text" readonly="readonly" id="carname" name="carname" value=<%=list.get(i).getCarName() %> /></td>
<td colspan="4" ><input type="text" readonly="readonly" id="carsource" name="carsource" value=<%=list.get(i).getSource() %> /></td>
  <td colspan="4" ><input type="text" readonly="readonly" id="cardest" name="cardest" value=<%=list.get(i).getDestination() %> /></td> 
  <td colspan="4" ><input type="text" readonly="readonly" id="cartime" name="cartime" value=<%=list.get(i).getDeptTime() %> /></td>
  <td colspan="4" ><input type="text" readonly="readonly" id="carseats" name="carseats" value=<%=list.get(i).getSeatsAvailable() %> /></td>
 <td>  <input  type="submit" value="book" 
 >
</form>
</tr>
<%} %>
<%}else{ %>
<h1>No cars available for request <a href="index.jsp">click here to go home</a></h1>
<%} %>>
</table>
</body>
</html>
>