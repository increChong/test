window.onload=function(){
	document.querySelector('#img').onclick=function(){
		this.src='codeServlet.do '+Math.random();
	}
	document.querySelector('#check_user').onclick=function(){
	
	   var uname= document.querySelector("#uname").value;
	   var xmlhttp=new XMLHttpRequest();
	  
	   xmlhttp.open("GET", "checkname.do?uname="+uname, true);
	   
	   xmlhttp.send(null);
	  
	   xmlhttp.onreadystatechange=function(){
		   if(xmlhttp.readyState==4){
			   if(xmlhttp.status==200){
				   var data =xmlhttp.responseText;
				   var sp=document.querySelector("#sp");
				   if(data=="1"){
					   sp.innerHTML="用户名已注册";
					   sp.style.color='red';
				   }else{
					   sp.innerHTML='恭喜！用户名可用';
					   sp.style.color='green';
				   }
			   }
		   }
	   }
	}
}
	