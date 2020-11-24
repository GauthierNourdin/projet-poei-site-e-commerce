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
<title>Panier</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
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
     	  <td><img src="${ lignepanier['urlImage'] }" alt="Image manquante" width="64" height="64"></td>
     	  <td>
     	    <button onclick="ajouterUnExemplaire(${ lignepanier['id'] })"><i class="fas fa-minus-square"></i></button>
     	  	<form class="form-inline">
     	  	<input type="number" id="quantitesouhaitee${ lignepanier['id'] }" name="quantitesouhaitee${ lignepanier['id'] }" value="${ lignepanier['quantiteeSouhaitee'] } oninput=changerNombreExemplaires(${ lignepanier['id'] })">
     	    </form>
     	    <button onclick="enleverUnExemplaire(${ lignepanier['id'] })"><i class="fas fa-plus-square"></i></button>
     	    <button onclick="retirerLignePanier(${ lignepanier['id'] })">Retirer du panier</button>
     	  </td>
     	  <td><span id="prixunit${ lignepanier['id'] }">${ lignepanier['prixUnit'] }</span>€</td>
     	  <td><span id="prixproduit${ lignepanier['id'] }">${ lignepanier['prixProduit'] }</span>€</td>
     	<tr>
     </c:forEach>
   </tbody>
</table>
<div style="text-align:right;">
	Nombre d'articles : <span id="nombrearticles"></span>
	Total : <span id="totalpanier"></span>€
</div>
<div style="text-align:right;">
    <form class="form-inline" action="${ pageContext.request.contextPath }/client/panier" method="post">
    <input type="hidden" id="viderpanier" name="viderpanier" value="${ sessionScope.client['idClient'] }">
	<button type="submit" class="btn btn-primary mb-2">Vider le panier</button>
	</form>
	<form class="form-inline" action="${ pageContext.request.contextPath }/client/panier" method="post">
	<input type="hidden" id="viderpanier" name="viderpanier" value="${ sessionScope.client['idClient'] }">
	<button type="submit" class="btn btn-primary mb-2">Valider le panier</button>
	</form>
</div>
</body>
<%@ include file="/js/controlepanier.js"%>
</html>