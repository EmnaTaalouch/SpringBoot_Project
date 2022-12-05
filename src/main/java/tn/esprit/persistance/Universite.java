package tn.esprit.persistance;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="University")
public class Universite implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idUniveriste")
	private int idUniv ; 
	private String nomUniv  ;
	@OneToMany
	private Set<Departement> departments ;
	public Universite() {
	}
	public Universite(int idUniv, String nomUniv) {
		this.nomUniv = nomUniv;
	}
	public int getIdUniv() {
		return idUniv;
	}
	
	public String getNomUniv() {
		return nomUniv;
	}
	public void setNomUniv(String nomUniv) {
		this.nomUniv = nomUniv;
	}
	@Override
	public String toString() {
		return "Universite [idUniv=" + idUniv + ", nomUniv=" + nomUniv + "]";
	} 

}
