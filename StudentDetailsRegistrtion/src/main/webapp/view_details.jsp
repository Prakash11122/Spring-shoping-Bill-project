<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.st.dao.StudentDAO ,com.st.model.Mark , com.st.model.Student, com.st.utils.ConnectionProvider , java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<%
	String regnNo = request.getParameter("regnNo");
	StudentDAO dao = new StudentDAO();
	Student student = dao.getDetails(regnNo);
	Mark marks = student.getMark();
	%>
	<center>
		<H1>Student Details</H1>
		<table>
			<tr>
				<td>Name</td>
				<td>Regn. No</td>
				<td>Mobile</td>
				<td>Address</td>
				<td>Subject1</td>
				<td>Subject2</td>
				<td>Subject3</td>
				<td>Subject4</td>
				<td>Total</td>
				<td>Percentage</td>
			</tr>
			<tr>
				<td><%=student.getName()%></td>
				<td><%=student.getSid()%></td>
				<td><%=student.getMobile()%></td>
				<td><%=student.getAddr()%></td>
				<td><%=marks.getM1()%></td>
				<td><%=marks.getM2()%></td>
				<td><%=marks.getM3()%></td>
				<td><%=marks.getM4()%></td>
				<td><%=marks.getTotalMarks()%></td>
				<td><%=marks.getPercentage()%></td>
			</tr>
		</table>
	</center>
</body>
</html>