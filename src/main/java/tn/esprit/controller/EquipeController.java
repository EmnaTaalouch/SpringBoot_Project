package tn.esprit.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.services.Interfaces.EquipeService;

@RestController
@RequestMapping("/EquipeController")
public class EquipeController {
	
	 @Autowired 
	 EquipeService equipeserv; 
	 EquipeRepository equiprep;
	 
	 @GetMapping("/displayEquipes")
	 public List<Equipe> getEquipes(){
		 return equipeserv.retrieveAllEquipes();
	 }
	 
 @GetMapping("/displayEquipeById/{id}")
	public Equipe displayEquipe(@PathVariable int id) {
		return equipeserv.retrieveEquipe(id);
	}
 

 
 @PostMapping("/addEquipe")
 @ResponseBody
 public Equipe addEquipe(@RequestBody Equipe eq) {
	 equipeserv.addEquipe(eq);
	 return eq; 
 }
 
 
 @PutMapping("/updateEquipe")
 public Equipe updateEquipe(@RequestBody Equipe eq ) {
	 return  equipeserv.updateEquipe(eq); 
 }
 
 @DeleteMapping("/deleteEquipe/{id}")
 public void DeleteEquipe(@PathVariable("id")int id ) {
	 equipeserv.DeleteEquipe(id);
 }
 
 @GetMapping("getAllEquipes")
 public List<Equipe> getAllEquipes(){
	 return equiprep.getAllEquipe();
 }
 
}
