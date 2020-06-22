<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Palabra Aleatoria</title>
</head>
<body>
	<p>Haz generado una nueva palabra <%= session.getAttribute("generar") %> veces</p>
	<form action="PalabraRandom">
		<h2> <%= session.getAttribute("palabra") %> </h2>
		<input type="submit" value="Generar">
	</form>
	<p>La última vez que generaste una palabra fue en <%= session.getAttribute("date") %></p>
</body>
</html>