package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Goods;
import entity.PageInfo;

@WebServlet(name = "adminGoodsServlet", urlPatterns = { "/goodslist.do" })
public class AdminGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		if(cid==null){
			cid="1";
		}
		String pageindex=request.getParameter("pageIndex");
		if(pageindex==null || pageindex=="0"){
			pageindex="1";
		}
		String pagesize=request.getParameter("pageSize");
		if(pagesize==null){
			pagesize="10";
		}
		service.GoodsService gs=new service.GoodsServiceImp();
		PageInfo<Goods> pageinfo = gs.goodsList(cid, Integer.parseInt(pagesize), Integer.parseInt(pageindex));
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(pageinfo));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
