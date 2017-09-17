<%@page import="dao.ArrivalDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="beans.DepartBean, beans.ArrivalBean, service.AircraftService, java.util.*, dao.DepartDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>항공권 검색</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
</head>

<body class="w3-light-grey">
	<div class="w3-bar w3-white w3-large">
		<a href="index.jsp" class="w3-bar-item w3-button w3-red w3-mobile">Main</a>
		<a href="add.jsp" class="w3-bar-item w3-button w3-right w3-mobile">SignUp</a>
		<a href="login.jsp" class="w3-bar-item w3-button w3-right w3-mobile">Login</a>
	</div>

	<div class="w3-container">
	<h2>출발편 항공정보 (인천공항 기준)</h2>
		<table class="w3-table w3-striped w3-bordered">
			 <tr>
				<th>편명</th>
				<th>출발 일/시</th>
				<th>항공사</th>
				<th>도착지</th>
			</tr>
			<% 
				List allList = DepartDAO.getDepart();
				session.setAttribute("allList", allList);
			%>
			<c:forEach items="${sessionScope.allList}" var="data">
				<tr>
					<td>${data.DFlightID}</td>
					<td>${data.DScheduledateTime}</td>
					<td>${data.airline}</td>
					<td>${data.airport}</td>
				</tr>
			</c:forEach>
		</table>
		<br><hr><br>
		
		<h2>도착편 항공정보 (인천공항 기준)</h2>
		<table class="w3-table w3-striped w3-bordered">
			<tr>
				<th>편명</th>
				<th>출발 일/시</th>
				<th>항공사</th>
				<th>출발지</th>
			</tr>
			<% 
				List allList2 = ArrivalDAO.getArrival();
				session.setAttribute("allList", allList2);
			%>
			<c:forEach items="${sessionScope.allList}" var="data">
				<tr>
					<td>${data.AFlightID}</td>
					<td>${data.AScheduledateTime}</td>
					<td>${data.airline}</td>
					<td>${data.airport}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>