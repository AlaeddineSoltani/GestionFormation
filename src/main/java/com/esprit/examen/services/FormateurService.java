package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class FormateurService implements IFormateurService{

	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Long addFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public Long modifierFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		formateurRepository.deleteById(formateurId);
		
	}

	@Override
	public List<Formateur> listFormateurs() {
		
		return (List<Formateur>)formateurRepository.findAll();
	}

	@Override
	public void getFormateurBySession(Long idSession) {
		// sessionRepository.findById(idSession).get().getFormateur().getNom();
	
	}

	@Override
	public Integer countFormateur() {
	List<Formateur> listFormateur = (List<Formateur>) formateurRepository.findAll() ;
	return listFormateur.size();
	}

	
	




	
	

}
