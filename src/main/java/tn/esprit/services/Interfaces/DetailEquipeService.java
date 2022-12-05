package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.DetailEquipe;

public interface DetailEquipeService {
	 public List<DetailEquipe> getDetailEquipes();
	 public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe);
	 public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> detailEquipe);
	 public String deleteDetailEquipe(Integer idDetailEquipe);
	 public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe);
	 List<DetailEquipe> findByThematiqueLike(String thematique);
	 }
