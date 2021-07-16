<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
	$('#insertBtn').on('click', function() {
		$(location).attr('href','<%=request.getContextPath()%>/member/memberForm.do');
	})
})
</script>
</head>
<body>
<%
List<MemberVO> list = (List<MemberVO>)request.getAttribute("memList");
%>

	<h2>회원 목록 보기</h2>
	<table border="1">
	  <tr>
	    <td colspan="5">
	      <input type="button" value="회원 추가" id="insertBtn">
	    </td>
	  </tr>
	  <tr>
		<th>ID</th>
		<th>비밀번호</th>
		<th>이 름</th>
		<th>전화</th>
		<th>주소</th>
	  </tr>
<%
  if(list.size() < 1){
%>
	<tr>
	 <td colspan="5">회원이 존재하지 않습니다.</td>
	</tr>

<%
  }else{
	  
	for(MemberVO vo : list){
%>
	  <tr>
	    <td><a href="<%=request.getContextPath()%>/member/memberDetail.do?id=<%=vo.getMem_id()%>"><%=vo.getMem_id()%></a></td>
	    <td><%=vo.getMem_pass()%></td>
	    <td><%=vo.getMem_name()%></td>
	    <td><%=vo.getMem_tel()%></td>
	    <td><%=vo.getMem_addr()%></td>
	  </tr>
<%
	}
  }
%>
	</table>
</body>
</html>