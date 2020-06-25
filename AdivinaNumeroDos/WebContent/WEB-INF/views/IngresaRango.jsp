<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
<title>Ingresa un rango</title>
</head>
<body>
	<h1>Bienvenido al juego: "Adivina el número"</h1>
	<h3>Ingresa un rango de números para adivinar</h3>
	
	<form action="GeneraRandom" method="post">
		<p>Numero Inicial</p>
		<input type="number" name="numero1">
		<p>Numero Final</p>
		<input type="number" name="numero2">
		
		<input type="submit" value="Enviar">
	</form>
	
	
	
</body>
</html>