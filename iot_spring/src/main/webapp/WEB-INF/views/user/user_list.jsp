<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>


</head>


<body>
	<div id="gridbox" style="width:410px;height:400px;"></div>

<script>

function updateUser(uiNo){
	var uiName = $("#uiName" + uiNo).val().trim();
	var uiAge = $("#uiAge" + uiNo).val().trim();
	var address = $("#address" + uiNo).val().trim();
	var ciNo = $("#sel" + uiNo).val();
	var param={uiNo:uiNo, uiName:uiName, uiAge:uiAge, address:address, ciNo:ciNo};
	param = "param=" + JSON.stringify(param);
	$.ajax({
		url : '/user/update',
		data : param,
		type : 'post',
		dataType:'json',
		success:function(res){
			alert(res.msg);
			if(res.result=='ok'){
				location.reload();
			}
		},
		error:function(xhr,status,error){
		}
	})
}

function deleteUser(uiNo){
	var isDelete = confirm("진짜 지울라고???");
	var param = "uiNo=" + uiNo;
	if(isDelete){
		$.ajax({
			url : '/user/delete',
			data : param,
			type : 'post',
			dataType:'json',
			success:function(res){
				alert(res.msg);
				if(res.result=='ok'){
					location.reload();
				}
			},
			error:function(xhr,status,error){
			}
		})
	}
}

$(document).ready(function(){
	var mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("${dPath}/imgs/");
	mygrid.setHeader("번호,이름,나이,아이디,주소,반");
	mygrid.setInitWidths("50,80,50,150,100,50");
	mygrid.setColAlign("left,left,left,left,left,left");
	mygrid.setColTypes("ro,ed,ed,ro,ed,ed");
	mygrid.setColSorting("int,str,int,str,str,int");
	mygrid.setColumnIds("uiNo,uiName,uiAge,uiId,address,ciNo");
	mygrid.init();
	
	
	var au = new AjaxUtil("${root}/user/getlist", null, "GET", "json");
	function callback(res) {
		mygrid.parse({data:res},"js");
	}
	au.setCallbackSuccess(callback);
	au.send();
});

function searchuser(){
	var colsinfo = [];
	var colList = $("#grid1 th[data-field]");
	for(var i=0;i<colList.length;i++){
	colsinfo.push(colList[i].getAttribute("data-field"));
	}
	var keyCol = $("#grid1").attr("data-key");
	var param = "str=" + $("#search").val();
	$.ajax({
		url : '/user/user',
		type : 'get',
		data : param,
		success:function(res){
			alert(res);
			var list = JSON.parse(res);
			var str ="";
			for(var uc of list.us){
				var key = uc[keyCol];
				str += "<tr>";
				for(var field of colsinfo){
					str += "<td class='text-center'>";
					if(field=="BTN"){
						str += '<a class="btn btn-default" onclick="updateUser(' + key + ')"><em class="glyphicon glyphicon-pencil"></em></a>';
						str += '<a class="btn btn-danger" onclick="deleteUser(' + key + ')"><em class="glyphicon glyphicon-trash"></em></a>';
					}else{
						var colName = field.split(",")[0];
						var colType = field.split(",")[1];
						if(colType=="ro"){
							str += uc[colName];
						}else if(colName=="ciNo"){
							str += "<select id='sel" + key + "' >";
							for(var c of list["cl"]){
							if(c.ciNo==uc[colName]){
								str += "<option value='" + c.ciNo + "'>" + c.ciName + "</option>";
							}
						}	
							for(var c of list["cl"]){
								if(c.ciNo!=uc[colName]){
									str += "<option value='" + c.ciNo + "'>" + c.ciName + "</option>";
								}
						}
							str += '</select>';
						}else{						
						str += "<input type='text' class='text-center' style='border-style:inset; width:100px;' id='"+colName + key + "' value='" + uc[colName] + "'>";
						}
					}
					str += "</td>";
				}
				str += "</tr>";
			}
			$("#result_tb").html(str);
		},
		error:function(xhr,status,error){	
		}
	})
}
</script>
</body>
</html>