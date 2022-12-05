package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.Universite;
import tn.esprit.services.Interfaces.UniversiteService;

@RestController
@RequestMapping("UniversityController")
public class UniversityController {

	@Autowired
	UniversiteService univserv; 
	 

@GetMapping("displayUniversities")
public List<Universite> retrieveAllUniversites() {
	return univserv.retrieveAllUniversites();

}

@PostMapping("addUniversity")
public Universite addUniversite(@RequestBody Universite u) {
u=univserv.addUniversite(u);
return u;
}

@PutMapping("updateUniversity")
public Universite updateUniversity(@RequestBody Universite u) {
	 return univserv.updateUniversite(u);
}

@GetMapping("displayUniversityBYId/{idUniversity}")
public Universite retrieveUniversite(@PathVariable("idUniversity") Integer idUniversite) {
	return univserv.retrieveUniversite(idUniversite);
}

	
}
