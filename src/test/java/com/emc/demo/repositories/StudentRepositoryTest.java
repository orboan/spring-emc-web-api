package com.emc.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.emc.demo.model.Student;

//em permet el context de SpringBoot
//m'arrenca el DB H2, creant-me automàticament les taules
//code-first with embedded databases
//per fer-ho amb MySQL -> test d'integració, cal descommentar @AutoConfigure.... i
//posar un aplication.properties i posar variables d'entorn en el runner del test

//@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	StudentRepository repository;
	
	@Test
	void testFindByName() {
		//fail("Not yet implemented");
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);
		
		entityManager.persist(student);
		entityManager.flush();
		
		List<Student> studentList = repository.findByName("Jordi");
		assertTrue(studentList.size() > 0);
	}
	

	@Test
	void testFindByNameAndSurname() {
		//fail("Not yet implemented");
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);
		
		entityManager.persist(student);
		entityManager.flush();
		
		List<Student> studentList = repository.findByNameAndSurname("Jordi", "Ros");
		assertTrue(studentList.size() > 0);
	}

	@Test
	void testFindByAge() {
		//fail("Not yet implemented");
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);
		
		entityManager.persist(student);
		entityManager.flush();
		
		List<Student> studentList = repository.findByAge(24);
		assertTrue(studentList.size() > 0);
	}

}
