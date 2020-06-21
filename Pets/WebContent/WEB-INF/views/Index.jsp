<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pet Form</title>
</head>
<body>
	<form action="Perrow">
		<h1>Created a Dog</h1>
		<h3>Name:</h3>
			<input type="text" name="name">
		<h3>Breed:</h3>
			<input type="text" name="breed">
		<h3>Weight:</h3>
			<input type="text" name="weight">
		<input type="submit" value="Enviar">
	</form>
	
	<form action="Kitty">
		<h1>Created a Cat</h1>
		<h3>Name:</h3>
			<input type="text" name="name">
		<h3>Breed:</h3>
			<input type="text" name="breed">
		<h3>Weight:</h3>
			<input type="text" name="weight">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>