<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" type="text/css">
<title>Gestion météo Ynov</title>
</head>
<body>
	<p>Entrez votre identifiant et votre mot de passe.</p>
	<form name="co" action="connexion" method="post">
		<p>
			<input type="id" name="id" />
			<input type="password" name="mdp" /> 
			<input type="submit" value="Valider" />
		</p>
		<div>${authentification}</div>
	</form>
</body>
</html>

