<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lprod출력 연습</title>
<style>
t1{
	width: 300px;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/basic/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#lprodBtn').on('click', function() {
		$.ajax({
			url : '<%=request.getContextPath() %>/LprodServlet.do',
			type : 'post',
			success : function(data) {
				code = "<table border = '1' id = 't1'>";
				code += "<tr>"
				      +   "<td>"
					  +    "Lprod_id"
				      +   "</td>"
				      +   "<td>"
					  +    "Lprod_gu"
				      +   "</td>"
				      +   "<td>"
					  +    "Lprod_nm"
				      +   "</td>"
					  + "</tr>";
					  
				$.each(data, function(i, v) {
					code += "<tr>"
						   +"  <td>"
						   + 	v.lprod_id
						   +"  </td>"
						   +"  <td>"
						   + 	v.lprod_gu
						   +"  </td>"
						   +"  <td>"
						   + 	v.lprod_nm
						   +"  </td>"
						   +"</tr>";
				});
				code += "</table>";
				$('#rst').html(code);
			},
			error: function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json'
		});
	});
})
</script>
</head>
<body>
  <form>  
    <input type="button" id="lprodBtn" value="lprod자료 가져오기">
  </form>
  <hr>
  <h2>Lprod 자료 츌력</h2>
  <div id="rst"></div>
</body>
</html>