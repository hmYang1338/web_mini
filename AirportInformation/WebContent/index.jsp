<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- �ܺ� html ������ �� ������ �����ϴ� include ������ tag -->
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
            <label><i class="fa fa-calendar-o"></i> &nbsp&nbsp&nbsp&nbsp����� &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ������ <br>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select>
					<option value="inc">��õ</option>
				</select>
				 &nbsp&nbsp&nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
				<select name="area">
					�ݺ������� 
					<option value="�Ͻ��׸���" name="am">�Ͻ��׸���</option>
					am = �Ͻ��׸���
				</select>
			</label>
          </div>
          <div class="w3-half">
            <label><i class="fa fa-calendar-o"></i> ��� ��/�� <br>
				<select name="area">
					<option value="seoul">����&nbsp&nbsp &nbsp &nbsp &nbsp &nbsp</option>
				</select>
			</label>
          </div>
        </div>
        <div class="w3-row-padding" style="margin:0 -16px;">
          <div class="w3-half w3-margin-bottom">
            <label><i class="fa fa-calendar-o"></i>&nbsp&nbsp&nbsp&nbsp����� &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ������ <br>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<select>
					<option value="seoul">�Ͻ��׸���</option>
					<option value="seoul">�Ͻ��׸���</option>
					<option value="seoul">�Ͻ��׸���</option>
				</select>
				 &nbsp&nbsp&nbsp->&nbsp&nbsp&nbsp
				<select name="area">
					<option value="seoul">��õ</option>
				</select>
			</label>
          </div>
          <div class="w3-half">
            <label><i class="fa fa-calendar-o"></i> ���� ��/�� <br>
				<select name="area">
					<option value="seoul">����&nbsp&nbsp &nbsp &nbsp &nbsp &nbsp</option>
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