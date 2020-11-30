var requete = ""; // variable globale

$(function() {
    var mdiv = document.getElementById("testJS");
	mdiv.innerHTML = "Bonjour le monde !";
});

function getXMLHttpRequest() {
	var xhr = null;
	if (window.XMLHttpRequest || window.ActiveXObject) {
		if (window.ActiveXObject) {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		else {
			xhr = new XMLHttpRequest();
		}
	}
	else {
		alert("Navigateur incompatible avec XMLHTTPRequest");
		return null;
	}
	return xhr;
}

function validerNom() {
	var nom = document.getElementById("nom");
	var url = "SearchPersonne?nom=" + escape(nom.value);
	requete = getXMLHttpRequest();
	requete.open("GET", url, true);
	requete.onreadystatechange = displayMessageNom;
	requete.send();
}

function validerPrenom() {
	var prenom = document.getElementById("prenom");
	var url = "SearchPersonne?prenom=" + escape(prenom.value);
	requete = getXMLHttpRequest();
	requete.open("GET", url, true);
	requete.onreadystatechange = displayMessagePrenom;
	requete.send();
}

function displayMessageNom() {
	var message = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		var messageTag = requete.responseXML.getElementsByTagName("message")[0];
		message = messageTag.childNodes[0].nodeValue;
		mdiv = document.getElementById("validationNom");
		mdiv.innerHTML = message;
	}
}

function displayMessagePrenom() {
	var message = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		var messageTag = requete.responseXML.getElementsByTagName("message")[0];
		message = messageTag.childNodes[0].nodeValue;
		mdiv = document.getElementById("validationPrenom");
		mdiv.innerHTML = message;
	}
}