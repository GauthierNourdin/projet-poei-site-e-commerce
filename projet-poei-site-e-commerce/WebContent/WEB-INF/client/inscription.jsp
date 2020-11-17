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
<title>Inscription Client</title>
</head>
<body>
<%@ include file="/html/choixheader.html"%>
<form method="post" action="client/inscription">
  <div class="form-group">
    <label for="inputPrenom">Prenom</label>
    <input type="text" class="form-control" id="inputPrenom">
  </div>
  <div class="form-group">
    <label for="inputnom">Nom</label>
    <input type="text" class="form-control" id="inputnom">
  </div>
  <div class="form-group">
    <label for="inputEmail">Email</label>
    <input type="email" class="form-control" id="inputEmail">
  </div>
  <div class="form-group">
    <label for="inputIndentifiant">Identifiant</label>
    <input type="text" class="form-control" id="inputIndentifiant">
  </div>
   <div class="form-group">
    <label for="inputTelephone">Numero de telephone</label>
    <input type="text" class="form-control" id="inputTelephone">
  </div>
  <div class="form-group">
    <label for="inputPassword">Password</label>
    <input type="password" class="form-control" id="inputPassword">
  </div>
  <h4>Adresse</h4>
  <div class="form-group">
    <label for="inputNumeroRue">Numero de rue</label>
    <input type="number" class="form-control" id="inputNumeroRue">
  </div>
  <div class="form-group">
    <label for="inputNomRue">Nom de rue</label>
    <input type="text" class="form-control" id="inputNomRue">
  </div>
  <div class="form-group">
    <label for="inputComplementAdresse">Complement d'adresse</label>
    <input type="text" class="form-control" id="inputComplementAdresse">
  </div>
  <div class="form-group">
    <label for="inputVille">Ville</label>
    <input type="text" class="form-control" id="inputVille">
  </div>
  <div class="form-group">
    <label for="inputCodePostal">Code postal</label>
    <input type="number" class="form-control" id="inputCodePostal">
  </div>
  <div class="form-group">
    <label for="inputPays">Pays</label>
    <input type="text" class="form-control" id="inputPays">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>