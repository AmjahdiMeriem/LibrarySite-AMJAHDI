package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k = request.getParameter("Kind").trim();
		if(k == null || "".equals(k)){
			k = "Guest";
		}
		
		String greetings = "Hello " + k;
		System.out.println(greetings);
		response.setContentType("text/plain");
		response.getWriter().write(greetings);
	}

}
