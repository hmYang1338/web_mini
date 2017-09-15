<%@page import="dao.DepartDAO"%>
<%@page import="dao.ArrivalDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.ArrivalDTO, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>index.jsp</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
</head>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<nav>
	<!-- 외부 html 파일을 이 영역에 포함하는 include 지시자 tag -->
 	<%@ include file="header.html" %>
</nav>

<!-- Header -->
<header class="w3-display-container w3-content" style="max-width:1500px;">
  <img class="w3-image" src="img/airport.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
  <div class="w3-display-left w3-padding w3-col l6 m8">
    <div class="w3-container w3-red">
      <h2>Flight Schedule</h2>
    </div>
    <div class="w3-container w3-white w3-padding-16">
      <form action="search.jsp" target="_blank">
        
        <div class="w3-row-padding" style="margin:0 -16px;">
          <div class="w3-half w3-margin-bottom">
            <label><i class="fa fa-calendar-o"></i> &nbsp&nbsp&nbsp&nbsp출발지 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 도착지 <br>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select>
					<option value="inc">인천</option>
				</select>
				 &nbsp&nbsp&nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
				 <% 
					List<String> list = DepartDAO.searchDepartAir();
					session.setAttribute("list", list);
				 %> 
				<select name="area">
					<c:forEach items="${sessionScope.list}" var="data" >
						<option value="seoul">${data.airport} &nbsp;</option>
					</c:forEach>
				</select>
			</label>
          </div>
          <div class="w3-half">
            <label><i class="fa fa-calendar-o"></i> 출발 일/시 <br>
				<% 
					List<String> list4 = DepartDAO.searchDepartDate();
					session.setAttribute("list4", list4);
				 %> 
				<select>
					<c:forEach items="${sessionScope.list4}" var="data" >
						<option>${data.airport} &nbsp;</option>
					</c:forEach>
				</select>			</label>
          </div>
        </div>
        <div class="w3-row-padding" style="margin:0 -16px;">
          <div class="w3-half w3-margin-bottom">
            <label><i class="fa fa-calendar-o"></i>&nbsp&nbsp&nbsp&nbsp출발지 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 도착지 <br>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<% 
					List<String> list2 = ArrivalDAO.searchArrivalAir();
					session.setAttribute("list2", list2);
				%>
				<select name="area">
					<c:forEach items="${sessionScope.list2}" var="data" >
						<option value="seoul">${data.airport} &nbsp;</option>
					</c:forEach>
				</select>
				 &nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
				<select name="area">
					<option value="seoul">인천</option>
				</select>
			</label>
          </div>
          <div class="w3-half">
            <label><i class="fa fa-calendar-o"></i> 도착 일/시 <br>
				<% 
					List<String> list3 = ArrivalDAO.searchArrivalDate();
					session.setAttribute("list3", list3);
				 %> 
				<select>
					<c:forEach items="${sessionScope.list3}" var="data" >
						<option>${data.airport} &nbsp;</option>
					</c:forEach>
				</select>
			</label>
          </div>
        </div>
        
        <button class="w3-button " type="submit"><i class="fa fa-search w3-margin-right"></i> Search availability</button>
      </form>
    </div>
  </div>
</header>

        

<!-- Footer -->
<footer class="w3-padding-32 w3-black w3-center w3-margin-top">
	<%@include file="footer.html" %>
</footer>


</body>
</html>