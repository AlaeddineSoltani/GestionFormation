package com.esprit.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Cours;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Long> {

}
