package tn.esprit.persistance.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{


	@Query(value="SELECT  * from etudiant LEFT JOIN equipe_etudiants ON etudiant.id_etudiant=equipe_etudiants.etudiants_id_etudiant"
			+ "  LEFT JOIN equipe ON equipe_etudiants.equipe_id_equipe=equipe.id_equipe "
			,nativeQuery=true)
	public List<Etudiant> getAllEtudiant();
	public Etudiant getEtudiantByNomE(String name);
	
	@Query("select e from Etudiant e where e.nomE like %:prefixe%")
    List<Etudiant> getAllEtudiantsBeginByNomE(@Param("prefixe") String prefixe);
	
	/*
	@Modifying
	@Query("update Etudiant e set e.departement.idDepart = ?2 where e.idEtudiant= ?1")
	public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
	*/
}
