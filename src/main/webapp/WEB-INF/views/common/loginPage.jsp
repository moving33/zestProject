<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

<!-- 부트스트랩 CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<c:if test="${result == 'noEmail' }">
		<script>
			alert("해당 이메일은 존재하지 않습니다.");
		</script>
	</c:if>
	<c:if test="${result == 'false' }">
		<script>
			alert("비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	<c:if test="${result == 'success' }">
		<script>
			opener.document.location.reload();
			window.close();
		</script>
	</c:if>
	<br>
	<center>
		<h5>
			<label style="color: #ff7200;"><b>드루와</b></label><b>에 오신 것을 환영해요!</b>
		</h5>
		<label style="font-size: 14px;">드루와는 서로 간의 재능을 연결해<br>모두의
			경쟁력을 높이는 플랫폼 서비스 입니다.
		</label>
	</center>

	<form action="/zest/common/loginPage" method="post">
		<div class="form-group">
			<input type="email" class="form-control" id="email" name="cl_email"
				aria-describedby="emailHelp" placeholder="Enter email">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pass" name="cl_pass"
				placeholder="Password">
		</div>
		<div class="form-group form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">로그인 상태 유지</label>
		</div>
		<br>
		<button type="submit" class="btn btn-dark btn-lg btn-block">이메일
			아이디로 로그인</button>
	</form>
</body>
</html>