package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	@GetMapping(path="{studentId}")
	public Optional<Student> getStudent(@PathVariable("studentId") Long studentId) {
		return studentService.getStudent(studentId);
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	

	@PutMapping(path="{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required=false) String studentName,
			@RequestParam(required=false) String studentEmail,
			@RequestParam(required=false) String appointmentDate,
			@RequestParam(required=false) String appointmentTime
			)
	{
		studentService.updateStudent(studentId, studentName, studentEmail,appointmentDate,appointmentTime);
	}
}
