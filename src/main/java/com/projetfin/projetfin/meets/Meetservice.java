package com.projetfin.projetfin.meets;

import com.projetfin.projetfin.levels.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class Meetservice {

	@Autowired MeetRepository meetRepository;

	public Meet getById(Long id) {
		return  meetRepository.findById(id).get();
	}

	public Meet saveMeet(Meet meet) {
		return  meetRepository.save(meet);
	}

	public Meet updateMeet(Meet meet, Long id) {

		Meet meet1 = meetRepository.findById(id).get();
		if (meet1.getId() == meet.getId()){
			meet1.setChapter(meet.getChapter());
			meet1.setClassesList(meet.getClassesList());
			meet1.setDate(meet.getDate());
			meet1.setSubject(meet.getSubject());
			return meetRepository.save(meet);}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public void deleteMeet(Long id) {
		 meetRepository.deleteById(id);
	}

	public List<Meet> getAll() {
	return  meetRepository.findAll();}

}
