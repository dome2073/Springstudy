<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="submitReport1" method="post" enctype="multipart/form-data">
	학번 <input type="text" name="studentNumber"> <br>
	이름 <input type="text" name="studentName"> <br>
	리포트 파일 <input type="file" name="report"> <br>
	<input type="submit">
</form>

<hr>

<form action="submitReport2" method="post" enctype="multipart/form-data">
	학번 <input type="text" name="studentNumber"> <br>
	이름 <input type="text" name="studentName"> <br>
	리포트 파일 <input type="file" name="report"> <br>
	<input type="submit">
</form>



<hr>

<form action="submitReport3" method="post" enctype="multipart/form-data">
	학번 <input type="text" name="studentNumber"> <br>
	이름 <input type="text" name="studentName"> <br>
	리포트 파일 <input type="file" name="report"> <br>
	<input type="submit">
</form>









</body>
</html>