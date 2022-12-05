package tn.esprit.persistance.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	@Modifying
	@Transactional
	@Query("update  Contrat as c set c.etudiant.idEtudiant= :idetudiant where c.idContrat= :idcontrat")
	int affecterContratToEtudiant(@Param("idetudiant") int i, @Param("idcontrat") int j ); 
  
    @Modifying
    @Query("delete  from Contrat c where c.dateFinContrat - c.dateDebutContrat =0  ")
    int dropcontratdunjour();

}
