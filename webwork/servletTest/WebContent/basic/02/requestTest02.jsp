<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Request 연습 Form(숫자 입력은 정수형으로 입력하시오)</h2>
<!--   <form method="post" action="/servletTest/RequestTest02.do"> -->
  <form method="post" action="<%=request.getContextPath()%>/RequestTest02.do">
    <table>
      <tr>
        <td>
          <input type="text" size="10" name="num1">
        </td>
		<td>
		  <select name="op">
		    <option value="+">+</option>
		    <option value="-">-</option>
		    <option value="*">*</option>
		    <option value="/">/</option>
		    <option value="%">%</option>
		  </select>
		</td>
        <td>
          <input type="text" size="10" name="num2">
        </td>
        <td>
          <input type="submit" value="확인">
        </td>
      </tr>
    </table>
  </form>
  <!--
  	위 화면에서 숫자 2개를 입력하고 연산자를 선택한후 
  	'확인'버튼을 누르면 해당 연산자에 맞는 계산을  다음과 같이 출력하는
  	서블릿을 작성하시오
  	
  	출력예시)
  	30 / 3 = 10.0
   -->
</body>
</html>