$(function(){
	
	$('#btnsave').on('click',function(){
		var isValid=$('form').form('validate');
		if(isValid){
		$.ajax({
			type:'post',
			data:$('#f1').serialize(),
			url:'/webproject/usercontroller.do?type=add',
			success:function(data){
				if(data=="1"){
					//清空input
					$('#f1').form('clear');
					//关闭dialog
					$('#dialog').dialog('close');
					//刷新datagrid
					$('#tab').datagrid('reload');
				}else if(data=="0"){
					$.messager.alert('警告','用户名已存在！','info'); 
				}
			}
		});
		}
	})
	//加载t_user表数据，在easyUI的datagrid控件中显示
	$('#tab').datagrid({
		url:'/webproject/usercontroller.do',
		title:'用户信息',
		iconCls:'icon-ok',
		idField:'userid',
		queryParams:{type:'list'},
		loadMsg:'正在加载，请稍后......',
		singleSelect:true,
		collapsible:true,
		rownumbers:true,
		toolbar:[
		         {text:'编辑',iconCls:'icon-edit',handler:function(){
		        	 //$.messager.alert('修改','实现修改功能','info');
		        	 var row=$('#tab').datagrid('getSelected');
		        	 if(row==null){
		        		 $.messager.alert('提示','请选择要修改的行','info');
		        	 }
		        	 if(row!=null){
		        		 $('#uemail').textbox('setValue',row.uemail);
		        		 $('#uloginid').textbox('setValue',row.uloginid);
		        		 $('#uloginid').textbox({readonly:true});
		        		 $('#upassword').textbox('setValue',row.upassword);
		        		 $('#usex').combobox('setValue',row.usex);
		        		 $('#utel').textbox('setValue',row.utel);
		        		 $('#uaddress').textbox('setValue',row.uaddress);
		        		 
		        	 }
		        	 $('#dialog').dialog({
		        		 title:'修改用户',
		        		 closed:false,
		        		 iconCls:'icon-edit',
		        		 buttons:[{text:'保存修改',iconCls:'icon-save',handler:function(){
		        			 var isValid=$('form').form('validate');
		        				if(isValid){
		        				$.ajax({
		        					type:'post',
		        					data:$('#f1').serialize(),
		        					url:'/webproject/usercontroller.do?type=update',
		        					success:function(data){
		        						if(data=="1"){
		        							//清空input
		        							$('#f1').form('clear');
		        							//关闭dialog
		        							$('#dialog').dialog('close');
		        							//刷新datagrid
		        							$('#tab').datagrid('reload');
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
		        	 $('#dialog').dialog('open');
		        	 
		         }},
		         {text:'删除',iconCls:'icon-remove',handler:function(){
		        	// $.messager.alert('删除','实现删除功能','info');
		        	 var row=$('#tab').datagrid('getSelected');
		        	 if(row==null){
		        		 $.messager.alert('提示','请选择要删除的行','info');
		        	 }else{
		        		 $.messager.confirm('删除确认',"你确认要删除用户："+row.uloginid+"  的数据吗？",function(r){
		        			 if(r){ 
		        				 $.ajax({
		        					 url:'/webproject/usercontroller.do',
		        					 type:'post',
		        					 async:false,
		        					 data:{type:'remove',userid:row.userid},
		        					 dataType:'text',
		        				 	 success:function(){
		        				 		// alert(data);
		        				 		//if(data=="1"){
		        				 			$.messager.alert('删除提示','删除成功','info');
		        				 			$('#tab').datagrid('reload');
		        				 		//}
		        				 	}
		        				 })
		        			 }
		        			 
		        		 })
		        	 }
		         }}
		         ],
		columns:[[{
			field:'chk',checkbox:true
		},{
			field:'userid',title:'编号'
		},{
			field:'uemail',title:'邮箱'
		},{
			field:'uloginid',title:'账号'
		},{
			field:'upassword',title:'密码'
		},{
			field:'usex',title:'性别'
		},{
			field:'utel',title:'电话'
		},{
			field:'uaddress',title:'地址'
		},{
			field:'ustateid',title:'状态'
		},{
			field:'uroleid',title:'角色'
		}]]
	})
	
})