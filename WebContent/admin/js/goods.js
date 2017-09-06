$(function(){
	var option={
			dataType:"text",
			success:function(data){
				if(data=="1"){
					//alert("ok");
					//清空input
					$('#f1').form('clear');
					$('#dd').html('');
					//关闭dialog
					$('#dialog').dialog('close');
					//刷新datagrid
					$('#tb').datagrid('reload');
					
				}else if(data=="0"){
					$.messager.alert('警告','图书编号已存在！','info'); 
				}
			}
	};
	$('#btnsave').on('click',function(){
		//alert("ok");
		var isValid=$('form').form('validate');
		if(isValid){
		$('#f1').ajaxSubmit(option);
//		$.ajax({
//			type:'post',
//			data:formData,
//			async: false,  
//	        cache: false,  
//			contentType: false,
//			 processData: false,
//			url:'/webproject//goodscontroller.do?type=add',
//			success:function(data){
//				if(data=="1"){
//					//清空input
//					$('#f1').form('clear');
//					$('#dd').html('');
//					//关闭dialog
//					$('#dialog').dialog('close');
//					//刷新datagrid
//					$('#tb').datagrid('reload');
//				}else if(data=="0"){
//					$.messager.alert('警告','图书编号已存在！','info'); 
//				}
//			},
//			error:function(data){
//				alert("上传错误！"); 
//			}
//		});
		}
	});
	$('#cate').combobox({
	url:'/webproject/catecontroller.do',
	valueField:'cid',
	textField:'cname',
	onSelect:function(data){
	loadGoods(data.cid);
	},
	onLoadSuccess:function(){
		   var datas=$(this).combobox('getData');
		   if(datas.length>0){
		   		$(this).combobox('setValue',datas[0].cid);
		   		var cid=$('#cate').combobox('getValue');
		   		loadGoods(cid);
		   }
	}
	});
	$('#cate1').combobox({
	url:'/webproject/catecontroller.do',
	valueField:'cid',
	textField:'cname',
	onLoadSuccess:function(){
		   var datas=$(this).combobox('getData');
		   if(datas.length>0){
		   		$(this).combobox('setValue',datas[0].cid);
		   }
	}
	});
})
	function loadGoods(cid){
	$('#tb').datagrid({
	url:'/webproject/goodscontroller.do?type=list',
	queryParams:{cid:cid},
	title:'商品数据',
	pageSize:5,
	pageList:[5,20,30,50],
	pagination:true,
	collapsible:true,
	singleSelect:true,
	toolbar:[
		         {text:'编辑',iconCls:'icon-edit',handler:function(){
		        	// $.messager.alert('修改','实现修改功能','info');
		        	 $('#f1').form('clear');
						$('#dd').html('');
		         	var row=$('#tb').datagrid('getSelected');
		        	 if(row==null){
		        		 $.messager.alert('提示','请选择要修改的行','info');
		        	 }
		        	 if(row!=null){
		        		 $('#gid').textbox('setValue',row.gid);
		        		 $('#gid').textbox({readonly:true});
		        		 $('#gtitle').textbox('setValue',row.gtitle);
		        		 $('#gauthor').textbox('setValue',row.gauthor);
		        		 $('#gsaleprice').textbox('setValue',row.gsaleprice);
		        		 $('#ginprice').textbox('setValue',row.ginprice);
		        		 $('#gimg').textbox('setValue',row.gimg);
		        		 $('#gdesc').textbox('setValue',row.gdesc);
//		        		 $('#cate1').combobox('setValue',row.cid);
		        		 $('#pid').combobox('setValue',row.pid);
		        		 $('#gclicks').textbox('setValue',row.gclicks); 
		        		 $('#cate1').combobox({
								url:'/webproject/catecontroller.do',
								valueField:'cid',
								textField:'cname',
								onLoadSuccess:function(){
									   var datas=$(this).combobox('getData');
									   for(var i=0;i<datas.length;i++){
									   if(datas[i].cid==row.cid){
									   		$(this).combobox('setValue',datas[i].cid);
									   }
									   }
								}
								});
		        	 }
		        	 $('#dialog').dialog({
		        		 title:'修改信息',
		        		 closed:false,
		        		 iconCls:'icon-edit',
		        		 buttons:[{text:'保存修改',iconCls:'icon-save',handler:function(){
		        			 var isValid=$('form').form('validate');
		        				if(isValid){
		        				$.ajax({
		        					type:'post',
		        					data:$('#f1').serialize(),
		        					url:'/webproject/goodscontroller.do?type=update',
		        					success:function(data){
		        						if(data=="1"){
		        							//清空input
		        							$('#f1').form('clear');
		        							//关闭dialog
		        							$('#dialog').dialog('close');
		        							//刷新datagrid
		        							$('#tb').datagrid('reload');
		        						}
		        					}
		        				});
		        				}
		        		 }}]
		        		 
		        	 });
		         }},
		         {text:'添加',iconCls:'icon-add',handler:function(){
		        	 //$.messager.alert('添加','实现添加功能','info');
		        	 $('#f1').form('clear');
						$('#dd').html('');
		        	$('#dialog').dialog('open');
		        	 
		         }},
		         {text:'删除',iconCls:'icon-remove',handler:function(){
		        	 //$.messager.alert('删除','实现删除功能','info');
		         	 var row=$('#tb').datagrid('getSelected');
		        	 if(row==null){
		        		 $.messager.alert('提示','请选择要删除的行','info');
		        	 }else{
		        		 $.messager.confirm('删除确认',"你确认要图书："+row.gtitle+"  的数据吗？",function(r){
		        			 if(r){ 
		        				 $.ajax({
		        					 url:'/webproject/goodscontroller.do',
		        					 type:'post',
		        					 async:false,
		        					 data:{type:'remove',gid:row.gid},
		        					 dataType:'text',
		        				 	 success:function(){
		        				 		// alert(data);
		        				 		//if(data=="1"){
		        				 			$.messager.alert('删除提示','删除成功','info');
		        				 			$('#tb').datagrid('reload');
		        				 		//}
		        				 	}
		        				 })
		        			 }
		        			 
		        		 })
		        	 }
		        	 
		         }}
		         ],
	columns:[[
						{field:'chk',checkbox:true},
						{field:'gid',title:"编号",sortable :true,sortable:true,align:'center',sorter:function(a,b){  
				a = a.split('/');  
				b = b.split('/');  
				if (a[2] == b[2]){  
					if (a[0] == b[0]){  
						return (a[1]>b[1]?1:-1);  
					} else {  
						return (a[0]>b[0]?1:-1);  
					}  
				} else {  
					return (a[2]>b[2]?1:-1);  
				}  
			}  },
						{field:'gtitle',title:"书名"},
						{field:'gauthor',title:"作者"},
						{field:'gsaleprice',title:"售价"},
						{field:'ginprice',title:"原价"},
						{field:'gimg',title:"图片", formatter: function(value,row,index){
       // return '<a style="color:blue" href="/webproject/images/bookcover/'+row.gimg+'.jpg" >'+row.gimg+'</a>';
        return '<img id = "imgTest"  src="/webproject/images/bookcover/'+row.gimg+'.jpg" style="width:50px; height:80px">';
		//return '<a class ="tooltip" title ="预览" href="/webproject/images/bookcover/'+row.gimg+'.jpg" ><img src="/webproject/images/bookcover/'+row.gimg+'.jpg" style="width:50px; height:80px"></a>';
							
        }},
     					{field:'gdesc',title:"简介",formatter: function(value,row,index){
        return '<textarea  rows="5" cols="30" readonly="readonly" resize:none>'+row.gdesc+'</textarea>';}},
     					{field:'gclicks',title:"访问量"},
     					{field:'cid',title:"类别代码"},
     					{field:'pid',title:"出版社代码"}
				]]
	})
	
}
function numberSort(a,b){  
 var number1 = parseFloat(a);  
 var number2 = parseFloat(b);  
   
 return (number1 > number2 ? 1 : -1);    
}  