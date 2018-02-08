<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>


</head>


<body>

	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h3 class="panel-title">User List</h3>
							</div>
							<div class="col col-xs-6 text-right">
								<input type="text" id="search" class="input">
								<button type="button" class="btn btn-sm btn-primary btn-create"
									onclick="searchuser()">검색</button>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<table id="userTable" data-key="uiNo"
							class="table table-info table-striped table-list table-bordered">
							<thead>
								<tr>
									<th class="text-center" data-field="uiNo">번호</th>
									<th class="text-center" data-field="uiName">이름</th>
									<th class="text-center" data-field="uiAge">나이</th>
									<th class="text-center" data-field="uiId">ID</th>
									<th class="text-center" data-field="address">주소</th>
									<th class="text-center" data-field="ciNo">반</th>
									<th class="text-center" data-field="BTN"><em
										class="glyphicon glyphicon-asterisk"></em></th>
								</tr>
							</thead>
							<tbody id="result_tb">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
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
	var au = new AjaxUtil("${root}/user/getlist", null, "GET", "json");
	function callback(res) {
		$("#userTable").bootstrapTable({
			data : res
		});
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
</html>