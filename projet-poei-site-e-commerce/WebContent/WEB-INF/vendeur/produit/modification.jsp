<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Modification produit"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
	<div class="media">
		<img src="<c:url value="${ produit['urlImage'] }"/>" alt="Image manquante" class="align-self-center mr-3" style="width:150px;">
		<div class="media-body">
		    <h4><c:out value="${ produit['designation'] }"/></h4>
		    <p><c:out value="${ produit['prixUnitaire'] }"/> €</p>
		    <p><c:out value="${ produit['quantiteEnStock'] }"/> en stock</p>
		    <p><c:out value="${ produit['descriptionProduit'] }"/></p>
		</div>
	</div>
	<form method="post" action="${ pageContext.request.contextPath }/vendeur/produit/modification?idproduit=${ produit['id'] }">
		<div>
			<label for="designation">Nom</label> 
			<input type="text" id="designation" name="designation" value="${ produit['designation'] }" required>
			<c:out value="${ designationerreur }"/>
		</div>
		<div>
			<label for="prixunitaire">Prix unitaire</label> 
			<input type="number" id="prixunitaire" name="prixunitaire" value="${ produit['prixUnitaire'] }" required>
			<c:out value="${ prixunitaireerreur }"/>
		</div>
		<div>
			<label for="quantiteenstock">Quantité en stock</label> 
			<input type="number" id="quantiteenstock" name="quantiteenstock" value="${ produit['quantiteEnStock'] }" required>
			<c:out value="${ quantiteenstockerreur }"/>
		</div>
		<div>
			<label for="urlimage">Lien url de l'image</label> 
			<input type="text" id="urlimage" name="urlimage" value="${ produit['urlImage'] }" required>
			<c:out value="${ urlimageerreur }"/>
		</div>
		<div>
			<label for="descriptionproduit">Description du produit</label> 
			<input type="text" id="descriptionproduit" name="descriptionproduit" value="${ produit['descriptionProduit'] }">
		</div>
		<input type="submit" value="Modifier le produit"/>
	</form>
	<c:url var="retourproduits" value="/vendeur/produits"></c:url>
	<a href="${ retourproduits }">Retour à mes produits</a>
</main>
</body>
</html>