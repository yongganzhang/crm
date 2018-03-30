

function openFeedBackDlg(){
	var rows= $("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录执行反馈!","info");
		return;
	}
	
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条记录执行反馈!","info");
		return;
	}
	
	$("#fm").form("load",rows[0]);
	$("#dlg").dialog("open").dialog("setTitle","服务反馈");
}



function addCustomerServeServiceFeedBack(){
	$("#fm").form("submit",{
		url:ctx+"/server/update",
		onSubmit:function(params){
		params.state="5";
		   return 	$("#fm").form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.code==200){
				$("#dlg").dialog("close");
				$("#dg").datagrid("load");
			}else{
				$.messager.alert("来自crm",data.msg,"info");
			}
		}
	});
}