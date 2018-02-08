<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }      
    div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
</style>
<script>
var bodyLayout, aLay, bLay, cLay, dbTree;
function callback(res){

   dbTree = aLay.attachTreeView({
       items: res.dbList
   });
   dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web/");
   dbTree.enableDragAndDrop(true);
}
dhtmlxEvent(window,"load",function(){
   bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
   aLay = bodyLayout.cells("a");
   bLay = bodyLayout.cells("b");
   aLay.setWidth(300);
   aLay.setText("Connection Info List");
   var aToolbar = aLay.attachToolbar();
   aToolbar.addButton("adddb",1,"add Connector");
   aToolbar.addButton("condb",2,"Connection");
   aToolbar.attachEvent("onClick",addDB)
   var au = new AjaxUtil("${root}/connection/db_list",null,"get");
   au.setCallbackSuccess(callback);
   au.send(); 
})

$(document).ready(function(){
	$("#header").attr("style","display:none")
})
var url = "${root}/connection/insert";
var type = "post";
	var winF, popW;
	function addDB(url,type) {
		popW = bLay.createWindow("win1", 20, 30, 200, 300);
		popW.hide();
		popW.setText("Add Connection Info");

		//var setting = {type:"settings", position:"label-left", labelWidth:100, inputwidth:120};
		var formObj = [ {
			type : "settings",
			offsetTop : 12,
			name : "connectionInfo",
			labelAlign : "left"
		}, {
			type : "input",
			name : "ciName",
			label : "커넥션",
			required : true
		}, {
			type : "input",
			name : "ciUrl",
			label : "접속URL",
			required : true
		}, {
			type : "input",
			name : "ciPort",
			label : "포트",
			validate : "ValidInteger",
			required : true
		}, {
			type : "input",
			name : "ciDatabase",
			label : "데이타베이스",
			required : true
		}, {
			type : "input",
			name : "ciUser",
			label : "유저",
			required : true
		}, {
			type : "input",
			name : "ciPwd",
			label : "비밀번호",
			required : true
		}, {
			type : "input",
			name : "ciEtc",
			label : "기타"
		}, {
			type : "block",
			blockOffset : 0,
			list : [ {
				type : "button",
				name : "saveBtn",
				value : "저장"
			}, {
				type : "newcolumn"
			}, {
				type : "button",
				name : "cancelBtn",
				value : "취소"
			} ]
		}

		];


		var form = popW.attachForm(formObj, true);

		form.attachEvent("onButtonClick", function(id) {
			if (id == "saveBtn") {
				if(form.validate()){
					form.send(url,type,collback);
				}
			} else if (id == "cancelBtn") {
				form.clear();
			}
		})
	};
	
	function collback(loader, res){
		var res = JSON.parse(res);
		alert(res.msg);
		form.clear();
	}

</script>
<body>

</body>
</html>