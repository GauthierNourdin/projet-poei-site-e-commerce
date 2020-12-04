var requete = ""; // variable globale

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

function ajouterUnExemplaire(idLignePanier) {
	let inputId = "quantitesouhaitee" + escape(idLignePanier);
	let quantiteSouhaitee = parseInt(document.getElementById(inputId).value);
	quantiteSouhaitee = quantiteSouhaitee + 1;
	
	let url = "panier/changerquantite?idlignepanier=" + escape(idLignePanier) + "&quantitesouhaitee=" + quantiteSouhaitee;
	
	let requete = getXMLHttpRequest();
	requete.onreadystatechange = afficherNombreExemplaires(idLignePanier);
	requete.open("GET", url, true);	
	requete.send();
}

function enleverUnExemplaire(idLignePanier) {
	let inputId = "quantitesouhaitee" + escape(idLignePanier);
	let quantiteSouhaitee = parseInt(document.getElementById(inputId).value);
	if (quantiteSouhaitee > 2) {
		quantiteSouhaitee = quantiteSouhaitee - 1;
		
		let url = "panier/changerquantite?idlignepanier=" + escape(idLignePanier) + "&quantitesouhaitee=" + quantiteSouhaitee;
	
		let requete = getXMLHttpRequest();
		requete.onreadystatechange = afficherNombreExemplaires(idLignePanier);
		requete.open("GET", url, true);
		requete.send();
	}
}

function retirerLignePanier(idLignePanier) {
	let url = "panier/retirerligne?idlignepanier=" + escape(idLignePanier);
	
	let requete = getXMLHttpRequest();
	requete.onreadystatechange = effacerLignePanier(idLignePanier);
	requete.open("GET", url, true);	
	requete.send();
}

function changerNombreExemplaires(idLignePanier) {
	let inputId = "quantitesouhaitee" + escape(idLignePanier);
	let quantiteSouhaitee = parseInt(document.getElementById(inputId).value);
	
	let url = "panier/changerquantite?idlignepanier=" + escape(idLignePanier) + "&quantitesouhaitee=" + quantiteSouhaitee;
	
	let requete = getXMLHttpRequest();
	requete.onreadystatechange = afficherNombreExemplaires(idLignePanier);
	requete.open("GET", url, true);	
	requete.send();
}

function afficherNombreExemplaires(idLignePanier) {
	let nombreExemplaireValide = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		let messageTag = requete.responseXML.getElementsByTagName("nombreexemplairesvalide")[0];
		nombreExemplaireValide = messageTag.childNodes[0].nodeValue;
		
		if (nombreExemplaireValide == "-1") {
			let messageId = "messagequantitesouhaitee" + escape(idLignePanier);
			let containerMessage = document.getElementById(messageId);
			containerMessage.innerHTML = "Changement de quantité souhaitée validée !";
		} else {
			let inputId = "quantitesouhaitee" + escape(idLignePanier);
			document.getElementById(inputId).value = nombreExemplaireValide;
		
			let messageId = "messagequantitesouhaitee" + escape(idLignePanier);
			let containerMessage = document.getElementById(messageId);
			containerMessage.innerHTML = "Echec du changement de quantité souhaitée validée !";
		}
	}
}

function effacerLignePanier(idLignePanier) {
	let confirmation = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		let messageTag = requete.responseXML.getElementsByTagName("confirmation")[0];
		confirmation = messageTag.childNodes[0].nodeValue;
		
		let mdiv = document.getElementById("messagesuppressionlignepanier");
		
		if (confirmation == "true") {
			let ligneTableauId = "lignepanier" + escape(idLignePanier);
			let lignePanier = document.getElementById(ligneTableauId);
			lignePanier.remove();
			mdiv.innerHTML = "La ligne de panier a bien été supprimée !";
		} else {
			mdiv.innerHTML = "Erreur : la ligne de panier n'a pas pu être supprimée !";
		}
		
	}
}