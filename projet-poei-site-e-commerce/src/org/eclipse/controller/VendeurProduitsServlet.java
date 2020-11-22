package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;
import org.eclipse.service.ProduitService;
import org.eclipse.service.VendeurService;

@WebServlet("/vendeur/produits")
public class VendeurProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		ArrayList<Produit> produits = ProduitService.findByVendeur(vendeur.getIdVendeur());
		request.setAttribute("produits", produits);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produits.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		String designation = request.getParameter("designation");
		double prixUnitaire = Double.parseDouble(request.getParameter("prixunitaire"));
		int quantiteEnStock = Integer.parseInt(request.getParameter("quantiteenstock"));
		String urlImage = request.getParameter("urlimage");
		String descriptionProduit = request.getParameter("descriptionproduit");
		boolean testValidite = true;
		if(!testDesignation(designation)) {
			testValidite = false;
			request.setAttribute("designationerreur", "nom incorrect");
		}
		if(!testPrixUnitaire(prixUnitaire)) {
			testValidite = false;
			request.setAttribute("prixunitaireerreur", "prix unitaire incorrecte");
		}
		if(!testQuantiteEnStock(quantiteEnStock)) {
			testValidite = false;
			request.setAttribute("quantiteenstockerreur", "quantite saisie incorrecte");
		}
		if(!testUrlImage(urlImage)) {
			testValidite = false;
			request.setAttribute("urlimageerreur", "url image invalide");
		}
		if (descriptionProduit == null) {
			descriptionProduit = "";
		}
		if (testValidite) {
			Produit produit = new Produit(designation, prixUnitaire, quantiteEnStock, urlImage, descriptionProduit, vendeur.getIdVendeur(), new ArrayList<Integer>());
			try {
				ProduitService.save(produit);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ArrayList<Integer> idProduits = vendeur.getIdProduits();
			idProduits.add(produit.getId());
			vendeur.setIdProduits(idProduits);
			try {
				VendeurService.update(vendeur);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("designationsaisie",designation);
			request.setAttribute("prixunitairesaisie",prixUnitaire);
			request.setAttribute("quantiteenstocksaisie",quantiteEnStock);
			request.setAttribute("urlimagesaisie",urlImage);
			request.setAttribute("descriptionproduitsaisie",descriptionProduit);
		}
		doGet(request,response);
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
