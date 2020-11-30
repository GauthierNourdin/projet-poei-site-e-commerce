<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="${ produit.designation }"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
<h2><c:out value="${ produit.designation }"/></h2>
<table class="table table-bordered">
      <tr>
		<td>
  			<img src="<c:url value="${ produit['urlImage'] }"/>" alt="${ produit['designation'] }" style="width:30%">
		</td>
        <td>
        	<h4><c:out value="${ produit.prixUnitaire }"/>€</h4>
        	<c:choose>
        	<c:when test="${ produit.quantiteEnStock > 0}">
        		<p>Il reste ${ produit.quantiteEnStock } exemplaires en stock</p>
        		<c:if test="${ sessionScope.client != null}">
        		
        			<c:choose>
						<c:when test="${ lignepanier != null }">
		        			<label for="quantite" class="mr-sm-2">Quantité souhaitée :</label>
		        			<button onclick="enleverUnExemplaire()"><i class="fas fa-minus-square"></i></button>
		        			<form id="modifierlignepanier" class="form-inline" action="${ pageContext.request.contextPath }/produit/produit" method="post">
						  		<input type="hidden" id="idProduit" name="idProduit" value="${ produit.id }">
						  		<input type="hidden" id="idLignePanier" name="idLignePanier" value="${ lignepanier.id }">
		        				<input type="hidden" id="methode" name="methode" value="modifier">
						  		<input type="number" class="form-control mb-2 mr-sm-2" width="50px" name="quantite" id="quantite" value="${ lignepanier.quantiteSouhaitee }" oninput=changerNombreExemplaires()>
							</form>
							<button onclick="ajouterUnExemplaire()"><i class="fas fa-plus-square"></i></button>
							<button type="submit" class="btn btn-primary mb-2" form="modifierlignepanier">Modifier la quantité</button>
							<form id="supprimerlignepanier" class="form-inline" action="${ pageContext.request.contextPath }/produit/produit" method="post">
								<input type="hidden" id="idLignePanier" name="idLignePanier" value="${ lignepanier.id }">
								<input type="hidden" id="methode2" name="methode2" value="retirer">
								<button type="submit" class="btn btn-primary mb-2">Retirer du panier</button>
							</form>
						</c:when>
						<c:otherwise>
							<label for="quantite" class="mr-sm-2">Quantité souhaitée :</label>
		        			<button onclick="enleverUnExemplaire()"><i class="fas fa-minus-square"></i></button>
		        			<form id="ajouterproduit" class="form-inline" action="${ pageContext.request.contextPath }/produit/produit" method="post">
		        				<input type="hidden" id="idProduit" name="idProduit" value="${ produit.id }">
		        				<input type="hidden" id="methode" name="methode" value="ajouter">
						  		<input type="number" class="form-control mb-2 mr-sm-2" width="50px" name="quantite" id="quantite" oninput=changerNombreExemplaires()>
							</form>
							<button onclick="ajouterUnExemplaire()"><i class="fas fa-plus-square"></i></button>
							<button type="submit" class="btn btn-primary mb-2" form="ajouterproduit">Ajouter au panier</button>
						</c:otherwise>
					</c:choose>
					
				</c:if>
        	</c:when>
        	<c:otherwise>
        		<p>Produit épuisé. Désolé.
        	</c:otherwise>
        	</c:choose>
        </td>
      </tr>
</table>
<p><c:out value="${ produit.descriptionProduit }"/></p>
</main>
<script src="<c:url value="/js/controleproduit.js"/>"></script>
</body>
</html>