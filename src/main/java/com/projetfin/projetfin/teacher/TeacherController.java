package com.projetfin.projetfin.teacher;



import com.projetfin.projetfin.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/teachers")
public class TeacherController {

	@Autowired TeacherService teacherService;

	@GetMapping
	public List<Teacher> getAll() {
		return teacherService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Teacher getById(@PathVariable Long id) {
		return teacherService.getById(id);
	}

	@PostMapping
	public Teacher postTeacher(@RequestBody Teacher teacher){

		return teacherService.saveTeacher(teacher);
	}

	@PutMapping(value = "/{id}")
	public Teacher putTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
		return teacherService.updateTeacher(teacher, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteTeacher(@PathVariable Long id)   {

		   teacherService.deleteTeacher(id);

	}

}
