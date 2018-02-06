<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var au = new AjaxUtil("${root}/emp/getlist", null, "GET", "json");
	function callback(res) {
		$("#empTable").bootstrapTable({
			data : res
		});
	}
	au.setCallbackSuccess(callback);
	au.send();
</script>

<body>
	<div class="container">
		직원 리스트
		<table data-toggle="table" id="empTable">
			<thead>
				<tr>
					<th data-field="empNo">번호</th>
					<th data-field="empName">이름</th>
					<th data-field="empSal">월급</th>
				</tr>
			</thead>
		</table>
		<a href="${pPath}/emp/write"><button>사원정보</button></a>
	</div>
</body>
</html>