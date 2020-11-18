<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/lib/BootstrapAndFontAwesome.html"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Page d'accueil</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Barre de recherche</h2>
<p>Prochainement</p>
<div class="card-deck">
	<c:forEach items="${ produits }" var="produit">
	<c:url var="pageproduit" value="/produit/produit?idproduit=${ produit['id'] }"></c:url>
	<div class="card" style="width:300px;">
		<a href="${ pageproduit }">
  			<img class="card-img-top" src="${ produit['urlImage'] }" alt="Image manquante">
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
</html>