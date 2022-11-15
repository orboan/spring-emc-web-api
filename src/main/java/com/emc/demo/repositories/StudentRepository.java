package com.emc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emc.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);
	
	List<Student> findByNameAndSurname(String name, String surname);
	
	// https://thorben-janssen.com/jpql/
	//@query pots passar jpql o sql nadiu, en aquest cas
	//passes un segon paràmetre dient que és nadiu
	//matxaca la query que et generaria per defecte pq 
	//el nom del mètode segueix el conveni de noms
	//(però el mètode es pot dir com vulguis si poses @Query)
	@Query("SELECT s FROM Student s WHERE s.age = :age")
	List<Student> findByAge(@Param("age") int age);
	

	
}
