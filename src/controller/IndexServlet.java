package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import entity.News;
import sun.print.resources.serviceui;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "index", urlPatterns = { "/index.do" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 service.NewsService ns=new service.NewsServiceImp();
		 String type=request.getParameter("email");
		 if(type!=null&&type.equals("email")){
			 request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		 }else{
		 List<News> news=ns.newsList();
		
		 request.setAttribute("news",news);
	
		 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		 }
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
