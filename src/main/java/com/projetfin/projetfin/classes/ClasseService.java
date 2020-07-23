package com.projetfin.projetfin.classes;

import com.projetfin.projetfin.chapters.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClasseService {

	@Autowired
	ClasseRepository classeRepository;

	public Classe saveClasse(Classe classe) {
	return classeRepository.save(classe);
	}

	public Classe getById(Long id) {
	return classeRepository.findById(id).get();
	}

	public Classe updateClasse(Classe classe, Long id) {
		if(classeRepository.findById(id).get().getId()== classe.getId()) {
			Classe classe1 = classeRepository.findById(id).get();
			classe1.setName(classe.getName());
			classe1.setLevel(classe.getLevel());
			classe1.setMeetList(classe.getMeetList());

			return classeRepository.save(classe);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	public void deleteClasse(Long id) {
	 classeRepository.deleteById(id); }

	public List<Classe> getAll() {
		return classeRepository.findAll();
	}
}