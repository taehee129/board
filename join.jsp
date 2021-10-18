<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="insertMember.do" method="post">
<table border ="1">
<tr>
<td>아이디</td>
<td><input type="text" name="id"></td>

</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="text" name="password"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="name"></td>

</tr>

<tr>
	<input type="submit" value="회원가입하기">

</tr>

</table>
</form>





</body>
</html>