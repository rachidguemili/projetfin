package com.projetfin.projetfin.chapters;

import com.projetfin.projetfin.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChapterService {

	@Autowired ChapterRepository chapterRepository;

	public List<Chapter> getAll() {
		return  chapterRepository.findAll();
	}

	public Chapter getById(Long id) {
		return  chapterRepository.findById(id).get();
	}

	public Chapter updateChapter(Chapter chapter, Long id) {


		if(chapterRepository.findById(id).get().getId()== chapter.getId()) {
			Chapter chapterUpdated = chapterRepository.findById(id).get();
			chapterUpdated.setName(chapter.getName());
			chapterUpdated.setValue(chapter.getValue());
			chapterUpdated.setCourse(chapter.getCourse());

			return chapterRepository.save(chapterUpdated);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);


	}

	public Chapter saveChapter(Chapter course) {

		return chapterRepository.save(course);
	}

	public void deleteChapter(Long id) {
		chapterRepository.deleteById(id);
	}
}
