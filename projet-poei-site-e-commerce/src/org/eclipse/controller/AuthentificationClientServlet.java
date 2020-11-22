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

@WebServlet("/client/connexion")
public class AuthentificationClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/client/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		Client client = ClientService.connectionClient(identifiant, motDePasse);
		
		if (client != null) {
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			response.sendRedirect("../home");
		} else {
			request.setAttribute("erreurConnexion", "L'identifiant ou le mot de passe est incorrect.");
			this.getServletContext().getRequestDispatcher("/WEB-INF/client/connexion.jsp").forward(request, response);
		}
		
	}

}
