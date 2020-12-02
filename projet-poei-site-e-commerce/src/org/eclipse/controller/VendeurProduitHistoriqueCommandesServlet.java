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

@WebServlet("/vendeur/produit/historiquecommandes")
public class VendeurProduitHistoriqueCommandesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			ProduitService produitService = new ProduitService();
			Produit produit = produitService.findById(idProduit);
			request.setAttribute("produit", produit);
			
			LigneCommandeService ligneCommandeService = new LigneCommandeService();
			ArrayList<LigneCommande> lignesCommande = ligneCommandeService.findByProduit(idProduit);
			ArrayList<CommandeProduit> commandesProduit = new ArrayList<CommandeProduit>();
			
			CommandeService commandeService = new CommandeService();
			
			for (LigneCommande ligneCommande : lignesCommande) {
				Commande commande = commandeService.findById(ligneCommande.getIdCommande());
				
				CommandeProduit commandeProduit = new CommandeProduit(commande.getDateDeCommande(), ligneCommande.getQuantiteCommandee(), ligneCommande.getPrixUnitaire());
				commandesProduit.add(commandeProduit);
			}
			
			request.setAttribute("commandesProduit", commandesProduit);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/historiquecommandes.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("../produits");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
