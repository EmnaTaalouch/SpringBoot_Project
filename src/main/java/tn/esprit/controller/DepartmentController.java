package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.Departement;
import tn.esprit.services.Interfaces.DepartmentService;

@RestController
@RequestMapping("DepartmentController")
public class DepartmentController {

	@Autowired
	DepartmentService depserv ; 
	
	@GetMapping("displayalldepartment")
	public List<Departement> retrieveAllDepartements() {
		return depserv.retrieveAllDepartements();
	}

	@PostMapping("addDepartment")
	public Departement addDepartement( Departement d) {
		 depserv.addDepartement(d);
		return d;
	}

	@PutMapping("updatedepartment")
	@ResponseBody
	public Departement updateDepartement(Departement d) {
		depserv.updateDepartement(d);
		return d;
	}

	@GetMapping("displdepartmentbyid/{idDepart}")
	@ResponseBody
	public Departement retrieveDepartement( @PathVariable("idDepart") int idDepart) {
		return depserv.retrieveDepartement(idDepart);
	}

}
