package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.Mission;
import tn.esprit.persistance.Mission;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer>{
	
	@Query("select m from Mission m join m.contrat c where c.idContrat= :idc")
	public List<Mission> getMissionsByContrat(@Param("idc") int idc);

}
