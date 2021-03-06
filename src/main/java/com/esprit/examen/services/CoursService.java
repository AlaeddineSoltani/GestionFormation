package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.repositories.CoursRepository;

@Service
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
		}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);
		
	}

	@Override
	public List<Cours> getCours() {
		
		 return coursRepository.findAll();
		 
	}
	
	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
	
        
	}

}
