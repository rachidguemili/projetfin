package com.projetfin.projetfin.meets;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.chapters.Chapter;
import com.projetfin.projetfin.classes.Classe;
import com.projetfin.projetfin.teacher.Teacher;



import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Meet {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	Date date;
	String subject;

	@ManyToOne
	@JsonIdentityInfo(
			scope = Meet.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	Chapter chapter;


	@ManyToOne
	@JsonIdentityInfo(
			scope = Meet.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	Teacher teacher;

	@ManyToMany(mappedBy = "meetList")
	@JsonIdentityInfo(
			scope = Meet.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Classe> classesList;

	public Meet() {
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Classe> getClassesList() {
		return classesList;
	}

	public void setClassesList(List<Classe> classesList) {
		this.classesList = classesList;
	}
}
