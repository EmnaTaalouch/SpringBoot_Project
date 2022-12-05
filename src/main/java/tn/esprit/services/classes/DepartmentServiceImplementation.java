package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.repositories.DepartmentRepository;
import tn.esprit.services.Interfaces.DepartmentService;
@Service
public class DepartmentServiceImplementation implements DepartmentService{
	@Autowired 
	DepartmentRepository deprep; 

	@Override
	public List<Departement> retrieveAllDepartements() {
		return deprep.findAll();
	}

	@Override
	public Departement addDepartement(Departement d) {
		 deprep.save(d);
		return d;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		deprep.findById(d.getIdDepart()).get();
		deprep.save(d);
		return d;
	}

	@Override
	public Departement retrieveDepartement(Integer idDepart) {
		return deprep.findById(idDepart).get();
	}

}
