package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.DetailEquipe;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.services.Interfaces.DetailEquipeService;
@Service
public class DetailEquipeServiceImplementation implements DetailEquipeService{

	@Autowired
	    DetailEquipeRepository detailEquipeRepository;

	    public List<DetailEquipe> getDetailEquipes(){
	        return detailEquipeRepository.findAll();
	    }
	    
	    public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe){
	        return detailEquipeRepository.save(detailEquipe);
	    }
	    
	    public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> detailEquipe){
	        return detailEquipeRepository.saveAll(detailEquipe);
	    }

	    public String deleteDetailEquipe(Integer idDetailEquipe){
	        detailEquipeRepository.deleteById(idDetailEquipe);
	        return "DetailEquipe supprimé !" +idDetailEquipe;
	    }
	    
	    public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe){
	        DetailEquipe existingDetailEquipe = detailEquipeRepository.findById(detailEquipe.getIdDetailEquipe()).orElse(null);
	        existingDetailEquipe.setSalle(detailEquipe.getSalle());
	        existingDetailEquipe.setThematique(detailEquipe.getThematique());
	        existingDetailEquipe.setEquipe(detailEquipe.getEquipe());
	        return detailEquipeRepository.save(existingDetailEquipe);
	    }


	    public List<DetailEquipe> findByThematiqueLike(String thematique){
	    	
	        return detailEquipeRepository.findByThematiqueLike(thematique);
	    }
}
		
