package Presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Livre;
import Service.IPannierService;
import Service.PannierServiceImpl;

@WebServlet("/AfficherLivrePannierServlet")
public class AfficherLivrePannierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AfficherLivrePannierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPannierService pannier = new PannierServiceImpl();
		List<Livre> livres = new ArrayList<Livre>();
		HttpSession session = request.getSession();
		Long idUser = (Long) session.getAttribute("idUser");

		livres = pannier.findLivrePannierByIdUsr(idUser);
		request.setAttribute("livres", livres);
		this.getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPannierService pannier = new PannierServiceImpl();
		List<Livre> livres = new ArrayList<Livre>();
		HttpSession session = request.getSession();
		Long idUser = (Long) session.getAttribute("idUser");

		livres = pannier.findLivrePannierByIdUsr(idUser);
		request.setAttribute("livres", livres);
		this.getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);
	}

}
