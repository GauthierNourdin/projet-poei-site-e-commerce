<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<c:set var="pagetitle" value="Inscription vendeur"/>
<%@ include file="/html/head.jsp"%>
<body>
<%@ include file="/html/choixheader.html"%>
<form method="post" action="${ pageContext.request.contextPath }/client/inscription">
  <div class="form-group">
    <label for="inputprenom">Prenom</label>
    <input type="text" class="form-control" id="inputprenom" name="inputprenom" value="${ prenomsaisie }" required>
    <c:out value="${ prenomerreur }" />
  </div>
  <div class="form-group">
    <label for="inputnom">Nom</label>
    <input type="text" class="form-control" id="inputnom" name="inputnom" value="${ nomsaisie }" required>
    <c:out value="${ nomerreur }" />
  </div>
  <div class="form-group">
    <label for="inputemail">Email</label>
    <input type="email" class="form-control" id="inputemail" name="inputemail" value="${ emailsaisie }" required>
    <c:out value="${ emailerreur }" />
  </div>
  <div class="form-group">
    <label for="inputidentifiant">Identifiant</label>
    <input type="text" class="form-control" id="inputidentifiant" name="inputidentifiant" value="${ identifiantsaisie }" required>
    <c:out value="${ identifianterreur }" />
  </div>
   <div class="form-group">
    <label for="inputtelephone">Numero de telephone</label>
    <input type="text" class="form-control" id="inputtelephone" name="inputtelephone" value="${ telephonesaisie }" required>
    <c:out value="${ telephoneerreur }" />
  </div>
  <div class="form-group">
    <label for="inputpassword">Password</label>
    <input type="password" class="form-control" id="inputpassword" name="inputpassword" value="${ passwordsaisie }" required>
    <c:out value="${ passworderreur }" />
  </div>
  <h4>Adresse</h4>
  <div class="form-group">
    <label for="inputnumerorue">Numero de rue</label>
    <input type="text" class="form-control" id="inputnumerorue" name="inputnumerorue" value="${ numeroruesaisie }" required>
    <c:out value="${ numerorueerreur }" />
  </div>
  <div class="form-group">
    <label for="inputnomrue">Nom de rue</label>
    <input type="text" class="form-control" id="inputnomrue" name="inputnomrue" value="${ nomruesaisie }" required>
    <c:out value="${ nomrueerreur }" />
  </div>
  <div class="form-group">
    <label for="inputcomplementadresse">Complement d'adresse</label>
    <input type="text" class="form-control" id="inputcomplementadresse" name="inputcomplementadresse" value="${ complementadressesaisie }">
    <c:out value="${ complementadresseerreur }" />
  </div>
  <div class="form-group">
    <label for="inputville">Ville</label>
    <input type="text" class="form-control" id="inputville" name="inputville" value="${ villesaisie }" required>
    <c:out value="${ villeerreur }" />
  </div>
  <div class="form-group">
    <label for="inputcodepostal">Code postal</label>
    <input type="text" class="form-control" id="inputcodepostal" name="inputcodepostal" value="${ codepostalsaisie }" required>
    <c:out value="${ codepostalerreur }" />
  </div>
  <div class="form-group">
    <label for="inputpays">Pays</label>
    <input type="text" class="form-control" id="inputpays" name="inputpays" value="${ payssaisie }" required>
    <c:out value="${ payserreur }" />
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<p><c:out value="${ erreurinscription }"/></p>
</body>
</html>