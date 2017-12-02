<%@page import="ynovm.service.StationPOJO"%>
<%@page import="java.util.List"%>
<%@page import="ynovm.controleur.Manager"%>
<%@taglib uri="WEB-INF/tld/c.tld" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib  prefix="j"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mappemonde - Gestion météo Ynov</title>
<link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" type="text/css">
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
	<div><img src="${pageContext.request.contextPath}/images/france_relief.gif" alt="map"></div>
		<c:forEach var="station" items="${modele}">
			<td><input type="radio" value="${station.getId()}"></td>
			<td>${station.getId()}</td>
			<td>${station.getNom()}</td>
			<td>${station.getX()}</td>
			<td>${station.getY()}</td>
			<td>${station.getLocalisation()}</td>
			<td>${station.getTemperature()}</td>
			<td>${station.getHygrometrie()}</td>
			<td>${station.getNebulosite()}</td>
			<td>${station.getAnemometrie()}</td>
			<td>${station.getPluviometrie()}</td>
			<td>${station.getRemarques()}</td>
			<td>${station.getType()}</td>
			<td>${station.getEtat()}</td>
		</c:forEach>
</body>
</html>