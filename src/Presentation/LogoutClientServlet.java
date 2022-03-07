package Presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutClientServlet")
public class LogoutClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.removeAttribute("role");
		session.removeAttribute("idUser");
		request.getSession().invalidate();
		String pg="AfficherLivrePannierServlet";
		
		request.setAttribute("page", pg);
		this.getServletContext().getRequestDispatcher("/Login.jsp" ).forward( request, response );
	}

}
