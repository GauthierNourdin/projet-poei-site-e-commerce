<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Connexion vendeur"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<form method="post" action="${ pageContext.request.contextPath }/vendeur/connexion">
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
</body>
</html>