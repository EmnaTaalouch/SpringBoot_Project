package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.services.Interfaces.EquipeService;
@Service
public class EquipeServiceImplementation implements EquipeService {
@Autowired
EquipeRepository equiperep;

@Override
public List<Equipe> retrieveAllEquipes() {
	return (List<Equipe>) equiperep.findAll();
}

@Override
public Equipe addEquipe(Equipe e) {
	e=equiperep.save(e);
	return e;
}

@Override
public Equipe updateEquipe(Equipe e) {
	return equiperep.save(e);
}

@Override
public Equipe retrieveEquipe(Integer idEquipe) {
	return  equiperep.findById(idEquipe).get();

}

@Override
public void DeleteEquipe(Integer idEquipe) {
	equiperep.deleteById(idEquipe);
	
}



}
