package Presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Service.IUserService;
import Service.UserServiceImpl;

@WebServlet("/SaveClientServlet")
public class SaveClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveClientServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		IUserService userService=new UserServiceImpl();
		
		user.setNameUser(request.getParameter("name"));
		user.setEmailUser(request.getParameter("email"));
		user.setPasswordUser(request.getParameter("password"));
		user.setIdRoleUser(1L);
		
		userService.saveClient(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
	}

}
