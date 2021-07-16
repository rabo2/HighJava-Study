<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 폼</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#memListBtn').on('click', function() {
		$(location).attr('href','<%=request.getContextPath()%>/member/memberList.do');
	});
	
	var oldMemberId = "";
	
	$('#idCheck').on('click',function() {
		var memId = $('#mem_id').val();
		if(memId == ''){
			alert("회원ID를 입력하세요");
			$('#mem_id').focus();
			return;
	}
	$.ajax({
		url : '<%=request.getContextPath()%>/member/memberCheck.do',
		data : {'mem_id' : memId},
		dataType : 'json',
		success : function(res) {
			if(res=="OK"){
				$('#idCheckResult').html("사용가능");
// 				$('#mem_id').prop('readOnly', true);
				oldMemberId = memId;
			}else{
				$('#idCheckResult').html("사용불가");					
			}
		},
		error : function(xhr) {
			alert(xhr.status);					
		}
		})
	});
	
	$('#mem_id').on('change', function() {
		$('#idCheckResult').empty();
	});
	
	//form에서 submit이벤트가 발생했을 때 처리
	$('#memberForm').on('submit', function() {
		//아이디 중복확인의 결과
		var idChk = $('#idCheckResult').text();
		
		if(idChk!="사용가능").val()){
			alert('ID가 중복되거나 중복체크를 하지 않았습니다.');
			return false;
		}
		
		if($('#mem_pass').val() == ""){
			alert("비밀번호를 입력하세요");
			return false;
		}

		if($('#mem_pass').val() != $('#mem_pass2').val()){
			alert('비밀번호가 일치하지 않습니다');
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
	<form id="memberForm" method="post" action="<%=request.getContextPath()%>/member/memberInsert.do">
		<table border="1">
			<tbody>
				<tr>
					<td>회원ID</td>
					<td>
					  <input type="text" id="mem_id" name="mem_id"> 
					  <input type="button" value="중복확인" id="idCheck"><br> 
					  <span id="idCheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="mem_pass" name="mem_pass">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="mem_pass2" name="mem_pass2">
					</td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td><input type="text" id="mem_name" name="mem_name">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="mem_tel" name="mem_tel"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="mem_addr" name="mem_addr"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					  <input type="submit" value="저장"> 
					  <input type="reset" value="취소">
					  <input type="button" value="회원 목록" id="memListBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>