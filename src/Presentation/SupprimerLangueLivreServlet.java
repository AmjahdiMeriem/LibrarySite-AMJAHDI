package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ILangueLivreService;
import Service.LangueLivreServiceImpl;

/**
 * Servlet implementation class SupprimerLangueLivreServlet
 */
@WebServlet("/SupprimerLangueLivreServlet")
public class SupprimerLangueLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerLangueLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILangueLivreService langueService = new LangueLivreServiceImpl();
		Long idLangue = Long.valueOf(Integer.parseInt(request.getParameter("id")));
		langueService.removeLangueLivre(idLangue);
		this.getServletContext().getRequestDispatcher("/SupprimerLangue.jsp").forward(request, response);
	}

}
