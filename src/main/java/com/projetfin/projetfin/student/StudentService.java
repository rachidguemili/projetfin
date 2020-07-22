package com.projetfin.projetfin.student;

import com.projetfin.projetfin.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class StudentService {

	@Autowired StudentRepository studentRepository;

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student getById(Long id) {

	return studentRepository.findById(id).get();
	}

	public Student saveStudent(Student student) {
		return  studentRepository.save(student);
	}

	public Student updateStudent(Student student, Long id) {
		Student student1 = studentRepository.findById(id).get();
		if ( student1.getId() == student.getId() )
			return studentRepository.save(student);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);


	}

	public void deleteStudent(Long id) throws  Exception  {


				studentRepository.deleteById(id);

	}
	}

