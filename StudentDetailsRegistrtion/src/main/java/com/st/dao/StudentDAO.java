package com.st.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.st.model.Mark;
import com.st.model.Student;
import com.st.utils.ConnectionProvider;

public class StudentDAO {
	Connection con;
	public boolean registerStudent(Student student) throws SQLException {
			boolean result = false;
			Mark marks = student.getMark();
			final String SQL = "INSERT INTO `student`.`student` "
					+ "(`Name`, `regn_no`, `mobile_no`, `address`, `sub1`, `sub2`, `sub3`, `sub4`, `total`, `percentage`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?);" ;
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, student.getName());
			pst.setString(2, student.getSid());
			pst.setString(3, student.getMobile());
			pst.setString(4, student.getAddr());
			pst.setInt(5, marks.getM1());
			pst.setInt(6, marks.getM2());
			pst.setFloat(7, marks.getM3());
			pst.setFloat(8, marks.getM4());
			pst.setFloat(9, marks.getTotalMarks());
			pst.setFloat(10, marks.getPercentage());
			int i = pst.executeUpdate();
			if(i > 0)
				result = true;
			return result;
		}
		
		public Student getDetails(String regnNo) throws SQLException {
			Student student = null;
			Mark marks = null;
			final String SQL = "select * from student where regn_no = ?" ;
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, regnNo);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				student = new Student();
				marks = new Mark();
				student.setName(rs.getString("Name"));
				student.setSid(rs.getString("regn_no"));
				student.setMobile(rs.getString("mobile_no"));
				student.setAddr(rs.getString("address"));
				marks.setM1(rs.getInt("sub1"));
				marks.setM2(rs.getInt("sub2"));
				marks.setM3(rs.getInt("sub3"));
				marks.setM4(rs.getInt("sub4"));
				marks.setTotalMarks(rs.getFloat("total"));
				marks.setPercentage(rs.getFloat("percentage"));
				student.setMark(marks);
			}
			
			return student;
			
		}
}
