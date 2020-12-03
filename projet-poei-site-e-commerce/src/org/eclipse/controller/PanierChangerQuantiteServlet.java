package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LignePanier;
import org.eclipse.service.LignePanierService;

@WebServlet("/panier/changerquantite")
public class PanierChangerQuantiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Méthode appelée par javax pour changer dynamiquement une quantité de produit à une ligne du panier
		
		String nombreExemplairesValide = "-1";
		int idLignePanier = Integer.parseInt(request.getParameter("idlignepanier"));
		int quantiteSouhaitee = Integer.parseInt(request.getParameter("quantitesouhaitee"));
		
		LignePanierService lignePanierService = new LignePanierService();
		LignePanier lignePanier = lignePanierService.findById(idLignePanier);
		if (lignePanier != null) {
			lignePanier.setQuantiteSouhaitee(quantiteSouhaitee);
			
			try {
				lignePanier = lignePanierService.update(lignePanier);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (lignePanier != null) {
				nombreExemplairesValide = String.valueOf(lignePanier.getQuantiteSouhaitee());
			}
		}

		response.getWriter().write("<nombreexemplairesvalide>" + nombreExemplairesValide + "</nombreexemplairesvalide>");
		
	}

}
