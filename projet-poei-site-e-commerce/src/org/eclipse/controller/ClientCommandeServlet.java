package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.Produit;
import org.eclipse.service.CommandeService;
import org.eclipse.service.LigneCommandeService;
import org.eclipse.service.ProduitService;

@WebServlet("/client/commande")
public class ClientCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCommande = Integer.parseInt(request.getParameter("idcommande"));
		double prixTotal = Double.parseDouble(request.getParameter("prixtotal"));
		int nombreArticles = Integer.parseInt(request.getParameter("nombrearticles"));

		CommandeService commandeService = new CommandeService();
		Commande commande = commandeService.findById(idCommande);

		LigneCommandeService ligneCommandeService = new LigneCommandeService();
		ArrayList<LigneCommande> lignesCommande = ligneCommandeService.findByCommande(idCommande);
		ArrayList<LigneCommandeAffichage> lignesCommandeAffichage = new ArrayList<LigneCommandeAffichage>();

		ProduitService produitService = new ProduitService();

		for (LigneCommande ligneCommande : lignesCommande) {
			Produit produit = produitService.findById(ligneCommande.getIdProduit());

			LigneCommandeAffichage ligneCommandeAffichage = new LigneCommandeAffichage(ligneCommande.getId(),
					ligneCommande.getQuantiteCommandee(), idCommande, ligneCommande.getIdProduit(),
					ligneCommande.getPrixUnitaire(), produit.getDesignation(), produit.getUrlImage());

			lignesCommandeAffichage.add(ligneCommandeAffichage);
		}

		request.setAttribute("prixTotal", prixTotal);
		request.setAttribute("nombreArticles", nombreArticles);
		request.setAttribute("commande", commande);
		request.setAttribute("lignesCommandeAffichage", lignesCommandeAffichage);

		this.getServletContext().getRequestDispatcher("/WEB-INF/client/commande.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
