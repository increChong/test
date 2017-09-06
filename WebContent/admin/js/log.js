$(function(){
	//加载t_user表数据，在easyUI的datagrid控件中显示
	$('#tab').datagrid({
		url:'/webproject/log.do',
		iconCls:'icon-ok',
		queryParams:{type:'list'},
		loadMsg:'正在加载，请稍后......',
		singleSelect:true,
		collapsible:true,
		rownumbers:true,
		columns:[[
		          {
		        	  field:' adminid',title:'管理员'
		},{
			field:'done',title:'事件'
		},{
			field:'obj',title:'对象'
		},{
			field:'objid',title:'对象ID'
		},{
			field:'ddate',title:'时间'
		}]]
	})
	
})