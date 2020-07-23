package com.projetfin.projetfin.classes;

import com.projetfin.projetfin.levels.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/classes")
@CrossOrigin
public class ClasseController {

	@Autowired ClasseService classeService;

	@GetMapping
	public List<Classe> getAll() {
		return classeService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Classe getById(@PathVariable Long id) {

		return classeService.getById(id);
	}

	@PostMapping
	public Classe postChapter(@RequestBody Classe classe){

		return classeService.saveClasse(classe);
	}

	@PutMapping(value = "/{id}")
	public Classe putClasse(@RequestBody Classe classe, @PathVariable Long id){
		return classeService.updateClasse(classe, id);

	}

	@DeleteMapping(value = "/{id}")
	public void deleteClasse(@PathVariable Long id) throws Exception  {
		if (classeService.getById(id)!=null)
			classeService.deleteClasse(id);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}



}
