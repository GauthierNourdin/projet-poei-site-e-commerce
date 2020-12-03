<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Panier"/>
<%@ include file="/html/head.jsp"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Panier</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
	<table class="table table-striped">
	   <thead>
	     <tr>
	       <th>Produit</th>
	       <th>Quantité</th>
	       <th>Prix Unitaire</th>
	       <th>Total</th>
	     </tr>
	   </thead>
	   <tbody>
	     <c:forEach items="${ lignesPanier }" var="lignepanier">
	     	<tr id="lignepanier${ lignepanier['id'] }">
	     	  <td>
	     	    <c:url var="pageproduit" value="/produit/produit?idproduit=${ lignepanier['idProduit'] }"></c:url>
	     	  	<a href="${ pageproduit }">
	     	  		<img src="<c:url value="${ lignepanier['urlImage'] }"/>" alt="${ lignepanier['designation'] }" width="96" height="96"/>
	     	  		<span><c:out value="${ lignepanier['designation'] }"/></span>
	     	  	</a>
	     	  </td>
	     	  <td>
	     	    <button onclick="enleverUnExemplaire(${ lignepanier['id'] })"><i class="fas fa-minus-square"></i></button>
	     	  	<form class="form-inline">
	     	  	<input type="number" id="quantitesouhaitee${ lignepanier['id'] }" name="quantitesouhaitee${ lignepanier['id'] }" value="${ lignepanier['quantiteSouhaitee'] }" oninput="changerNombreExemplaires(${ lignepanier['id'] })">
	     	    </form>
	     	    <button onclick="ajouterUnExemplaire(${ lignepanier['id'] })"><i class="fas fa-plus-square"></i></button>
	     	    <button onclick="retirerLignePanier(${ lignepanier['id'] })">Retirer du panier</button>
	     	    <p id="messagequantitesouhaitee${ lignepanier['id'] }"></p>
	     	  </td>
	     	  <td>
	     	  	<p id="prixunit${ lignepanier['id'] }">${ lignepanier['prixUnitaire'] } €</p>
	     	  	<p id="messageprixunit${ lignepanier['id'] }"></p>
	     	  </td>
	     	  <td><p id="prixproduit${ lignepanier['id'] }">${ lignepanier['prixUnitaire'] * lignepanier['quantiteSouhaitee'] } €</p></td>
	     	<tr>
	     </c:forEach>
	   </tbody>
	</table>
	<p id="messagesuppressionlignepanier"></p>
	<div style="text-align:right;">
		Nombre d'articles : <span id="nombrearticles"><c:out value="${ nombreArticles }"/></span>
		Total : <span id="prixtotal"><c:out value="${ prixTotal }"/></span>€
	</div>
	<div style="text-align:right;">
	    <form class="form-inline" action="${ pageContext.request.contextPath }/client/panier" method="post">
	    <input type="hidden" id="viderpanier" name="viderpanier" value="${ sessionScope.client['idUtilisateur'] }">
		<button type="submit" class="btn btn-primary mb-2">Vider le panier</button>
		</form>
		<form class="form-inline" action="${ pageContext.request.contextPath }/client/panier" method="post">
		<input type="hidden" id="validerpanier" name="validerpanier" value="${ sessionScope.client['idUtilisateur'] }">
		<button type="submit" class="btn btn-primary mb-2">Valider le panier</button>
		</form>
	</div>
</main>
<script src="${ pageContext.request.contextPath }/js/controlepanier.js"></script>
</body>
</html>