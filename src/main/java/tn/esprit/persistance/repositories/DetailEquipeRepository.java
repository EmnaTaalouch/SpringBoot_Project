package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.DetailEquipe;
@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {

	    List<DetailEquipe> findByThematiqueLike(String thematique);

}
