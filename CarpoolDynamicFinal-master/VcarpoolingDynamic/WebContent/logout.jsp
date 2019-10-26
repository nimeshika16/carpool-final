<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>

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

<%session.invalidate();
response.sendRedirect("login.jsp");%>
</head>
<body>

</body>
</html>
