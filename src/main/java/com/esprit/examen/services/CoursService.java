package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	SessionService sessionService;
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}



	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);
	}

	@Override
	public List<Cours> getCours() {
		List<Cours> cours =  (ArrayList) coursRepository.findAll();
		return cours;
	}

	
	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		Optional<Cours> c= coursRepository.findById(coursId);
		Cours cc=c.get();

			Set<Cours> coursSet = sessionRepository.findById(sessionId).get().getCours();
			boolean test=coursSet.contains(cc);
			if(!test){
				sessionRepository.findById(sessionId).get().getCours().add(cc);
			}


}

}
