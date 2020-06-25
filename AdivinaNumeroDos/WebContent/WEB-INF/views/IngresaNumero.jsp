<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Adivina el número</title>
</head>
<body>
	<h1> <%= session.getAttribute("Título") %> desde <%= session.getAttribute("numero1") %> hasta <%= session.getAttribute("numero2") %></h1>
	
	<form action="ComparaNumero" method="post">
		<p>Ingresa un número para adivinar</p>
		<input type="number" name="numeroDado">
		<button> <%= session.getAttribute("button") %> </button>
	</form>
	
	<h2> <%= session.getAttribute("Ayuda") %> </h2>
	<h2> Tienes <%= session.getAttribute("click") %> intentos <%= session.getAttribute("clicks") %> </h2>
</body>
</html>