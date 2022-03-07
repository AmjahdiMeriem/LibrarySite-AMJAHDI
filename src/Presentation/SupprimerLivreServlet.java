package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ILivreService;
import Service.LivreServiceImpl;

@WebServlet("/SupprimerLivreServlet")
public class SupprimerLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimerLivreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ILivreService livreService = new LivreServiceImpl();
		Long isbn = Long.valueOf(Integer.parseInt(request.getParameter("id")));
		livreService.removeLivre(isbn);
		this.getServletContext().getRequestDispatcher("/SupprimerLivre.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
