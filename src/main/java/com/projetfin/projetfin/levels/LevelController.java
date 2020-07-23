package com.projetfin.projetfin.levels;

import com.projetfin.projetfin.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/levels")
@CrossOrigin
public class LevelController {

	@Autowired LevelService levelService;

	@GetMapping
	public List<Level> getAll() {
		return levelService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Level getById(@PathVariable Long id) {

		return levelService.getById(id);
	}

	@PostMapping
	public Level postLevel(@RequestBody Level level){

		return levelService.saveLevel(level);
	}

	@PutMapping(value = "/{id}")
	public Level putLevel(@RequestBody Level level, @PathVariable Long id){
		return levelService.updateLevel(level, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteLevel(@PathVariable Long id) throws Exception  {
		if (levelService.getById(id)!=null)
			levelService.deleteLevel(id);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}


}
