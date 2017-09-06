<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
		$(function(){
			$('input[type=button]').click(function(){
				console.log($('form').serialize());
				console.log($('form').serializeArray());
			})
			
		})

</script>
</head>
<body>
	<form action="">
		账号：<input type="text" id="uname" name="uname"><br> 密码：<input
			type="password" id="upassword" name="upassword"><br> 电话：<input
			type="text" id="utel" name="utel"><br> 地址：<input
			type="text" id="uaddress" name="uaddress"> <br> <input
			type="button" value="测试序列化">


	</form>
</body>
</html>