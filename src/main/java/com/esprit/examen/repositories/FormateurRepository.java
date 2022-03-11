package com.esprit.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;

@Repository
public interface FormateurRepository extends CrudRepository<Formateur, Long>{

	
//	@Query("select * from  ")
//	public Long nombreFormateursImpliquesDansUnCours(@Param("typeCours")TypeCours typeCours);




}
