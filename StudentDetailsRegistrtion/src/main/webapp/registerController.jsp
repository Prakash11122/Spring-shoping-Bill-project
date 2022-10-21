<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.st.dao.StudentDAO ,com.st.model.Mark , com.st.model.Student, com.st.utils.ConnectionProvider , java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Mark marks = new Mark();
Student student = new Student();
Connection con = null;

String name = request.getParameter("sname");
String regn = request.getParameter("sroll");
String phone = request.getParameter("phone");
String address = request.getParameter("addr");

int m1 = Integer.parseInt(request.getParameter("m1"));
int m2 = Integer.parseInt(request.getParameter("m2"));
int m3 = Integer.parseInt(request.getParameter("m3"));
int m4 = Integer.parseInt(request.getParameter("m4"));

marks.setM1(m1);
marks.setM2(m2);
marks.setM3(m3);
marks.setM4(m4);
marks.setTotalMarks(m1 + m2 + m3 + m4);
marks.setPercentage((m1 + m2 + m3 + m4) / 4);

student.setName(name);
student.setSid(regn);
student.setMobile(phone);
student.setAddr(address);
student.setMark(marks);

StudentDAO dao = new StudentDAO();
try {
	boolean sts = dao.registerStudent(student);
	if (sts == true) {
		HttpSession ss = request.getSession();
		ss.setAttribute("suc-msg", "Student details saved successfully...");
	} else {
		HttpSession ss = request.getSession();
		ss.setAttribute("err-msg", "Something gone wrong on server!!!");
	}
	response.sendRedirect("register.jsp");
} catch (Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>