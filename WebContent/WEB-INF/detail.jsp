<%@page import="entity.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="service.CategoryServiceImp"%>
<%@page import="dao.imp.CategoryDaoImp"%>
<%@page import="service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" rev="stylesheet" href="css/style.css"
	type="text/css" media="all" />
</head>
<body>
	<%@include file="header.jsp"%>
	<%
   CategoryService cs1 = new CategoryServiceImp();
   request.setAttribute("cates", cs1.listCategory());
   Category cate=null;
   for(Category c:cs1.listCategory()){
	   if(c.getCid()==request.getParameter("cid")){
		   cate=c;
	   }
   }
   
%>
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%"><table width="100%" border="0" cellspacing="0"
						style="margin-top: 30px">
						<tr>
							<td class="listtitle">分类</td>
						</tr>
						<c:forEach items="${cates }" var="cate">
							<tr>
								<td class="listtd"><img src="images/miniicon.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="${pageContext.request.contextPath }/list.do?type=goods&cid=${cate.cid }">${cate.cname }</a></td>
							</tr>

						</c:forEach>

					</table></td>
				<td><div style="text-align: right; margin: 5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<c:forEach items="${cates }" var="cate">
							<c:if test="${cate.cid }==${goods.cid }">
								<a
									href="${pageContext.request.contextPath }/list.do?type=goods&cid=${cate.cid }">&nbsp;${cate.cname }</a>
							</c:if>
						</c:forEach>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;大勇和小花的欧洲日记
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img
								src="${pageContext.request.contextPath }/images/ad/page_ad.jpg"
								width="645" height="84" />

								<table width="100%%" border="0" cellspacing="0">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img
														src="${pageContext.request.contextPath }/images/bookcover/${goods.gimg }.jpg" />
												</p>
											</div>

											<div style="text-align: center; margin-top: 25px">
												<a href="cart.html"><img src="images/buybutton.gif"
													border="0" /></a>
											</div>
										</td>
										<td style="padding: 20px 5px 5px 5px"><img
											src="images/miniicon3.gif" width="16" height="13" /><font
											class="bookname">&nbsp;&nbsp;${goods.gtitle }</font>
										<hr />作者：${goods.gauthor } 著
											<hr />售价：<font color="#FF0000">￥${goods.gsaleprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥${goods.ginprice }</s>
										<hr />出版社：湖南教育出版社
											<hr />
											<p>
												<b>内容简介：</b>
											</p> ${goods.gdesc }</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>