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
<title>Liste des produits</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Liste de produits à afficher</h2>

<c:forEach items="${ produits }" var="produit">
<c:out value="${ produit['id'] } ${ produit['designation'] } ${ produit['prixUnitaire'] } ${ produit['quantiteEnStock'] } ${ produit['urlImage'] } ${ produit['descriptionProduit'] }"/>
<br>
<!-- 	<div class="media">
	  <img src="..." class="mr-3" alt="...">
	  <div class="media-body">
	    <h5 class="mt-0">Media heading</h5>
	    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
	  </div>
	</div> -->
</c:forEach>

<div>Pour chaque produit il faut une image et un nom cliquable, un prix unitaire, un bouton pour modifier et un bouton pour supprimer</div>
<h2>Formulaire pour ajouter un produit</h2>
</body>
</html>