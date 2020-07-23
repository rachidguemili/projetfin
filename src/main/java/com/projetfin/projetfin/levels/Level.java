package com.projetfin.projetfin.levels;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.chapters.Chapter;
import com.projetfin.projetfin.classes.Classe;

import javax.persistence.*;
import java.util.List;

@Entity
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
	@JsonIdentityInfo(
			scope = Level.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Classe> classeList;

	public Level() {
	}

	public List<Classe> getClasseList() {
		return classeList;
	}

	public void setClasseList(List<Classe> classeList) {
		this.classeList = classeList;
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
}
