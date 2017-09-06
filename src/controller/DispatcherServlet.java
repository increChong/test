package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;
import entity.News;
import entity.User;
import service.NewsService;
import service.UserServiceImp;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "dispatcher", urlPatterns = { "/dispatcher.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		Cookie[] cookies = request.getCookies();
		Cookie currentCookie = null;
		for(Cookie c :cookies){
			if(c.getName().equals("uloginid")){
				currentCookie = c;
			}
		}
		//String gid=request.getParameter("gid");
		System.out.println(id);
		if(type!=null&&type.equals("news")&&id!=null){
		service.NewsService ns=new service.NewsServiceImp();
		News news=ns.getNewsById(id);
		request.setAttribute("news", news);
			request.getRequestDispatcher("/WEB-INF/title.jsp").forward(request, response);
		}else if(type!=null&&type.equals("goods")&&id!=null){
			//System.out.println(gid);
			dao.GoodsDao gs=new dao.imp.GoodsDaoImp();
			Goods goods=gs.getGoodsById(id);
			//System.out.println(goods);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
		}else if(type!=null&&type.equals("teg")){
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}else if(type!=null&&type.equals("user")){
			
			if(currentCookie!=null){ //�û�ѡ���ס����;
				String uloginid = currentCookie.getValue();
				service.UserService us =new UserServiceImp();
				User user = us.getUserByLoginId(uloginid);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
			
		}else if(type!=null&&type.equals("modify")){
			String uloginid = currentCookie.getValue();
			service.UserService us =new UserServiceImp();
			User user = us.getUserByLoginId(uloginid);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);
		}else if(type!=null&&type.equals("email")){
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}else if(type!=null && type.equals("finishlogin")){
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}else if(type!=null && type.equals("modify")){
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);
		}else if(type!=null && type.equals("cart")){
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		}else if(type!=null && type.equals("order")){
			request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
		}else if(type!=null && type.equals("orderfinal")){
			request.getRequestDispatcher("/WEB-INF/orderfinal.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
