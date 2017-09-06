package admin.conctroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

@WebServlet(name = "loginController", urlPatterns = { "/logincontroller.do" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uloginid = request.getParameter("uloginid");
		String upassword = request.getParameter("upassword");
		service.UserService us = new service.UserServiceImp();
		User user = us.login(uloginid, upassword);
		// System.out.println(user);
		if (user != null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
