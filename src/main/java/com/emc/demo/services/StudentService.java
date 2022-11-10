package com.emc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.repositories.StudentRepository;

import java.util.List;

import com.emc.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
}
