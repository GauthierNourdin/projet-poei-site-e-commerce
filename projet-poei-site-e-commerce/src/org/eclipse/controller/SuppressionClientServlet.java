package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Client;
import org.eclipse.service.ClientService;

@WebServlet("/client/suppression")
public class SuppressionClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/client/suppression.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("vendeur");
		
		if(client.getIdentifiantConnexion().equals(identifiant) && client.getMotDePasse().equals(motDePasse) ) {
			try {
				session.setAttribute("nom", client.getNom());
				session.setAttribute("prenom", client.getPrenom());
				ClientService clientService = new ClientService();
				clientService.remove(client);
				this.getServletContext().getRequestDispatcher("/WEB-INF/client/confirmationsuppression.jsp").forward(request, response);
			} catch (Exception e) {
				session.setAttribute("erreurSuppression", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/client/suppression.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreurConnexion", "L'identifiant ou le mot de passe est incorrect.");
			this.getServletContext().getRequestDispatcher("/WEB-INF/client/suppression.jsp").forward(request, response);
		}
	}

}
