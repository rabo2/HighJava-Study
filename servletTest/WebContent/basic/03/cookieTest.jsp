<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 연습</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/CookieAdd.do">Cookie 정보 저장하기</a>
	<a href="<%=request.getContextPath()%>/CookieRead.do">저장된 Cookie 정보 확인하기</a>
	<a href="<%=request.getContextPath()%>/CookieDelete.do">저장된 Cookie 정보 삭제하기</a>
	
</body>
</html>