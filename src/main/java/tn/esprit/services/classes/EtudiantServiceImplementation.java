package tn.esprit.services.classes;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.DepartmentRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.EtudiantService;
@Service
@Slf4j
public class EtudiantServiceImplementation implements EtudiantService {

	  @Autowired
		EtudiantRepository etudrep ;
	  @Autowired
	  DepartmentRepository deprep ;
	    
	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		 return etudrep.findAll();
		
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		try {
		//log.info(" adding student ... ");
		etudrep.save(e);
	   // log.info("student added successfuly");
		}catch(Exception exp) {
      //   log.info("test1"+exp.getStackTrace());			
		}
		
		return e;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
	
		//log.info(""+e.getIdEtudiant()+"Data before saving");
	     // log.info("saving new values ...");
	    
	    	 //log.info("save"+e);
	    	
	    	  
	    	  return etudrep.save(e);
   
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		return etudrep.findById(idEtudiant).get();
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		 etudrep.deleteById(idEtudiant);	
		    //etudrep.delete(etudrep.findById(id)); 
	}

	
	@Override
	public List<Etudiant> getAllEtudiantsBeginByNomE(String name) {
		//log.info(""+name);
		return etudrep.getAllEtudiantsBeginByNomE(name);
	}

	@Override
	public Etudiant getEtudiantByNomE(String name) {
		//log.info("resultat de recherche :"+etudrep.getEtudiantByNomE(name));
		return etudrep.getEtudiantByNomE(name);
		
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		return etudrep.getAllEtudiant();
	}

	@Override
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
		Etudiant e = etudrep.findById(etudiantId).get();
        Departement d = deprep.findById(departementId).get();
        e.setDepartement(d);
        etudrep.save(e);
        //log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" assigné au departement "+d.getNomDepart());
	}


	
	



   
	
	
	
	}
