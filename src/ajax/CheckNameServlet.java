package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet implementation class CheckNameServlet
 */
@WebServlet(name = "checkNameServlet", urlPatterns = { "/checkname.do" })
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		service.UserService us=new service.UserServiceImp();
		User user = us.getUserByLoginId(uname);
		if(user!=null){
			response.getWriter().write("1");
		}
		if(user==null){
			response.getWriter().write("0");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
