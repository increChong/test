<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电子书城</title>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" rev="stylesheet" href="css/style.css"
	type="text/css" media="all" />

</head>
<body class="main">
	<!-- Logo -->

	<!-- Logo end -->
	<!-- menu -->
	<%@include file="header.jsp"%>
	<!-- menu end -->
	<!-- search -->


	<!-- search end -->
	<!-- 广告   -->
	<div id="divad">
		<img src=" ${pageContext.request.contextPath }/images/ad/index_ad.jpg" />
	</div>
	<!-- 广告  end -->

	<!-- 正文   -->
	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497"><img
					src="${pageContext.request.contextPath }/images/billboard.gif"
					width="497" height="38" />
					<table cellspacing="0" class="ctl">

						<tr>
							<td>&middot;<a href="news.html" style="color: #000000">图书3折起，支持在线浏览
									先看再买不后悔,任何商品免费送货</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color: #000000">Lonely
									Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color: #000000">2007年中旅游图书畅销榜速递
									中国游,世界游,旅游图书全部7折封顶</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color: #000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color: #000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>

					</table></td>
				<td style="padding: 5px 15px 10px 40px"><table width="100%"
						border="0" cellspacing="0">
						<tr>
							<td><img
								src="${pageContext.request.contextPath }/images/hottitle.gif"
								width="126" height="29" /></td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td style="width: 50; text-align: center"><a
								href="info.html"><img
									src="${pageContext.request.contextPath }/images/bookcover/travelbook.jpg"
									width="102" height="130" border="0" /></a><br /> <a
								href="info.html">TravelBook<br /> 作者:Lonley Plant
							</a></td>
							<td style="width: 50; text-align: center"><a
								href="info.html"><img
									src="${pageContext.request.contextPath }/images/bookcover/java2.jpg"
									width="102" height="130" border="0" /></a><br /> <a
								href="info.html">Java2入门经典(JDK5) <br /> 作者:(美)霍顿
							</a></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>
	<!-- 正文 end   -->

	<!-- footer -->
	<%@include file="footer.jsp"%>
	<!-- footer end -->

</body>

</html>