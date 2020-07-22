package com.projetfin.projetfin.courses;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.chapters.Chapter;
import com.projetfin.projetfin.student.Student;
import com.projetfin.projetfin.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	@OneToMany (mappedBy = "course")
	@JsonIdentityInfo(
			scope = Course.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Chapter> chapters;

	@ManyToMany(mappedBy = "courseList")
	@JsonIdentityInfo(
			scope = Course.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Student> studentList;

	@ManyToMany(mappedBy = "courseList")
	@JsonIdentityInfo(
			scope = Course.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Teacher> teacherList;


	public Course() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
}
