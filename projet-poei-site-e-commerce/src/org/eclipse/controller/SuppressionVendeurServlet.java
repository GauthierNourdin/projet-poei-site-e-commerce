package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Vendeur;
import org.eclipse.service.VendeurService;

@WebServlet("/vendeur/suppression")
public class SuppressionVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vendeur/suppression.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		
		if(vendeur.getIdentifiantConnexion().equals(identifiant) && vendeur.getMotDePasse().equals(motDePasse) ) {
			try {
				session.setAttribute("nom", vendeur.getNom());
				session.setAttribute("prenom", vendeur.getPrenom());
				VendeurService.retirerVendeur(vendeur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/confirmationsuppression.jsp").forward(request, response);
			} catch (Exception e) {
				session.setAttribute("erreurSuppression", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/suppression.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreurConnexion", "L'identifiant ou le mot de passe est incorrect.");
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/suppression.jsp").forward(request, response);
		}
	}

}
