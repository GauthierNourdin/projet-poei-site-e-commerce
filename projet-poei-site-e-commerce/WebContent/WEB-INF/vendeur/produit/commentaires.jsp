<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Commentaires produit"/>
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
	<c:url var="retourproduits" value="/vendeur/produits"></c:url>
	<a href="${ retourproduits }">Retour à mes produits</a>
</main>
</body>
</html>