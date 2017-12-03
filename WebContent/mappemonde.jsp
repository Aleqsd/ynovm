<%@page import="ynovm.service.StationPOJO"%>
<%@page import="java.util.List"%>
<%@page import="ynovm.controleur.Manager"%>
<%@taglib uri="WEB-INF/tld/c.tld" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mappemonde - Gestion météo Ynov</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css"></link>

</head>
<body>
	<form name="fstation" action="supprimer" method="POST" id="fstation">
		<nav>
		<ul class="m">
			<li class="m"><a href="choice.jsp">Retour aux choix</a></li>
			<li class="m"><a href="ajouter.jsp">Ajouter une station</a></li>
			<li class="m"><a href="#" onClick="fstation.submit();">Supprimer la station sélectionnée</a></li>
			<li class="m"><a href="redemarrer" onClick="fstation.submit();">Redémarrer la station sélectionnée</a></li>
		</ul>
		</nav>
		
			<div>
		<img src="${pageContext.request.contextPath}/images/france_relief.gif"
			alt="map">
	</div>


	<c:forEach var="station" items="${modele}">
		<div class="station" style="position:absolute;top:${station.getY()}px;left:${station.getX()}px">
			<input type="radio" value="${station.getId()}" name="station">
		

			<ul>
			
				<li>${station.getNom()}</li>

				<li>Temperature : ${station.getTemperature()} celsius</li>

				<li>Hygrometrie : ${station.getHygrometrie()}</li>

				<li>Nébulosité : ${station.getNebulosite()}</li>

				<li>Vent : ${station.getAnemometre()}</li>

				<li>Pluviométrie : ${station.getPluviometrie()}</li>

				<li>Etat Pluviométrie : ${station.getEtat_Pluvio()}</li>

			</ul>

		</div>

	</c:forEach>
	</form>

</body>
</html>