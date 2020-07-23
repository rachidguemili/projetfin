package com.projetfin.projetfin.levels;

import com.projetfin.projetfin.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LevelService {

	@Autowired
	LevelRepository levelRepository;

	public List<Level> getAll() {
		return levelRepository.findAll();
	}

	public Level getById(Long id) {
		return levelRepository.findById(id).get();
	}

	public Level saveLevel(Level level) {

		return levelRepository.save(level);
	}

	public Level updateLevel(Level level, Long id) {

		Level level1 = levelRepository.findById(id).get();
		if (level1.getId() == level.getId())
			return levelRepository.save(level);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	public void deleteLevel(Long id) {
		levelRepository.deleteById(id);

	}
}