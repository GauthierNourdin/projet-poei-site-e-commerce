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

import org.eclipse.model.Vendeur;

@WebFilter("/produit/produit")
public class ProduitFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//		Vendeur vendeurConnected = (Vendeur) session.getAttribute("vendeur");
//		if (vendeurConnected == null)
			chain.doFilter(request, response);
//		else
//			res.sendRedirect(req.getContextPath() + "/vendeur/produits");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
