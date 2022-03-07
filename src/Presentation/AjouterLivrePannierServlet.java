package Presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.IPannierService;
import Service.PannierServiceImpl;

@WebServlet("/AjouterLivrePannierServlet")
public class AjouterLivrePannierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjouterLivrePannierServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IPannierService pannier = new PannierServiceImpl();
		Long ISBN = Long.valueOf(Integer.parseInt(request.getParameter("ISBN")));
		
		HttpSession session = request.getSession();
		Long idUser = (Long) session.getAttribute("idUser");
		pannier.addLivrePannier(idUser, ISBN);
		this.getServletContext().getRequestDispatcher("/AfficherLivrePannierServlet" ).forward( request, response );
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPannierService pannier = new PannierServiceImpl();
		Long ISBN = Long.valueOf(Integer.parseInt(request.getParameter("ISBN")));
		HttpSession session = request.getSession();
		Long idUser = (Long) session.getAttribute("idUser");
		pannier.addLivrePannier(idUser, ISBN);
		this.getServletContext().getRequestDispatcher("/AfficherLivrePannierServlet" ).forward( request, response );
		
	}

}
