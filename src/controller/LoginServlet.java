package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

@WebServlet(name = "loginServlet", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid=request.getParameter("uloginid");
		String upassword=request.getParameter("upassword");
		service.UserService us=new service.UserServiceImp();
		User user=us.login(uloginid, upassword);
		//System.out.println(user);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			String chk=request.getParameter("chk");
			if(chk!=null){
				Cookie cookie=new Cookie("uloginid", uloginid);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			request.setAttribute("uloginid", uloginid);
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
