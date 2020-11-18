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
<title>Deconnexion client</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<p><c:out value="Merci beaucoup ${ prenom } ${ nom } d'utiliser notre site ! A bientot !"/></p>
<c:url var="retourhome" value="/home"></c:url>
<p><a href="${ retourhome }">Retour à la page d'accueil</a></p>
</body>
</html>