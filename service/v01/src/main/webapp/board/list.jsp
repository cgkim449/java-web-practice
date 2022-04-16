<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.List" %>
<%@ page import="spms.vo.Board" %>
<%@ page import="spms.dao.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Board> boardList = ((BoardDao)application.getAttribute("boardDao")).selectList();
		pageContext.setAttribute("boardList", boardList);
	%>
	<table border="1">
	<tr>
	  <th>카테고리</th>
	  <th></th>
	  <th>제목</th>
	  <th>작성자</th>
	  <th>조회수</th>
	  <th>등록 일시</th>
	  <th>수정 일시</th>
	</tr>
	<c:forEach var="board" items="${boardList}">
	<tr>
	  <td>${board.categoryName}</td>
	  <td><c:if test="${!empty board.attachList}">1</c:if></td>
	  <td>${board.title}</td>
	  <td>${board.writer}</td>
	  <td>${board.viewcnt}</td>
	  <td>${board.regdate}</td>
	  <td>${board.moddate}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>