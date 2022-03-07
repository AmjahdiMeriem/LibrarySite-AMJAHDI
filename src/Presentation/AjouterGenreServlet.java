package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GenreLivre;
import Service.GenreLivreServiceImpl;
import Service.IGenreLivreService;

/**
 * Servlet implementation class AjouterGenreServlet
 */
@WebServlet("/AjouterGenreServlet")
public class AjouterGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterGenreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GenreLivre genre = new GenreLivre();
		IGenreLivreService genreService = new GenreLivreServiceImpl();
		try {
			genre.setNomGenreLivre(request.getParameter("nameKind"));
			genreService.addGenreLivre(genre);
			this.getServletContext().getRequestDispatcher("/AjouterGenre.jsp" ).forward( request, response );
		} catch (Exception e) {
			System.out.println("Erreur");
		}
	}

}
