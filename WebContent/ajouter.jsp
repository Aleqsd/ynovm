<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une station</title>
</head>
<body>
	<form name="fmeteo" action="validerajout" method="POST">
		<br> <input type="text" name="id" placeholder="id"><br>
		<br> <input type="text" name="nom" placeholder="nom"><br>
		<br> <input type="text" name="x" placeholder="x">
		<br> <input type="text" name="y" placeholder="y">
		<br> <input type="text" name="remarques" placeholder="remarques">
		<br> <input type="text" name="localisation" placeholder="localisation">
		<br> <input type="text" name="type" placeholder="type">
		<br> <input type="text" name="temperature" placeholder="temperature">
		<br> <input type="text" name="hygrometrie" placeholder="hygrometrie">
		<br> <input type="text" name="nebulosite" placeholder="nebulosite">
		<br> <input type="text" name="anemometrie" placeholder="anemometrie">
		<br> <input type="text" name="pluviometrie" placeholder="pluviometrie">
		<input type="submit" value="Ajouter">
		
		<p>${message }</p>
	</form>
</body>
</html>