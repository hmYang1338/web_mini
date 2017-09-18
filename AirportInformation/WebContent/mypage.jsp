<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="beans.*"%> 
<%@ page import="dao.*"%> 

<%
	UserBean dto = (UserBean)request.getAttribute("dto");
	session.setAttribute("dto", dto);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>마이페이지</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: #ffffff;
    color: red;
    padding: 14px 20px;
    margin: 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
button:hover {
    opacity: 0.8;
}
.cancelbtn,.loginbtn {float:left;width:50%}
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}
img.avatar {
    width: 40%;
    border-radius: 50%;
}
.container {
    padding: 40px;
}
span.psw {
    float: right;
    padding-top: 16px;
}
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}
.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}
@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body class="w3-light-grey">
	<nav>
		<div class="w3-bar w3-white w3-large">
			<a href="index.jsp" class="w3-bar-item w3-button w3-red w3-mobile">Main</a>
			<a href="delete.jsp" class="w3-bar-item w3-button w3-right w3-mobile">Delete</a>
			<a href="update.jsp" class="w3-bar-item w3-button w3-right w3-mobile">Update</a> 
		</div>
	</nav>

<div class="w3-container w3-center">
	<form class="modal-content animate" action="user" method="post" >
		<input type="hidden" name="command" value="join" >
		<div class="imgcontainer">
					<img alt="Congraturation! Add to your Info." class="avatar">

				</div>
		<div class="container">
			<label><b>Id</b></label>
			<input type="text" value="<%=dto.getId()%>" name="id" " style="text-align: center" required>

			<label><b>Password</b></label>
			<input type="text" value="<%=dto.getPwd()%>" name="pwd" style="text-align: center" required>
      
			<label><b>Name</b></label>
			<input type="text" value="<%=dto.getName()%>" name="name" style="text-align: center" required>

			<label><b>Email</b></label>
			<input type="text" value="<%=dto.getEmail()%>" name="email" style="text-align: center" required>
      
			
		</div>
	</form>
</div>
	
</body>
</html>