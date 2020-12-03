<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Liste commandes"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
	<h2>Commandes passées</h2>
	<c:forEach items="${ commandesAffichage }" var="commande">
	 	<table>
			<tr>
				<td>
					<p>Numéro de commande : <c:out value="${ commande.id }"/></p>
					<p>Date de commande : <c:out value="${ commande.dateDeCommande }"/></p>
					<p>Nombre d'articles : <c:out value="${ commande.nombreArticles }"/></p>
					<p>Prix total : ${ commande.prixTotal } €</p>
				</td>
				<td>
					<c:url var="commande" value="/client/commande?idcommande=${ commande.id }&prixtotal=${ commande.prixTotal }&nombrearticles=${ commande.nombreArticles }"></c:url>
					<a class="btn btn-primary" href="${ commande }" role="button">Accéder au détail</a>
				</td>
			</tr>
		</table>
	</c:forEach>
</main>
</body>
</html>