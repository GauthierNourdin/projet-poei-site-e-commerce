package org.eclipse.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Client;
import org.eclipse.model.Vendeur;

@WebFilter("/*")
public class PrivateFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Client clientConnected = (Client) session.getAttribute("client");
		Vendeur vendeurConnected = (Vendeur) session.getAttribute("vendeur");
		String chemin = req.getServletPath();
		
		if (clientConnected != null || vendeurConnected != null || chemin.equals("") || chemin.equals("/index")
				|| chemin.equals("/produit/produit") || chemin.equals("/client/connexion")
				|| chemin.equals("/vendeur/connexion") || chemin.equals("/client/inscription")
				|| chemin.equals("/vendeur/inscription") || chemin.equals("/panier/panier"))
			chain.doFilter(request, response);
		else
			res.sendRedirect(req.getContextPath());
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
