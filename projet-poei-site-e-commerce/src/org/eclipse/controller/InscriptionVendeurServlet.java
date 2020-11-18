package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Adresse;
import org.eclipse.model.Vendeur;
import org.eclipse.service.AdresseService;
import org.eclipse.service.VendeurService;

@WebServlet("/vendeur/inscription")
public class InscriptionVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("inputprenom");
		String nom = request.getParameter("inputnom");
		String adresseMail = request.getParameter("inputemail");
		String identifiantConnexion = request.getParameter("inputidentifiant");
		String numeroTelephone = request.getParameter("inputtelephone");
		String motDePasse = request.getParameter("inputpassword");
		String numeroDansRue = request.getParameter("inputnumerorue");
		String rue = request.getParameter("inputnomrue");
		String complementAdresse = request.getParameter("inputcomplementadresse");
		String ville = request.getParameter("inputville");
		String codePostal = request.getParameter("inputcodepostal");
		String pays = request.getParameter("inputpays");
		
		boolean testValidite = true;
		if(!testPrenom(prenom)) {
			request.setAttribute("prenomerreur", "prenom incorrect");
			testValidite = false;
		}
		if(!testNom(nom)) {
			request.setAttribute("nomerreur", "nom incorrect");
			testValidite = false;
		}
		if(!testAdresseMail(adresseMail)) {
			request.setAttribute("emailerreur", "adresse mail incorrecte");
			testValidite = false;
		}
		if(!testIdentifiantConnexion(identifiantConnexion)) {
			request.setAttribute("identifianterreur", "identifiant incorrect");
			testValidite = false;
		}
		if(!testNumeroTelephone(numeroTelephone)) {
			request.setAttribute("telephoneerreur", "numero de telephone incorrect");
			testValidite = false;
		}
		if(!testMotDePasse(motDePasse)) {
			request.setAttribute("passworderreur", "mot de passe incorrect");
			testValidite = false;
		}
		if(!testNumeroDansRue(numeroDansRue)) {
			request.setAttribute("numerorueerreur", "numero de rue incorrect");
			testValidite = false;
		}
		if(!testRue(rue)) {
			request.setAttribute("nomrueerreur", "nom de rue incorrect");
			testValidite = false;
		}
		if(!testVille(ville)) {
			request.setAttribute("villeerreur", "nom de ville incorrect");
			testValidite = false;
		}
		if(!testCodePostal(codePostal)) {
			request.setAttribute("codepostalerreur", "code postal incorrect");
			testValidite = false;
		}
		if(!testPays(pays)) {
			request.setAttribute("payserreur", "nom de pays incorrect");
			testValidite = false;
		}
		if(complementAdresse == null)
			complementAdresse = "";
		if(testValidite) {
			Adresse adresse = new Adresse(numeroDansRue, rue, ville, codePostal, pays, complementAdresse, 0);
			Vendeur vendeur = new Vendeur(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, new ArrayList<Integer>(Arrays.asList(adresse.getId())));
			adresse.setIdUtilisateur(vendeur.getId());
			try {
				AdresseService.save(adresse);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("prenomsaisie", prenom);
				request.setAttribute("nomsaisie", nom);
				request.setAttribute("emailsaisie", adresseMail);
				request.setAttribute("identifiantsaisie", identifiantConnexion);
				request.setAttribute("telephonesaisie", numeroTelephone);
				request.setAttribute("passwordsaisie", motDePasse);
				request.setAttribute("numeroruesaisie", numeroDansRue);
				request.setAttribute("nomruesaisie", rue);
				request.setAttribute("complementadressesaisie", complementAdresse);
				request.setAttribute("villesaisie", ville);
				request.setAttribute("codepostalsaisie", codePostal);
				request.setAttribute("payssaisie", pays);
				request.setAttribute("erreurinscription", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/inscription.jsp").forward(request, response);
			}
			try {
				VendeurService.save(vendeur);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("prenomsaisie", prenom);
				request.setAttribute("nomsaisie", nom);
				request.setAttribute("emailsaisie", adresseMail);
				request.setAttribute("identifiantsaisie", identifiantConnexion);
				request.setAttribute("telephonesaisie", numeroTelephone);
				request.setAttribute("passwordsaisie", motDePasse);
				request.setAttribute("numeroruesaisie", numeroDansRue);
				request.setAttribute("nomruesaisie", rue);
				request.setAttribute("complementadressesaisie", complementAdresse);
				request.setAttribute("villesaisie", ville);
				request.setAttribute("codepostalsaisie", codePostal);
				request.setAttribute("payssaisie", pays);
				request.setAttribute("erreurinscription", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/inscription.jsp").forward(request, response);
			}
			HttpSession session = request.getSession();
			session.setAttribute("vendeur", vendeur);
			response.sendRedirect("/produits");
		} else {
			request.setAttribute("prenomsaisie", prenom);
			request.setAttribute("nomsaisie", nom);
			request.setAttribute("emailsaisie", adresseMail);
			request.setAttribute("identifiantsaisie", identifiantConnexion);
			request.setAttribute("telephonesaisie", numeroTelephone);
			request.setAttribute("passwordsaisie", motDePasse);
			request.setAttribute("numeroruesaisie", numeroDansRue);
			request.setAttribute("nomruesaisie", rue);
			request.setAttribute("complementadressesaisie", complementAdresse);
			request.setAttribute("villesaisie", ville);
			request.setAttribute("codepostalsaisie", codePostal);
			request.setAttribute("payssaisie", pays);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/inscription.jsp").forward(request, response);
		}
		
	}

	protected boolean testPrenom(String prenom) {
		if (prenom != null && prenom.length() > 3)
			return true;
		return false;
	}
	protected boolean testNom(String nom) {
		if (nom != null && nom.length() > 3)
			return true;
		return false;
	}
	protected boolean testAdresseMail(String adresseMail) {
		if (adresseMail != null && adresseMail.length() > 7)
			return true;
		return false;
	}
	protected boolean testIdentifiantConnexion(String identifiantConnexion) {
		if (identifiantConnexion != null && identifiantConnexion.length() > 3)
			return true;
		return false;
	}
	protected boolean testNumeroTelephone(String numeroTelephone) {
		if (numeroTelephone != null && numeroTelephone.length() > 7)
			return true;
		return false;
	}
	protected boolean testMotDePasse(String motDePasse) {
		if (motDePasse != null && motDePasse.length() > 3)
			return true;
		return false;
	}
	protected boolean testNumeroDansRue(String numeroDansRue) {
		if (numeroDansRue != null)
			return true;
		return false;
	}
	protected boolean testRue(String rue) {
		if (rue != null && rue.length() > 3)
			return true;
		return false;
	}
	protected boolean testVille(String ville) {
		if (ville != null && ville.length() > 1)
			return true;
		return false;
	}
	protected boolean testCodePostal(String codePostal) {
		if (codePostal != null && codePostal.length() > 2)
			return true;
		return false;
	}
	protected boolean testPays(String pays) {
		if (pays != null && pays.length() > 3)
			return true;
		return false;
	}
	
}
