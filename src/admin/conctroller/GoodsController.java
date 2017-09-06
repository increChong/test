package admin.conctroller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;




import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import entity.Goods;
import entity.PageInfo;

@MultipartConfig
@WebServlet(name = "goodsController", urlPatterns = { "/goodscontroller.do" })
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i=1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8");
		service.GoodsService gs=new service.GoodsServiceImp();
		String type=request.getParameter("type");
		if(type!=null&&type.equals("list")){
				String cid=request.getParameter("cid");
				int pagesize=Integer.parseInt(request.getParameter("rows"));
				int pageindex=Integer.parseInt(request.getParameter("page"));
				PageInfo<Goods> pageInfo=gs.goodsList(cid, pagesize, pageindex);
				HashMap<String, Object> map=new HashMap<String,Object>();
				map.put("total", pageInfo.getTotalnumber());
				map.put("rows", pageInfo.getData());
				Gson gson=new Gson();
				response.getWriter().write(gson.toJson(map));
		}else if(type!=null&&type.equals("add")){
				String gid=request.getParameter("gid");
				Goods goods=null;
				goods=gs.getGoodsById(gid);
				if(goods==null){
				String gtitle=request.getParameter("gtitle");
				String gauthor=request.getParameter("gauthor");
				String gsaleprice=request.getParameter("gsaleprice");
				String ginprice=request.getParameter("ginprice");
				String gimg=request.getParameter("gimg");
				String cid=request.getParameter("cate1");
				String pid=request.getParameter("pid");
				String gclicks=request.getParameter("gclicks");
				String gdesc=request.getParameter("gdesc");
				goods=new Goods(gid, gtitle, gauthor, gsaleprice, ginprice, gdesc, gimg, gclicks, cid, pid);
				gs.insertGoods(goods);	
				//接收文件
				// 用于输出数据（测试用）而引用的对象方法
				// 存储路径
				String savePath = request.getServletContext().getRealPath("/images/bookcover");
				String savePath2 = "E:\\JavaEE\\webproject\\WebContent\\images/bookcover";
				// 获取上传的文件集合
				Collection<Part> parts = request.getParts();
//				out.println("【parts】: " + parts + "<br/>");
				// 上传单个文件
				// Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
				//Part part = parts[0];//从上传的文件集合中获取Part对象
				Part file = request.getPart("file");
				//String gimg=request.getParameter("gimg");
				if(file!=null){
				// 通过表单file控件(<input type="file"name="file">)的名字直接获取Part对象
//				out.println("【part.getName()】: " + file.getName() + "<br/>");
//				out.println("【part.getHeader('content-disposition')】: " + file.getHeader("content-disposition") + "<br/>");
//				out.println("【getFileName(header)】: " + getFileName(file.getHeader("content-disposition")) + "<br/>");
				// Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
				// 获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
				String header = file.getHeader("content-disposition");
				// 把文件写到指定路径
				file.write(savePath + File.separator + gimg+".jpg");
				//file.write(savePath2 + File.separator + gimg+".jpg");
				//String fileAddr = savePath + "/" + gimg+".jpg";
				//out.println("【测试存储路径】" + File.separator);
//				out.println("parts.size() = " + parts.size());
//				out.println("part : " + parts);
//				out.println("上传成功");
				}
				response.getWriter().write("1");
				}else{
					response.getWriter().write("0");
				}
		}else if (type != null && type.equals("remove")) {
			String gid = request.getParameter("gid");
			gs.removeGoods(gid);
			response.getWriter().write("1");
		} else if (type != null && type.equals("update")) {
			Goods goods=null;
			String gid=request.getParameter("gid");
			String gtitle=request.getParameter("gtitle");
			String gauthor=request.getParameter("gauthor");
			String gsaleprice=request.getParameter("gsaleprice");
			String ginprice=request.getParameter("ginprice");
			String gimg=request.getParameter("gimg");
			String cid=request.getParameter("cate1");
			String pid=request.getParameter("pid");
			String gclicks=request.getParameter("gclicks");
			String gdesc=request.getParameter("gdesc");
			goods=new Goods(gid, gtitle, gauthor, gsaleprice, ginprice, gdesc, gimg, gclicks, cid, pid);
			gs.updateGoods(goods);
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
