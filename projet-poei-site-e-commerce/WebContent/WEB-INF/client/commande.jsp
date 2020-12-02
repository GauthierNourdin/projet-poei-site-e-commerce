<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="détail commande"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Détail commande</h2>
<p>	Commande numéro : <c:out value="${ commande.id }"/>. Date de commande : <c:out value="${ commande.dateDeCommande }"/>. Nombre d'articles : <c:out value="${ nombreArticles }"/>. Prix total = <c:out value="${ prixTotal }"/> €</p> 
<table>
	<thead>
		<tr>
			<th>Produit</th>
			<th>Quantité commandée</th>
			<th>Prix unitaire</th>
			<th>Prix total</th>
		<tr>
	</thead>
	<tbody>
		<c:forEach items="${ lignesCommandeAffichage }" var="lignecommande">
			<tr>
				<td>
					<c:url var="pageproduit" value="/produit/produit?idproduit=${ lignecommande['idProduit'] }"></c:url>
     	  			<a href="${ pageproduit }">
     	  				<img src="<c:url value="${ lignecommande['urlImage'] }"/>" alt="${ lignecommande['designation'] }" width="96" height="96"/>
     	  				<span><c:out value="${ lignecommande['designation'] }"/></span>
     	  			</a>
				</td>
				<td>
					<p><c:out value="${ lignecommande['quantiteCommandee'] }"/></p>
				</td>
				<td>
					<p><c:out value="${ lignecommande['prixUnitaire'] }"/> €</p>
				</td>
				<td>
					<p><c:out value="${ lignecommande['prixUnitaire']*lignecommande['quantiteCommandee'] }"/> €</p>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:url var="pagecommande" value="/client/commandes"></c:url>
<a href="${ pagecommande }">Retour à la page des commandes passées</a>
</body>
</html>