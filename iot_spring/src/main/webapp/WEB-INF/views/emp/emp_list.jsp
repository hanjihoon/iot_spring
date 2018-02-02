<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>근로자 리스트</title>
</head>
<script>
	function send(url) {
		$.ajax({
			url : url,
			success : function(res) {
				var dataStr = "";
				var str = JSON.stringify(res);
				for (var i = 0; i < res.length; i++) {
					var data = res[i];
					dataStr += "<tr>";
					dataStr += "<td>" + data.empNo + "</td><td>" + data.empName
							+ "</td><td>" + data.empSal + "</td>";
					dataStr += "</tr>";
				}
				$("#tb").html(dataStr);
			}
		})
	}

	$(document).ready(function() {
		var go = new gridObj("resultDiv");
		send("${root}/emp/getlist");
	});
	
	function goView(url){
		var empNo = $("#empNo").html;
		alert(empNo);
		return;
		$.ajax({
			url : url,
			data: urlData,
			success : function(res) {
				var str = JSON.stringify(res);
				location.href="url";
			}
		})
	}
</script>
<body>
	직원 리스트
	<div class="container">
		<table border="1" class="table table-bordered table-inverse">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>월급</th>
			</tr>
			<tbody id="tb">
			</tbody>
		</table>
		<table border="1" class="table table-bordered table-hover table-sm">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>월급</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr onclick="goView('${root}/emp/view')" style="cursor:pointer;">
					<th id="empNo">${emp.empNo}</th>
					<th>${emp.empName}</th>
					<th>${emp.empSal}</th>
				</tr>
			</c:forEach>
		</table>
		<a href="${pPath}/emp/write"><button>사원정보</button></a>
	</div>
</body>
</html>