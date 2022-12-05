package tn.esprit.services.Interfaces;

import java.util.List;


import tn.esprit.persistance.Equipe;

public interface EquipeService {
	List<Equipe> retrieveAllEquipes();

	Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

	Equipe updateEquipe (Equipe e);
	
	void DeleteEquipe (Integer idEquipe);

	Equipe retrieveEquipe (Integer idEquipe);
     
}
