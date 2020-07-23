package com.projetfin.projetfin.meets;


import com.projetfin.projetfin.levels.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/meets")
@CrossOrigin
public class MeetController {

	@Autowired Meetservice meetservice;
	@GetMapping
	public List<Meet> getAll() {
		return meetservice.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Meet getById(@PathVariable Long id) {

		return meetservice.getById(id);
	}

	@PostMapping
	public Meet postMeet(@RequestBody Meet meet){

		return meetservice.saveMeet(meet);
	}

	@PutMapping(value = "/{id}")
	public Meet putMeet(@RequestBody Meet meet, @PathVariable Long id){
		return meetservice.updateMeet(meet, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteMeet(@PathVariable Long id) throws Exception  {
		if (meetservice.getById(id)!=null)
			meetservice.deleteMeet(id);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}


}
