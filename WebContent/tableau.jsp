<%@page import="ynovm.service.StationPOJO"%>
<%@page import="java.util.List"%>
<%@page import="ynovm.controleur.Manager"%>
<%@taglib uri="WEB-INF/tld/c.tld" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tableau - Gestion météo Ynov</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
</head>
<body>
	<form name="fstation" action="main" method="POST">
		<nav>
			<ul class="m">
				<li class="m"><a href="choice.jsp">Retour aux choix</a></li>
				<li class="m"><a href="ajouter.jsp">Ajouter une station</a></li>
				<li class="m"><a href="supprimer">Supprimer la station sélectionnée</a></li>
				<li class="m"><a href="redemarrer">Redémarrer la station sélectionnée</a></li>
			</ul>
		</nav>
	</form>
	
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th></th>
			<th>ID</th>
			<th>Nom</th>
			<th>Longitude</th>
			<th>Latitude</th>
			<th>Localisation</th>
			<th>Temperature</th>
			<th>Hygrometrie</th>
			<th>Nébulosité</th>
			<th>Anémométrie</th>
			<th>Pluviométrie</th>
			<th>Remarques</th>
			<th>Type</th>
			<th>État</th>
		<tr>
			<c:forEach var="station" items="${modele}">
			<tr>
				<td><input type="radio" value="${station.getId()}"></td>
				<td>${station.getId()}</td>
				<td>${station.getNom()}</td>
				<td>${station.getX()}</td>
				<td>${station.getY()}</td>
				<td>${station.getLocalisation()}</td>
				<td>${station.getTemperature()}</td>
				<td>${station.getHygrometrie()}</td>
				<td>${station.getNebulosite()}</td>
				<td>${station.getAnemometre()}</td>
				<td>${station.getPluviometrie()}</td>
				<td>${station.getRemarques()}</td>
				<td>${station.getType()}</td>
				<td>${station.getEtat()}</td>
			</tr>
			</c:forEach>
		
	</table>
</body>
</html>