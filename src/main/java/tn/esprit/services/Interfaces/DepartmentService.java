package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Departement;

public interface DepartmentService {
	List<Departement> retrieveAllDepartements();

	Departement addDepartement (Departement d);

	Departement updateDepartement (Departement d);

	Departement retrieveDepartement (Integer idDepart);
}
