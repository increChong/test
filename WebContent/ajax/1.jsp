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
	$('#uname').on('input',function(){
		$.ajax(
			{
				data:{'uname':$(this).val()},
				type:'POST',
				url:'/webproject/checkname.do',
				success:function(data){
					if(data=="1"){
						$('span:first').html('已被注册');
					}else if(data=="0"){
						$('span:first').html('可以使用');
					}
				}
			}	
		)
		
	})
})

</script>
</head>
<body>
	账号：
	<input type="text" id="uname" />
	<span></span>
	<br> 密码：
	<input type="password" id="upassword">
</body>
</html>