package tn.esprit.services.Interfaces;

import java.util.List;
import java.util.Set;

import tn.esprit.persistance.Etudiant;

public interface EtudiantService {
	List<Etudiant> retrieveAllEtudiants();

	Etudiant addEtudiant (Etudiant e);

	Etudiant updateEtudiant (Etudiant e);

	Etudiant retrieveEtudiant(Integer idEtudiant);

	void removeEtudiant(Integer idEtudiant);
	
	public List<Etudiant> getAllEtudiant();

    Etudiant getEtudiantByNomE(String name);
    
    List<Etudiant> getAllEtudiantsBeginByNomE(String prefixe);
	public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

}
