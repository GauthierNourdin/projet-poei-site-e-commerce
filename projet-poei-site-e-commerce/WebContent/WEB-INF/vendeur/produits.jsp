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
<h3>Ajouter un produit</h3>
<form method="post" action="${ pageContext.request.contextPath }/vendeur/produits">
	<div>
		<label for="designation">Nom</label> 
		<input type="text" id="designation" name="designation" value="${ designationsaisie }" required>
		<c:out value="${ designationerreur }"/>
	</div>
	<div>
		<label for="prixunitaire">Prix unitaire</label> 
		<input type="number" id="prixunitaire" name="prixunitaire" value="${ prixunitairesaisie }" step="0.01" required>
		<c:out value="${ prixunitaireerreur }"/>
	</div>
	<div>
		<label for="quantiteenstock">Quantité en stock</label> 
		<input type="number" id="quantiteenstock" name="quantiteenstock" value="${ quantiteenstocksaisie }" required>
		<c:out value="${ quantiteenstockerreur }"/>
	</div>
	<div>
		<label for="urlimage">Lien url de l'image</label> 
		<input type="text" id="urlimage" name="urlimage" value="${ urlimagesaisie }" required>
		<c:out value="${ urlimageerreur }"/>
	</div>
	<div>
		<label for="descriptionproduit">Description du produit</label> 
		<input type="text" id="descriptionproduit" name="descriptionproduit" value="${ descriptionproduitsaisie }">
	</div>
	<input type="submit" value="Ajouter un produit"/>
</form>
<hr>
<c:forEach items="${ produits }" var="produit">
	<c:url var="pagemodification" value="/vendeur/produit/modification?idproduit=${ produit['id'] }"></c:url>
	<c:url var="pagesuppression" value="/vendeur/produit/suppression?idproduit=${ produit['id'] }"></c:url>
	<div class="media">
	  <img src="${ pageContext.request.contextPath }/${ produit['urlImage'] }" alt="Image manquante" class="align-self-center mr-3" style="width:150px;">
	  <div class="media-body">
	    <h4>${ produit['designation'] }</h4>
	    <p>${ produit['prixUnitaire'] }€</p>
	    <p>${ produit['quantiteEnStock'] } en stock</p>
	    <p>${ produit['descriptionProduit'] }</p>
	    <a href="${ pagemodification }" class="btn btn-primary" role="button"><i class="fas fa-edit"></i></a>
	    <a href="${ pagesuppression }" class="btn btn-danger" role="button"><i class="fas fa-trash-alt"></i></a>
	  </div>
	</div>
</c:forEach>
</body>
</html>