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
	$('#textSearch').on('click',function(){
		$.getJSON('/webproject/search.do',{key:$(this).val()},function(data){
			$('#ds').empty;
			$(data).each(function(index,keyword){
				$('#ds').append("<option value='"+keyword.key+"'/>");
			})
		
	});
		
	})
})

</script>
</head>
<body>
	<input type="text" id="textSerach" list="ds">
	<br>
	<datalist id="ds">
	<option>1</option>
	<option>12</option>
	<option>123</option>
	<option>1234</option>
	</datalist>
</body>
</html>