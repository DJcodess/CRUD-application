package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	private final StudentRepo studentRepo;
	
	@Autowired
	public StudentService (StudentRepo studentRepo) {
		this.studentRepo=studentRepo;
	}
	
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
      
	public Optional<Student> getStudent(long studentId) {
		Optional<Student> StudentById=studentRepo.findById(studentId);
		return StudentById;
	}
	public void addNewStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email already exists");
		}
		else {
			studentRepo.save(student);
		}
	}

	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		boolean exists=studentRepo.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("student with id " + studentId + " does not exists");			
		}
		else {
			studentRepo.deleteById(studentId);
		}
	}

	@Transactional
	public void updateStudent(Long studentId, String studentName, String studentEmail, String appointmentDate, String appointmentTime) {
		// TODO Auto-generated method stub
		Optional<Student> opStudent = studentRepo.findById(studentId);
		if(opStudent.isPresent()) {
			Student student=opStudent.get();
			if(studentName!=null && studentName.length()>0) {
				student.setName(studentName);
				System.out.println("name is changing");
			}
			if(studentEmail!=null && studentEmail.length()>0 && !Objects.equals(student.getEmail(), studentEmail)) {
				Optional<Student> opStudent2 = studentRepo.findStudentByEmail(studentEmail);
				if(opStudent2.isPresent()) {
					throw new IllegalStateException("Email already exists");
				}
				else
				{
					student.setEmail(studentEmail);;
				}
			}
			student.setAppointmentdate(appointmentDate);
			student.setAppointmenttime(appointmentTime);
		}
		else {
			throw new IllegalStateException("Not Found Student");
		}
		
	}
}
