<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<c:if test="${pageNum !=0 }"><a href="mainAction.do?pageNum=${pageNum-1}">이전</a></c:if>
	<% 
			
	
	
			int paging = 10;
			int boardLen = (Integer)request.getAttribute("boardLen");
			int pageNum = (Integer)(request.getAttribute("pageNum"));
			
			int start = (pageNum/paging)*paging;
			int end = start+paging;
			int endPage = boardLen/paging+1;
			System.out.println("endPage : " + endPage);
			if(end >endPage){
				end =endPage;
			}
		
			for (int i=start; i<end;i++){
				%>
				
				<a href="mainAction.do?pageNum=<%=i%>"><span <% if(i==pageNum){
											%>   id="nowPage"    <% // 현재 있는 페이지를 표시해 주는 id
										} %>><%=i+1 %></span></a>
				
				<% 
				
			}
			
				if(pageNum != endPage-1){
			  %>
			  
				<a href="mainAction.do?pageNum=${pageNum+1}">다음</a>
		 	
		 	<% 
		 	}
	          %> 