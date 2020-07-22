package com.projetfin.projetfin.courses;

import com.projetfin.projetfin.chapters.Chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;


	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course getById(Long id) {

		return  courseRepository.findById(id).get();
	}

	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course, Long id) {

		return courseRepository.save(course);
	}

	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}
}
