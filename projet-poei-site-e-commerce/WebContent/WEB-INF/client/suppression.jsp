<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Suppression compte"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Attention la suppression du compte est définitive et entraîne la suppression de vos commandes et de votre panier. Pour confirmer vueillez rentrer vos identifiants.</h2>
	<form method="post" action="${ pageContext.request.contextPath }/vendeur/suppression">
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
	<c:url var="retourhome" value="/home"></c:url>
	<a href="${ retourhome }">Retour à la page d'accueil</a>
</body>
</html>