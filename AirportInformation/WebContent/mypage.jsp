<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ import="beans.*", "dao.*" %> 

<%
	UserBean dto = (UserBean)request.getAttribute("dto");
	session.setAttribute("dto", dto);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>mypage.jsp</title>
</head>
<body>
	<a href="update.jsp">ȸ������ ����</a>
	<a href="delete.jsp">ȸ�� Ż��
	</a>
</body>
</html>