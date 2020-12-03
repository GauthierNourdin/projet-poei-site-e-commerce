<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Deconnexion"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
	<p><c:out value="Merci beaucoup ${ prenom } ${ nom } d'utiliser notre site ! A bientot !"/></p>
	<c:url var="retourhome" value="/home"></c:url>
	<p><a href="${ retourhome }">Retour à la page d'accueil</a></p>
</main>
</body>
</html>