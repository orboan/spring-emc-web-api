package com.emc.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.exception.ResourceNotFoundException;
import com.emc.demo.model.Student;
import com.emc.demo.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	/*
	 * Get List from MySQL db
	 */
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getStudentsByName(String name){
		return studentRepository.findByName(name);
	}		
	
	public Student getStudentById(int id)
		throws ResourceNotFoundException {
			Optional<Student> student = 
					studentRepository.findById(id);
			
			if(!student.isPresent()) {
				throw new ResourceNotFoundException("Resource Not found !!!");
			} 
		
		return student.get();
	}	
	
	public List<Student> getStudentsByNameAndSurname(String name, String surname){
		return studentRepository.findByNameAndSurname(name, surname);
	}	
	
	public List<Student> getStudentsByAge(int age){
		return studentRepository.findByAge(age);
	}
	
	/**
	 * 
	 * 
	 * @param student
	 * @return l'objecte Student guardat a la base de dades
	 */
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) throws ResourceNotFoundException {
		Optional<Student> oldStudent = 
				studentRepository.findById(student.getIdstudent());
		
		if(!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Resource Not found !!!");
		} else {
			Student studentToUpdate = oldStudent.get();
			studentToUpdate.setName(student.getName());
			studentToUpdate.setSurname(student.getSurname());
			studentToUpdate.setAge(student.getAge());
			Student updatedStudent = studentRepository.save(studentToUpdate);
			return updatedStudent;
		}
	}
}

