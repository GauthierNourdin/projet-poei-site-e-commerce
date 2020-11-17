package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Vendeur;

@WebServlet("/vendeur/deconnexion")
public class DeconnexionVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		request.setAttribute("nom", vendeur.getNom());
		request.setAttribute("prenom", vendeur.getPrenom());
		session.removeAttribute("vendeur");
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/deconnexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
