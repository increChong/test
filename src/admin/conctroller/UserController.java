package admin.conctroller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;

import com.google.gson.Gson;

import entity.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "userController", urlPatterns = { "/usercontroller.do" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type != null && type.equals("list")) {
			service.UserService us = new service.UserServiceImp();
			List<User> list = us.userList();
			Gson gson = new Gson();
			String json = gson.toJson(list);
			response.getWriter().write(json);
		} else if (type != null && type.equals("remove")) {
			service.UserService us = new service.UserServiceImp();
			String userid = request.getParameter("userid");
			us.removeUser(userid);
			response.getWriter().write("1");
		} else if (type != null && type.equals("add")) {
			service.UserService us = new service.UserServiceImp();
			User user = null;
			String uloginid = request.getParameter("uloginid");
			user = us.getUserByLoginId(uloginid);
			if (user == null) {
				String uemail = request.getParameter("uemail");
				String upassword = request.getParameter("upassword");
				String usex = request.getParameter("usex");
				String utel = request.getParameter("utel");
				String uaddress = request.getParameter("uaddress");
				String userid = UUID.randomUUID().toString();// ��������
				String ustateid = "B5868B7A06E54DAEB19658343D3A2B28";
				String uroleid = "116F9526C319462780B9CA72F6BB9B41";
				user = new User(userid, uemail, uloginid, upassword, usex,
						uaddress, utel, ustateid, uroleid);
				// System.out.println(user);
				us.insertUser(user);
				response.getWriter().write("1");
			} else {
				response.getWriter().write("0");
			}
		} else if (type != null && type.equals("update")) {
			service.UserService us = new service.UserServiceImp();
			String uloginid = request.getParameter("uloginid");
			String uemail = request.getParameter("uemail");
			String upassword = request.getParameter("upassword");
			String usex = request.getParameter("usex");
			String utel = request.getParameter("utel");
			String uaddress = request.getParameter("uaddress");
			String userid = request.getParameter("userid");
			String ustateid = "B5868B7A06E54DAEB19658343D3A2B28";
			String uroleid = "116F9526C319462780B9CA72F6BB9B41";
			User user = new User(userid, uemail, uloginid, upassword, usex,
					uaddress, utel, ustateid, uroleid);
			us.update(user);
			// System.out.println(userid);
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
