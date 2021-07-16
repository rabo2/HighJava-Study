<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
$(function() {
	$('#listBtn').on('click', function() {
		$(location).attr('href','<%=request.getContextPath()%>/member/memberList.do');
	});
	
	$('#updateBtn').on('click', function() {
		$('#memberForm').attr('action', '<%=request.getContextPath()%>/member/updateForm.do');
		$('#memberForm').submit();
	});
	
	$('#deleteBtn').on('click', function() {
		$('#memberForm').attr('action', '<%=request.getContextPath()%>/member/memberDelete.do');
		$('#memberForm').submit();			
	});
})
</script>
<style>
	table {
	  width: 300px;
	}
	form{
		display: inline-block;
	}
</style>
</head>
<body>
<%
MemberVO vo = (MemberVO)request.getAttribute("detail");
%>
  <h2>회원 정보 상세보기</h2>
<form id="memberForm">
 <input type="hidden" name = "memId" value="<%=vo.getMem_id()%>">
  <table border="1">
  <tr>
	<td>회원ID</td>
	<td id="memId"><%=vo.getMem_id()%></td>
  </tr>
  <tr>
	<td>비밀번호</td>
	<td><%=vo.getMem_pass()%></td>
  </tr>
  <tr>
	<td>회원이름</td>
	<td><%=vo.getMem_name()%></td>
  </tr>
  <tr>
	<td>전화번호</td>
	<td><%=vo.getMem_tel()%></td>
  </tr>
  <tr>
	<td>회원주소</td>
	<td><%=vo.getMem_addr()%></td>
  </tr>
  <tr>
    <td colspan="2">
      <input type="button" value="수정" id="updateBtn">
      <input type="button" value="삭제" id="deleteBtn">
      <input type="button" value="회원목록" id="listBtn">
    </td>
  </tr>
 </table>
</form>

</body>
</html>