package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="students")
public class Student {
	@Id
	@SequenceGenerator(
			name="student_seq",
			sequenceName="student_seq",
			allocationSize=1
	)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="student_seq"
	)
	private long id;
	private String name;
	@Column(nullable = true)
	
	@Transient
	private int age;
	private LocalDate dob;
	private String email;
	private String appointmentdate;
	private String appointmenttime;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, String appointmentdate, String appointmenttime, int age, LocalDate dob,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.appointmentdate = appointmentdate;
		this.appointmenttime = appointmenttime;
		this.age = age;
		this.dob = dob;
		this.email = email;
	}

	public Student(long id, String name, int age, LocalDate dob, String email, String appointmentdate,
			String appointmenttime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.email = email;
		this.appointmentdate = appointmentdate;
		this.appointmenttime = appointmenttime;
	}

	public Student(long l, String name, LocalDate dob, String email, String string, String string2) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	
	public Student(long id, String name, LocalDate dob, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", appointmentdate=" + appointmentdate + ", appointmenttime="
				+ appointmenttime + ", age=" + age + ", dob=" + dob + ", email=" + email + "]";
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getAppointmenttime() {
		return appointmenttime;
	}

	public void setAppointmenttime(String appointmenttime) {
		this.appointmenttime = appointmenttime;
	}
	
	
}
