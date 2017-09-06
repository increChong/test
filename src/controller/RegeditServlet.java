package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MailUtil;
import entity.PasswordAnswer;
import entity.User;

/**
 * Servlet implementation class RegeditServlet
 */
@WebServlet(name = "regeditServlet", urlPatterns = { "/regedit.do" })
public class RegeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid=request.getParameter("uloginid");
		String uemail=request.getParameter("uemail");
		String upassword=request.getParameter("upassword");
		String usex=request.getParameter("usex");
		String utel=request.getParameter("utel");
		String uaddress=request.getParameter("uaddress");
		String userid=UUID.randomUUID().toString();//��������
		String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
		String uroleid="116F9526C319462780B9CA72F6BB9B41";
		
		User user=new User(userid, uemail, uloginid, upassword, usex, uaddress, utel, ustateid, uroleid);
		System.out.println(user);
		service.UserService us=new service.UserServiceImp();
		us.insertUser(user);
		
		//ȡ����
		String squestion=request.getParameter("squestion");
		String sanswer=request.getParameter("sanswer");
		String ubackupemail=request.getParameter("ubackupemail");
	    String answerid=UUID.randomUUID().toString();
	    service.PasswordAnswerService pas=new service.PasswordAnswerServiceImp();
	    entity.PasswordAnswer ps=new PasswordAnswer(squestion, sanswer, ubackupemail, answerid, userid);
	    pas.insertPasswordAnswer(ps);
	    MailUtil.sendMail(uemail, "注册激活（测试）",""
	    		+ "<span><font color='cornflowerblue'>账号："+uloginid+"</font></span><br />"
	    		+ "<span><font color='cornflowerblue'>密码："+upassword+"</font></span><br />"
	    		+ "<a href='http://192.168.80.41:8080/webproject/index.do?type=email'>点击激活</a>");
	    
		request.getRequestDispatcher("/WEB-INF/regsuccess.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
