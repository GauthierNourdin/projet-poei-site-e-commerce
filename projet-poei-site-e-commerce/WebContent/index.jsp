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
<title>Page d'accueil</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<h2>Barre de recherche</h2>
<h2>Liste Produits</h2> 
<c:forEach items="${ produits }" var="produit">
<c:out value="${ produit['id'] } ${ produit['designation'] } ${ produit['prixUnitaire'] } ${ produit['quantiteEnStock'] } ${ produit['urlImage'] } ${ produit['descriptionProduit'] }"/>
<br>
</c:forEach>
<div>Pour chaque produit il faut une image et un nom cliquable et un prix unitaire</div>
</body>
</html>