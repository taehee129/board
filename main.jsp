<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.*, java.util.*"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#nowPage{
	color : red;
}

</style>

</head>


<body>

<h1>글  목록 </h1>

<table border="1">
<tr>
	<td>글 번호 </td><td>글 제목 </td><td>글 작성자 </td><td> 글 내용</td>
</tr>
	<c:forEach var="v" items="${boardList}">
		<tr>
		
		<td><a href="detail.do?id=${v.id}">${v.id}<a></a></td><td>${v.title}</td><td>${v.writer}</td><td>${v.content }</td>
		
		</tr>
	
	
	
	
	</c:forEach>
	
</table>
<br>
	<mytag:paging/> &nbsp;
<a href="insertBoard.jsp">글 작성</a> &nbsp;
<a href="logout.do"> 로그아웃</a>
</body>
</html>