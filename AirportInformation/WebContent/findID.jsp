<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아이디/비밀번호 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
.cancelbtn {
    padding: 14px 20px;
    background-color: #ffffff;
}
.cancelbtn,.signupbtn {float:left;width:50%}
.container {
    padding: 16px;
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
    right: 35px;
    top: 15px;
    color: #000;
    font-size: 40px;
    font-weight: bold;
}
.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}
/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
</head>

<body class="w3-light-grey">
	<nav>
		<div class="w3-bar w3-white w3-large">
			<a href="index.jsp" class="w3-bar-item w3-button w3-red w3-mobile">Main</a>
		</div>
	</nav>
	<div class="w3-container w3-center">
		<form class="modal-content animate" action="user" method="post">
			<input type="hidden" value="login" name="command">
			<div class="imgcontainer">
				<img src="img_avatar2.png" alt="Find Password" class="avatar">
			</div>

			<div class="container">
				<label><b>User ID</b></label>
				<input type="text" placeholder="Enter Userid" name="id" required>

				<label><b>EMAIL</b></label>
				<input type="text" placeholder="Enter EMAIL" name="email" required>
        
				<div class="container" style="background-color:#ffffff">
					<button type="submit" class="loginbtn">찾기</button>
				</div>
			</div>
		</form>
	</div>
</body>

</html>