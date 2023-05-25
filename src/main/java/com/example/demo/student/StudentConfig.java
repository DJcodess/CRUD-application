package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepo repo) {
		return args -> {
			Student Dhruv=new Student(
					1L,
					"Dhruv",
					LocalDate.of(2002, 7, 9),
					"Dhruvjain407@gmail.com",
					"24-05-2023",
					"10:00");
			Student saurabh=new Student(
					2L, "Saurabh",
					"26-05-2023", "11:00", 0, LocalDate.of(2002, 7, 9),
					"saurabhbazzad@gmail.com");
			repo.saveAll(List.of(Dhruv, saurabh));
		};
	}
}

