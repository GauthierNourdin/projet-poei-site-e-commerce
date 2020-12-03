<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Page de bienvenue</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<main>
	<h2>Bienvenue cher visiteur sur FictionMania !</h2>
	<c:url var="retourhome" value="/home"></c:url>
	<p><a href="${ retourhome }">Visiter la page d'accueil</a></p>
</main>
</body>
</html>