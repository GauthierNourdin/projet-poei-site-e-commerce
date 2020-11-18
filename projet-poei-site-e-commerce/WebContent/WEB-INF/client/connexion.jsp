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
<title>Connexion client</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
	<form method="post" action="${ pageContext.request.contextPath }/client/connexion">
		<div>
			<label for="identifiant">Identifiant de connexion</label> 
			<input type="text" id="identifiant" name="identifiant" required>
		</div>
		<div>
			<label for="motDePasse">Mot de passe</label> 
			<input type="password" id="motDePasse" name="motDePasse" required>
		</div>
		<div><c:out value="${erreurDeConnexion}"/></div>
		<input type="submit" value="Se connecter" />
	</form>
</body>
</html>