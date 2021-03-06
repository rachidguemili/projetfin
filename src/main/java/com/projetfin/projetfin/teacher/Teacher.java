package com.projetfin.projetfin.teacher;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.courses.Course;
import com.projetfin.projetfin.student.Student;
import com.projetfin.projetfin.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher  extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToMany
	@JsonIdentityInfo(
			scope = Student.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Course> courseList;

	public Teacher() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
