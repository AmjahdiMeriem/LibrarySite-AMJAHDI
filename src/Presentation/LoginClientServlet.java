package Presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Service.ILoginService;
import Service.LoginServiceImpl;

@WebServlet("/LoginClientServlet")
public class LoginClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoginService login = new LoginServiceImpl();

	public LoginClientServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pg = request.getParameter("p");

		if (pg.equalsIgnoreCase("AjouterLivrePannierServlet")) {
			Long ISBN = Long.valueOf(Integer.parseInt(request.getParameter("ISBN")));
			request.setAttribute("ISBN", ISBN);
		}

		request.setAttribute("drapeau", 1);

		User user = new User();
		ILoginService login = new LoginServiceImpl();

		user.setEmailUser(request.getParameter("email"));
		user.setPasswordUser(request.getParameter("password"));
		User u = new User();
		u = login.checkLogin(user);

		if (u == null) {
			user = new User();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("idUser", u.getIdUser());
			session.setAttribute("name", u.getNameUser());
			session.setAttribute("role", u.getIdRoleUser());

			this.getServletContext().getRequestDispatcher("/" + pg).forward(request, response);

		}
	}

}
