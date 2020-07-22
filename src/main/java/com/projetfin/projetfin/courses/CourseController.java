package com.projetfin.projetfin.courses;

import com.projetfin.projetfin.chapters.Chapter;
import com.projetfin.projetfin.courses.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {


	@Autowired
    CourseService courseService;


	@GetMapping
	public List<Course> getAll() {
		return courseService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Course getById(@PathVariable Long id) {
		return courseService.getById(id);
	}

	@PostMapping
	public Course postCourse(@RequestBody Course course){

		return courseService.saveCourse(course);
	}

	@PutMapping(value = "/{id}")
	public Course putCourse(@RequestBody Course course, @PathVariable Long id){
		return courseService.updateCourse(course, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteCourse(@PathVariable Long id){
		courseService.deleteById(id);
	}


}
