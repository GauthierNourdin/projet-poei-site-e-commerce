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
<title>Produit</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
<h2><c:out value="${ produit.designation }"/></h2>
<table class="table table-bordered">
      <tr>
		<td>
 			<img alt="Image manquante" src="${ produit.urlImage }" style="width:30%">
<!-- 			<img alt="Image manquante" src="images/mario-figurine.jpg" style="width:30%> -->
		</td>
        <td>
        	<h4><c:out value="${ produit.prixUnitaire }"/>€</h4>
        	<c:choose>
        	<c:when test="${ produit.quantiteEnStock > 0}">
        		<p>Il reste ${ produit.quantiteEnStock } exemplaires en stock</p>
        		<form class="form-inline" action="/projet-poei-site-e-commerce/produit/produit?idProduit=${ produit.id }" method="post">
				  <label for="quantite" class="mr-sm-2">Quantitee souhaitee :</label>
				  <input type="number" class="form-control mb-2 mr-sm-2" width="50px" id="quantite">
 				 <button type="submit" class="btn btn-primary mb-2">Ajouter au panier</button>
				</form>
        	</c:when>
        	<c:otherwise>
        		<p>Produit epuise. Desole.
        	</c:otherwise>
        	</c:choose>
        </td>
      </tr>
</table>
<p><c:out value="${ produit.descriptionProduit }"/></p>
</main>
</body>
</html>