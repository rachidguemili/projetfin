package com.projetfin.projetfin.classes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projetfin.projetfin.chapters.Chapter;
import com.projetfin.projetfin.levels.Level;
import com.projetfin.projetfin.meets.Meet;

import javax.persistence.*;
import java.util.List;

@Entity
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;


	@ManyToOne
	@JsonIdentityInfo(
			scope = Classe.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	Level level;

	@ManyToMany
	@JsonIdentityInfo(
			scope = Classe.class,
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	List<Meet> meetList;

	public Classe() {
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public List<Meet> getMeetList() {
		return meetList;
	}

	public void setMeetList(List<Meet> meetList) {
		this.meetList = meetList;
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
