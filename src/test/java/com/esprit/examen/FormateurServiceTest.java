package com.esprit.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.esprit.examen.services.FormateurService;
import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.FormateurRepository;
@SpringBootTest
public class FormateurServiceTest { 
	@Autowired
	FormateurService formateurService ;
	@Autowired
	FormateurRepository formateurRepository;
	private static Contrat CONTRAT = Contrat.CIVP;
	private static String EMAIL = "felBenFoulen@gmail.com";
	private static String PASSWORD ="password" ;
	private static String NOM = "flen";
	private static String PRENOM = "ben foulen";
	private static Poste POST=  Poste.Ingénieur;
	private Formateur testformateur = new Formateur( NOM, PRENOM, POST, CONTRAT, EMAIL, PASSWORD);
    private Formateur testformateur2 = new Formateur( "f1", "P1", Poste.Technicien, Contrat.EXPERT, "f1@gamil.com", "passF1");
    private Formateur testformateur3 = new Formateur( "f2", "P1", Poste.Ingénieur, Contrat.FREELANCE, "f2@gmail.com", "PasF2");
private static final Logger logger = LogManager.getLogger(FormateurServiceTest.class);
 
	@BeforeEach
	void clearDataBase() {
	   formateurRepository.deleteAll();
	}
	@Test
	public void testAddFormateur(){
	logger.debug("entring testAddFormateur methode");
	long start = System.currentTimeMillis();
	formateurService.addFormateur(testformateur);
		assertThat(formateurService.listFormateurs().contains(testformateur));
		long elapsedTime = System.currentTimeMillis() - start ;
	logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	logger.debug("quiting testAddFormateur methode");
	formateurService.supprimerFormateur(testformateur.getId());
	}
	@Test
	public void testDeleteFormateur(){
	logger.debug("entring testDeleteFormateur methode");
	long start = System.currentTimeMillis();
	formateurService.addFormateur(testformateur);
		assertThat(formateurService.listFormateurs().contains(testformateur));
     formateurService.supprimerFormateur(testformateur.getId());
     assertThat(formateurService.listFormateurs().contains(testformateur)==false);
		long elapsedTime = System.currentTimeMillis() - start ;
	logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	logger.debug("quiting testAddFormateur methode");	
	}
	@Test
	public void testmodifierFormateur(){
		logger.debug("entring testmodifierFormateur methode");
		long start = System.currentTimeMillis();
        formateurService.addFormateur(testformateur);
		testformateur.setNom("new flen");
		System.out.print(testformateur.getNom());
		testformateur.setPassword("new password");
		formateurService.modifierFormateur(testformateur);
		Formateur formateurModifier = (Formateur) formateurService.listFormateurs().get(0);
		assertThat("new flen").isEqualTo(formateurModifier.getNom());
		assertThat("new password").isEqualTo(formateurModifier.getPassword());
		long elapsedTime = System.currentTimeMillis() - start ;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.debug("quiting testmodifierFormateur methode");
	}
	@Test
	public void testListFormateurs(){
		logger.debug("entring testmodifierFormateur methode");
		long start = System.currentTimeMillis();
		List<Formateur> listFormateur = (List<Formateur>) new ArrayList<Formateur>(); 
		listFormateur.add(testformateur);
		listFormateur.add(testformateur2);
		listFormateur.add(testformateur3);
		ArrayList<Formateur> listFormateur2 = ((ArrayList<Formateur>) listFormateur);
		for ( Formateur f : listFormateur2 ){
			formateurService.addFormateur(f);
		}
		List<Formateur> listFormateurSaved = (List<Formateur>) formateurService.listFormateurs(); 
		assertThat(listFormateurSaved.contains(testformateur));
		assertThat(listFormateurSaved.contains(testformateur2));
		assertThat(listFormateurSaved.contains(testformateur3));
		long elapsedTime = System.currentTimeMillis() - start ;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.debug("quiting testmodifierFormateur methode");
	}
	@Test
	public void testCountFormateur(){
		logger.debug("entring testmodifierFormateur methode");
		long start = System.currentTimeMillis();
		List<Formateur> listFormateur = (List<Formateur>) new ArrayList<Formateur>(); 
    	assertThat(0).isEqualTo(listFormateur.size());
		listFormateur.add(testformateur);
		listFormateur.add(testformateur2);
		listFormateur.add(testformateur3);
		for ( Formateur f : (ArrayList<Formateur>) listFormateur ){
			formateurService.addFormateur(f);
		}
		List<Formateur> listFormateurSaved = (List<Formateur>) formateurService.listFormateurs(); 
     	assertThat(3).isEqualTo(listFormateurSaved.size());
		long elapsedTime = System.currentTimeMillis() - start ;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.debug("quiting testmodifierFormateur methode");
	}
	@Test
	public void testGetFormateurBySession(){
		
	}
	@AfterEach
	void setUpDataBase() {
	   formateurRepository.deleteAll();
	}
	 
	}

