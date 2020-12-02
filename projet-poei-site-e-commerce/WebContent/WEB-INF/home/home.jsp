<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Page d'accueil"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Barre de recherche</h2>
<form method="post" action="${ pageContext.request.contextPath }/home">
	<div>
		<label for="nom">Recherche de produit : </label> 
		<input type="text" id="nom" name="nom" value="${ nomSaisi }">
	</div>
	<input type="submit" value="Rechercher"/>
</form>
<hr>
<div class="card-columns"> <%-- pas satisfaisant, remplace par flex --%>
	<c:forEach items="${ produits }" var="produit">
	<c:url var="pageproduit" value="/produit/produit?idproduit=${ produit['id'] }"></c:url>
	<div class="card" style="width:400px">	
		<a href="${ pageproduit }">
     	<img class="card-img-top" src="<c:url value="${ produit['urlImage'] }"/>" alt="${ produit['designation'] }"/>
  		</a>
  		<div class="card-body text-center">
  			<h3 class="card-title">
  				<a href="${ pageproduit }">
    				<c:out value="${ produit['designation'] }"/>
    			</a>
    		</h3>
    		<p class="card-text"><c:out value="${ produit['prixUnitaire'] }"/>€</p>
  		</div>
	</div>
	</c:forEach>
</div>
</body>