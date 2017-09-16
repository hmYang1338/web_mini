<%@page import="dao.DepartDAO, dao.ArrivalDAO, java.util.List, beans.ArrivalBean, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>인천국제공항 기준 - 출/입국 </title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
</head>

<body class="w3-light-grey">
	<nav>
		<div class="w3-bar w3-white w3-large">
			<a href="index.jsp" class="w3-bar-item w3-button w3-red w3-mobile">Main</a>
			<a href="add.jsp" class="w3-bar-item w3-button w3-right w3-mobile">SignUp</a> 
			<a href="login.jsp" class="w3-bar-item w3-button w3-right w3-mobile">Login</a>
		</div>
	</nav>
	
	<header class="w3-display-container w3-content" style="max-width:1500px;">
		<img class="w3-image" src="img/airport.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
		<div class="w3-display-left w3-padding w3-col l6 m8">
			<div class="w3-container w3-red">
				<h2>Flight Schedule</h2>
			</div>
			<div class="w3-container w3-white w3-padding-16">
				<form action="booking" target="_blank" >
					<div class="w3-row-padding" style="margin:0 -16px;">
						<div class="w3-half w3-margin-bottom">
							<label><i class="fa fa-calendar-o"></i> &nbsp&nbsp&nbsp&nbsp출발지 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 도착지 <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<select>
								<option value="inc">인천</option><!-- default -->
							</select>&nbsp&nbsp&nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
								<% 
									List list = DepartDAO.searchDepartAir();
									session.setAttribute("list", list);
								%> <!-- 목적지 리스트 -->
							<select name="departList" id="depart_selectEle">
								<c:forEach items="${sessionScope.list}" var="data" >
									<option value="">${data.airport} &nbsp;</option>
								</c:forEach>
							</select>
							</label>
						</div>
						<div class="w3-half">
							<label><i class="fa fa-calendar-o"></i> 출발 일/시 <br>
								<% 
									List list4 = DepartDAO.searchDepartDate();
									session.setAttribute("list4", list4);
								%> <!-- 인천에서 목적지로 출발하는 일/시 -->
							<select name="departDate">
								<c:forEach items="${sessionScope.list4}" var="data" >
									<option value="">${data.airport} &nbsp;</option>
								</c:forEach>
							</select>			
							</label>
						</div>
					</div>
					<div class="w3-row-padding" style="margin:0 -16px;">
						<div class="w3-half w3-margin-bottom">
							<label><i class="fa fa-calendar-o"></i>&nbsp&nbsp&nbsp&nbsp출발지 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 도착지 <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<% 
									List<String> list2 = ArrivalDAO.searchArrivalAir();
									session.setAttribute("list2", list2);
								%> <!-- 출발지 리스트 -->
							<select name="arrivalList" id="arrival_selectEle">
								<c:forEach items="${sessionScope.list2}" var="data" >
									<option value="">${data.airport} &nbsp;</option>
								</c:forEach>
							</select>&nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
							<select>
								<option value="seoul">인천</option><!-- default -->
							</select>
							</label>
						</div>
						<div class="w3-half">
							<label><i class="fa fa-calendar-o"></i> 도착 일/시 <br>
								<% 
									List list3 = ArrivalDAO.searchArrivalDate();
									session.setAttribute("list3", list3);
								%> <!-- 출발지에서 인천으로 도착하는 일/시 -->
							<select name="arrivalDate">
								<c:forEach items="${sessionScope.list3}" var="data" >
									<option value="">${data.airport} &nbsp;</option>
								</c:forEach>
							</select>
							</label>
						</div>
					</div>
					<button class="w3-button" type="submit"><i class="fa fa-search w3-margin-right"></i> 검색 </button>
				</form>
			</div>
		</div>
	</header>
</body>
</html>

<script>
var depart_selectEle = document.getElementById("depart_selectEle");
var arrival_selectEle = document.getElementById("arrival_selectEle");

depart_selectEle.addEventListener('change', function(event) {
	console.log("depart_selectEle onChange Envent : ", event);
	arrival_selectEle.selectedIndex = this.selectedIndex;
	
}, false);
arrival_selectEle.addEventListener('change', function(event) {
	console.log("arrival_selectEle onChange Envent : ", event);
	depart_selectEle.selectedIndex = this.selectedIndex;
}, false);
</script>