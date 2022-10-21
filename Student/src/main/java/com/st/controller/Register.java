package com.st.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.dao.StudentDAO;
import com.st.model.Mark;
import com.st.model.Student;
import com.st.utils.ConnectionProvider;

@WebServlet("/Register")
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Mark marks = new Mark();
		Student student = new Student();
		Connection con = null;

		String name = request.getParameter("sname");
		String regn = request.getParameter("sroll");

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
