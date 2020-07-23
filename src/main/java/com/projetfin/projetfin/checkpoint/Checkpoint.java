package com.projetfin.projetfin.checkpoint;

import com.projetfin.projetfin.classes.Classe;
import com.projetfin.projetfin.courses.Course;
import com.projetfin.projetfin.student.Student;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Checkpoint {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;

		Date date;
		String score;

		@ManyToOne
		Student student;

		@ManyToOne
		Course course;

	public Checkpoint() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
