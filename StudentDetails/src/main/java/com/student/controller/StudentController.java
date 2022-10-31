package com.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	
	
	@GetMapping("/")
	public String home(Model m)
	{
		
		List<Student>student= service.getAllstudent();
		m.addAttribute("emp");
		return "index";  
	}
	
	@GetMapping("/addstd")
	public String addStudentForm()
	{
		return "add_student";
	}
	
	@PostMapping("/register")
	public String stdRegister(@ModelAttribute Student e,HttpSession session)
	{
		System.out.println(e);
		service.addStudent(e);
		session.setAttribute("msg", "Student Add Sucessfully....");
		return "redirect:/";
	}

}
