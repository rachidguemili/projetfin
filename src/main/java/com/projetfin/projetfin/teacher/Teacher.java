package com.projetfin.projetfin.teacher;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.courses.Course;
import com.projetfin.projetfin.meets.Meet;
import com.projetfin.projetfin.student.Student;
import com.projetfin.projetfin.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher  extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

//	@ManyToMany(mappedBy = "teacherList")
//	@JsonIdentityInfo(
//			scope = Teacher.class,
//			generator = ObjectIdGenerators.PropertyGenerator.class,
//			property = "id")
//	@JsonIdentityReference(alwaysAsId = true)
	List<Course> courseList;

	@OneToMany(mappedBy = "teacher")
	@JsonIdentityInfo(
			scope = Teacher.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Meet> meetList;

	public List<Meet> getMeetList() {
		return meetList;
	}

	public void setMeetList(List<Meet> meetList) {
		this.meetList = meetList;
	}

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
