package admin.conctroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Log;

/**
 * Servlet implementation class LogContrller
 */
@WebServlet(name = "logController", urlPatterns = { "/log.do" })
public class LogContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type != null && type.equals("list")) {
			service.LogService ls=new service.LogServiceImp();
			List<Log> list=ls.list();
			Gson gson = new Gson();
			String json = gson.toJson(list);
			response.getWriter().write(json);
			//System.out.println(list);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
