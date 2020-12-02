package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Client;
import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.service.CommandeService;
import org.eclipse.service.LigneCommandeService;

@WebServlet("/client/commandes")
public class ClientCommandesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		
		CommandeService commandeService = new CommandeService();
		LigneCommandeService ligneCommandeService = new LigneCommandeService();
		ArrayList<Commande> commandes = commandeService.findByClient(client.getIdUtilisateur());
		ArrayList<CommandeAffichage> commandesAffichage = new ArrayList<CommandeAffichage>();
		
		for (Commande commande : commandes) {
			double prixTotal = 0.0;
			int nombreArticles = 0;
			
			ArrayList<LigneCommande> lignesCommande = ligneCommandeService.findByCommande(commande.getId());
			for (LigneCommande ligneCommande : lignesCommande) {
				prixTotal += ligneCommande.getPrixUnitaire() * ligneCommande.getQuantiteCommandee();
				nombreArticles += ligneCommande.getQuantiteCommandee();
			}
			
			CommandeAffichage commandeAffichage = new CommandeAffichage(commande.getId(), client.getIdUtilisateur(), commande.getIdLignesCommande(), commande.getDateDeCommande(), nombreArticles, prixTotal); 
			commandesAffichage.add(commandeAffichage);
		}
		
		request.setAttribute("commandesAffichage", commandesAffichage);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/client/commandes.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
