package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Universite;

public interface UniversiteService {
	List<Universite> retrieveAllUniversites();
	Universite addUniversite (Universite u);
	Universite updateUniversite (Universite u);
	Universite retrieveUniversite (Integer idUniversite);
  
}
