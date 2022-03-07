package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.GenreLivreServiceImpl;
import Service.IGenreLivreService;

/**
 * Servlet implementation class SupprimerGenreLivreServlet
 */
@WebServlet("/SupprimerGenreLivreServlet")
public class SupprimerGenreLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerGenreLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IGenreLivreService genreService = new GenreLivreServiceImpl();
		Long idGenre = Long.valueOf(Integer.parseInt(request.getParameter("id")));
		genreService.removeGenreLivre(idGenre);
		this.getServletContext().getRequestDispatcher("/SupprimerGenre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
