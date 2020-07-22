package com.projetfin.projetfin.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherService {


	@Autowired
	TeacherRepository teacherRepository;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public Teacher updateTeacher(Teacher teacher, Long id) {
		Teacher  teacher1 = teacherRepository.findById(id).get();
		if ( teacher1.getId() == teacher.getId() )
			return teacherRepository.save(teacher);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public List<Teacher> getAll() {

		return teacherRepository.findAll();
	}

	public Teacher getById(Long id) {

		return teacherRepository.findById(id).get();
	}

	public void deleteTeacher(Long id) {
		if (teacherRepository.findById(id) != null)
			teacherRepository.deleteById(id);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
