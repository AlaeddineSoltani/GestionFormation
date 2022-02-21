package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.entities.Session;

@Repository
public interface FormateurRepository extends CrudRepository<Formateur, Long>{

	
//	@Query("select * from  ")
//	public Long nombreFormateursImpliquesDansUnCours(@Param("typeCours")TypeCours typeCours);




}
