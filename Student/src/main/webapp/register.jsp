<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.st.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String stsMsg = (String)session.getAttribute("suc-msg");
	if(stsMsg != null){
	%>
	<center>
		<p><%= stsMsg %></p>
	</center>
	<%
		}
		String errMsg = (String)session.getAttribute("err-msg");
		if(stsMsg != null)
			%>
	<center>
		<p><%= errMsg %></p>
	</center>
	<%
					session.removeAttribute("suc-msg");
					session.removeAttribute("err-msg");
	%>
		<center>
		<h1>Student Details Registration Form</h1>
		<form action="registerStudent" method="post">
			Student Name <br> <input type="text" name="sname"><br>
			Registration number <br> <input type="text" name="sroll"><br>
			Phone number <br> <input type="text" name="phone"><br>
			Address <br> <input type="text" name="addr"><br>
			Mark 1<br> <input type="text" name="m1"><br> 
			Mark 2<br> <input type="text" name="m2"><br> 
			Mark 3 <br> <input type="text" name="m3"><br>
			Mark 4 <br> <input type="text" name="m4"><br>
			<br> <input	type="submit" value="Register"><br>
		</form>
</body>
</html>