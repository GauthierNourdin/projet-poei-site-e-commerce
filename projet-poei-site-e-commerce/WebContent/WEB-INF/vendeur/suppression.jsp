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
<title>Suppression vendeur</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Attention la suppression du compte est définitive et entraîne la suppression de vos produits. Pour confirmer vueillez rentrer vos identifiants.</h2>
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
	<c:url var="retourproduits" value="/vendeur/produits"></c:url>
	<a href="${ retourproduits }">Retour à mes produits</a>
</body>
</html>