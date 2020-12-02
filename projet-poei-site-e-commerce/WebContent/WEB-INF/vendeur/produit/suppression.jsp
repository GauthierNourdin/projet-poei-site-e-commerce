<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Suppression produit"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Attention la suppression de produit est définitive et fortement déconseillée. Pour confirmer vueillez rentrer vos identifiants.</h2>
<div class="media">
	<img src="<c:url value="${ produit['urlImage'] }"/>" alt="Image manquante" class="align-self-center mr-3" style="width:150px;">
	<div class="media-body">
	    <h4>${ produit['designation'] }</h4>
	    <p>${ produit['prixUnitaire'] }€</p>
	    <p>${ produit['quantiteEnStock'] } en stock</p>
	    <p>${ produit['descriptionProduit'] }</p>
	</div>
</div>
<form method="post" action="${ pageContext.request.contextPath }/vendeur/produit/suppression?idproduit=${ produit['id'] }">
	<div>
		<label for="identifiant">Identifiant de connexion</label> 
		<input type="text" id="identifiant" name="identifiant" required>
	</div>
	<div>
		<label for="motDePasse">Mot de passe</label> 
		<input type="password" id="motDePasse" name="motDePasse" required>
	</div>
	<div><c:out value="${erreurConnexion}"/></div>
	<input type="submit" value="Se connecter" />
</form>
<div><c:out value="${erreurSuppression}"/></div>
<c:url var="retourproduits" value="/vendeur/produits"></c:url>
<a href="${ retourproduits }">Retour à mes produits</a>
</body>
</html>