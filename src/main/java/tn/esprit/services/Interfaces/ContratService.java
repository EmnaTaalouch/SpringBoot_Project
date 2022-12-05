package tn.esprit.services.Interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.persistance.Contrat;

public interface ContratService {
	List<Contrat> retrieveAllContrats();

	Contrat updateContrat (Contrat ce);

	Contrat addContrat (Contrat ce);

	Contrat retrieveContrat (Integer idContrat);

	void removeContrat(Integer idContrat);
	
	int affecterContratToEtudiant( int i, int idc ); 
	
	void dropAllContratsEveryYear();
    int dropcontratdunjour();
}
