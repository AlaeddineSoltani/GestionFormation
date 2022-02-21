package com.esprit.examen.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;

public interface IFormateurService {
	Long addFormateur(Formateur formateur);

	Long modifierFormateur(Formateur formateur);

	void supprimerFormateur(Long formateurId);
	
//	Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours);
		
	List<Formateur> listFormateurs();
	void getFormateurBySession(Long id);
	Integer countFormateur(); 
}
