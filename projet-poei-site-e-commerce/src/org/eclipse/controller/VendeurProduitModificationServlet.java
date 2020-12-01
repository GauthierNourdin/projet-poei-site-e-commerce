package org.eclipse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;

@WebServlet("/vendeur/produit/modification")
public class VendeurProduitModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			ProduitService produitService = new ProduitService();
			Produit produit = produitService.findById(idProduit);
			request.setAttribute("produit", produit);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/modification.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String designation = request.getParameter("designation");
		double prixUnitaire = Double.parseDouble(request.getParameter("prixunitaire"));
		int quantiteEnStock = Integer.parseInt(request.getParameter("quantiteenstock"));
		int idProduit = Integer.parseInt(request.getParameter("idproduit"));
		ProduitService produitService = new ProduitService();
		Produit produit = produitService.findById(idProduit);
		String urlImage = request.getParameter("urlimage");
		String descriptionProduit = request.getParameter("descriptionproduit");
		boolean testValidite = true;
		if(testDesignation(designation)) {
			produit.setDesignation(designation);
		} else {
			testValidite = false;
			request.setAttribute("designationerreur", "nom incorrect");
		}
		if(testPrixUnitaire(prixUnitaire)) {
			produit.setPrixUnitaire(prixUnitaire);
		} else {
			testValidite = false;
			request.setAttribute("prixunitaireerreur", "prix unitaire incorrecte");
		}
		if(testQuantiteEnStock(quantiteEnStock)) {
			produit.setQuantiteEnStock(quantiteEnStock);
		} else {
			testValidite = false;
			request.setAttribute("quantiteenstockerreur", "quantite saisie incorrecte");
		}
		if(testUrlImage(urlImage)) {
			produit.setUrlImage(urlImage);
		} else {
			testValidite = false;
			request.setAttribute("urlimageerreur", "url image invalide");
		}
		if (descriptionProduit == null) {
			descriptionProduit = "";
		} 
		produit.setDescriptionProduit(descriptionProduit);
		try {
			Produit produitMisAJour = produitService.update(produit);
			if (produitMisAJour == null) {
				throw new Exception("Erreur : Absence de mise à jour du produit");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testValidite) {
			response.sendRedirect("../produits");
		} else {
			request.setAttribute("produit", produit);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/modification.jsp").forward(request, response);
		}
		
	}
	
	protected boolean testDesignation(String designation) {
		if(designation != null && designation.length() > 4)
			return true;
		return false;
	}
	
	protected boolean testPrixUnitaire(double prixUnitaire) {
		if(prixUnitaire > 0)
			return true;
		return false;
	}
	
	protected boolean testQuantiteEnStock(int quantiteEnStock) {
		if(quantiteEnStock >= 0)
			return true;
		return false;
	}
	
	protected boolean testUrlImage(String urlImage) {
		if(urlImage != null && urlImage.length() > 4)
			return true;
		return false;
	}

}
