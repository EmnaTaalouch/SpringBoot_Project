package tn.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Detail_equipe")
public class DetailEquipe implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailEquipe")
private int idDetailEquipe ; 
private int salle; 
private String thematique ;
@OneToOne(mappedBy = "detail_equipe")
@JsonIgnore
private Equipe equipe ; 


public DetailEquipe(int idDetailEquipe, int salle, String thematique, Equipe equipe) {
	super();
	this.idDetailEquipe = idDetailEquipe;
	this.salle = salle;
	this.thematique = thematique;
	this.equipe = equipe;
}


public int getIdDetailEquipe() {
	return idDetailEquipe;
}


public void setIdDetailEquipe(int idDetailEquipe) {
	this.idDetailEquipe = idDetailEquipe;
}


public int getSalle() {
	return salle;
}


public void setSalle(int salle) {
	this.salle = salle;
}


public String getThematique() {
	return thematique;
}


public void setThematique(String thematique) {
	this.thematique = thematique;
}


public Equipe getEquipe() {
	return equipe;
}


public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public DetailEquipe() {
}

	
}
