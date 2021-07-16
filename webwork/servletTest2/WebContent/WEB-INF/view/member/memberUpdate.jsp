<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#list').on('click', function() {
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	});
	
	$('#memberForm').on('submit', function() {
		//아이디 중복확인의 결과
		if($('#mem_pass').val() == ""){
			alert("비밀번호를 입력하세요");
			return false;
		}

		if($('#mem_name').val() == ""){
			alert("이름를 입력하세요");
			return false;
		}

		if($('#mem_tel').val() == ""){
			alert("전화번호를 입력하세요");
			return false;
		}

		if($('#mem_addr').val() == ""){
			alert("주소를 입력하세요");
			return false;
		}
		
		return true;
		
	});
})
</script>
</head>
<body>
<%
 String memId = request.getParameter("memId");
%>

  <h2>회원 정보 수정 폼</h2>
  <form id="memberForm" method="post" action="<%=request.getContextPath()%>/member/memberUpdate.do">
    <input type="hidden" name = "mem_id" value="<%=memId%>">
	<table border="1">
	  <tr>
		<td>회원ID</td>
		<td id="memId"><%=memId%></td>
	  </tr>
	  <tr>
		<td>비밀번호</td>
		<td><input type="password" name = "mem_pass"></td>
	  </tr>
	  <tr>
		<td>회원이름</td>
		<td><input type="text" name = "mem_name"></td>
	  </tr>
	  <tr>
		<td>전화번호</td>
		<td><input type="text" name ="mem_tel"></td>
	  </tr>
	  <tr>
		<td>회원주소</td>
		<td><input type="text" name="mem_addr"></td>
	  </tr>
	  <tr>
	    <td colspan="2">
	      <input type="submit" value="저장" id="update">
	      <input type="reset" value="취소">
	      <input type="button" value="회원목록" id="list">
	    </td>
	  </tr>
	</table>
</form>
</body>
</html>