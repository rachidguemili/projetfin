package com.projetfin.projetfin.student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.classes.Classe;
import com.projetfin.projetfin.courses.Course;
import com.projetfin.projetfin.teacher.Teacher;
import com.projetfin.projetfin.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne
	@JsonIdentityInfo(
			scope = Student.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	Classe classe;

	List<Course> courseList;


	public Student() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Classe getClasse() {
		return classe;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}


