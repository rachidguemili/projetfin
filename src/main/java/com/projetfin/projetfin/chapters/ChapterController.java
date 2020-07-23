package com.projetfin.projetfin.chapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chapters")
public class ChapterController {

	@Autowired
	ChapterService chapterService;

	@GetMapping
	public List<Chapter> getAll() {
		return chapterService.getAll();
	}

	@GetMapping(value = "/{id}")
	//@PreAuthorize("hasAuthority('admin') or hasAuthority('teacher') ")
	public Chapter getById(@PathVariable Long id) {
		return chapterService.getById(id);
	}

	@PostMapping
	public Chapter postChapter(@RequestBody Chapter course){

		return chapterService.saveChapter(course);
	}

	@PutMapping(value = "/{id}")
	public Chapter putChapter(@RequestBody Chapter course, @PathVariable Long id){
		return chapterService.updateChapter(course, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteChapter(@PathVariable Long id){
		chapterService.deleteChapter(id);
	}

}