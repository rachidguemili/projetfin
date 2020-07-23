package com.projetfin.projetfin.student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

}


