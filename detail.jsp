<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>

		<c:set var="v" value="${board}"  />
<h3>${v.writer} 님의 글</h3>

<div id="content">


<form method="post" action="updateBoard.do" id="form1">
<table border="1">
<tr bgcolor='lightgreen'>
	<td>글 번호 </td><td>글 제목 </td><td>글 작성자 </td><td> 글 내용</td>
</tr>
		<tr>
		
		<td><a href="detail.do?id=${v.id}"><input type="text" value="${v.id}" name="id"readonly ></a></td>
		<td><input type="text" value="${v.title}" name="title"readonly></td>
		<td><input type="text" value="${v.writer}" name ="writer"readonly></td>
		<td><input type="text" value="${v.content}" name="content" readonly></td>
			
		</tr>
	
</table>


	</form>
	<br>
	
	</div>
	<br>
	<c:if test="${v.writer eq member.id }">
	<div id="updateMenu">
	<button onclick="updateMode()">수정하기</button>
	
	
	<button onclick="deleteBoard()">삭제하기</button>
	</div>
</c:if>

&nbsp; <a href="mainAction.do"> 메인 페이지 가기</a>
<script type="text/javascript">
	function deleteBoard(){
		var isDelete = confirm('정말로 삭제하시겠습니까?');
		if(isDelete){
			location.href="deleteBoard.do?id="+${v.id};
		}else {
			return;
		}
		
		
	}
	function update(){
		console.log("확인");
		$("#form1").submit();
		
	}
	function updateMode(){
		var updateBtn = document.createElement('button');  // 새로운 버튼을 만드는 코드 
		var updateBtnText = document.createTextNode("수정 완료");
		updateBtn.appendChild(updateBtnText);
		updateBtn.setAttribute('onclick','update()');	
		
		
		$("input[name=title]").prop("readonly", false);  //readonly 해제 코드
		$("input[name=content]").prop("readonly", false);
		
		var content = document.getElementById("content");
		content.appendChild(updateBtn); // 해당 게시글이 있는 div의 자식 요소에 버튼을 추가!
	}
		
		
		
		
		

</script>


</body>
</html>