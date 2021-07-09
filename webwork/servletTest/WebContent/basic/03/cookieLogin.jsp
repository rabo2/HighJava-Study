<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>

<%
String idCookie = "";
Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length != 1){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("id")){
			idCookie = cookie.getValue();
		}
	}
}
%>
	<form name = "loginForm" method="post" action="<%=request.getContextPath()%>/CookieLogin.do">
	ID : <input type="text" placeholder="ID 입력" name = "id" value=<%=idCookie %>>
	<br>
	PASS : <input type="password" name = "pass" placeholder="PaassWord 입력" >
	<br>
	<input type="checkbox" name="check" value = "check"
	<%
	if(idCookie.length() > 1){
		out.print(" checked");
	}
	%>
	>id 기억하기
	<br>
	<input type="submit" value="Login">
	</form>
</body>
</html>