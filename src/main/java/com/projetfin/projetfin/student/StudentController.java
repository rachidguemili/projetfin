package com.projetfin.projetfin.student;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/students")
public class StudentController {


	@Autowired StudentService studentService;

 	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Student getById(@PathVariable Long id) {

 		return studentService.getById(id);
	}

	@PostMapping
	public Student postStudent(@RequestBody Student student){

		return studentService.saveStudent(student);
	}

	@PutMapping(value = "/{id}")
	public Student putStudent(@RequestBody Student student, @PathVariable Long id){
		return studentService.updateStudent(student, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteStudent(@PathVariable Long id) throws Exception  {
		if (studentService.getById(id)!=null)
			studentService.deleteStudent(id);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}


}
