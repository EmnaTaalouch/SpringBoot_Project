package tn.esprit.persistance;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Equipe")
public class Equipe implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEquipe")
	private int idEquipe ; 
	private String nomEquipe ; 
	@Enumerated(EnumType.STRING)
	private Niveau niveau; 
	@OneToOne
	private DetailEquipe detail_equipe ; 
	@ManyToMany
	@JsonIgnore
	private Set<Etudiant> etudiants; 
public Equipe() {
	
}
public int getIdEquipe() {
	return idEquipe;
}
public void setIdEquipe(int idEquipe) {
	this.idEquipe = idEquipe;
}
public String getNomEquipe() {
	return nomEquipe;
}
public void setNomEquipe(String nomEquipe) {
	this.nomEquipe = nomEquipe;
}
public Niveau getNiveau() {
	return niveau;
}
public void setNiveau(Niveau niveau) {
	this.niveau = niveau;
}
public DetailEquipe getDetail_equipe() {
	return detail_equipe;
}
public void setDetail_equipe(DetailEquipe detail_equipe) {
	this.detail_equipe = detail_equipe;
}
public Set<Etudiant> getEtudiants() {
	return etudiants;
}
public void setEtudiants(Set<Etudiant> etudiants) {
	this.etudiants = etudiants;
}
public Equipe(int idEquipe, String nomEquipe, Niveau niveau, DetailEquipe detail_equipe, Set<Etudiant> etudiants) {
	super();
	this.idEquipe = idEquipe;
	this.nomEquipe = nomEquipe;
	this.niveau = niveau;
	this.detail_equipe = detail_equipe;
	this.etudiants = etudiants;
}
@Override
public String toString() {
	return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", niveau=" + niveau + ", detail_equipe="
			+ detail_equipe + ", etudiants=" + etudiants + ", getIdEquipe()=" + getIdEquipe() + ", getNomEquipe()="
			+ getNomEquipe() + ", getNiveau()=" + getNiveau() + ", getDetail_equipe()=" + getDetail_equipe()
			+ ", getEtudiants()=" + getEtudiants() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}


}
