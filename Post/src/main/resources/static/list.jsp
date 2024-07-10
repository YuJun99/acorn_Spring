<%@page import="com.example.post.dao.PostDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.example.post.dto.PostDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PostDao dao = new PostDao();
	List<PostDto> list = new ArrayList<>();
	List<PostDto> dto = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/list.jsp</title>
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody>
				<%for(PostDto tmp:dto) %>
				<tr>
					<td>${tmp.getId }</td>
					<td>${tmp.getTitle }</td>
					<td>${tmp.getAuthor }</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>