package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepo;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	public void addStudent(Student e)
	{
		Integer total = e.getSub1() + e.getSub2() + e.getSub3() + e.getSub4();
		Integer percentage = total / 4;
		
		e.setTotal(total);
		e.setPercentage(percentage);
		repo.save(e);
	}
	public List<Student>getAllstudent() {
		return repo.findAll();
	}

}
