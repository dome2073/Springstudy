<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>OpenProject</title>
</head>
<body>
<!-- 데이터가 컨트롤러로 감 - LoginController2 -->
<form action="login" method="post">
	아이디 <input type="text" name = id><br/>
	비밀번호 <input type=password" name="pw">
	<input type="submit" value="로그인">
</form>
</body>
</html>