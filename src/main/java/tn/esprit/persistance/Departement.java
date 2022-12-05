package tn.esprit.persistance;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Departement")
public class Departement implements Serializable{
	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    @Column(name="idDepartement")
	    private Integer idDepart; // Clé primaire
	    private String nomDepart;
	      
	     @OneToMany(mappedBy = "departement")
	     
	     private Set<Etudiant> etudiants ; 
	     
		public Departement() {
		}

		public Departement(Integer idDepart, String nomDepart, Set<Etudiant> etudiants) {
			super();
			this.idDepart = idDepart;
			this.nomDepart = nomDepart;
			this.etudiants = etudiants;
		}

		
		public Integer getIdDepart() {
			return idDepart;
		}

		public void setIdDepart(Integer idDepart) {
			this.idDepart = idDepart;
		}

		public String getNomDepart() {
			return nomDepart;
		}

		public void setNomDepart(String nomDepart) {
			this.nomDepart = nomDepart;
		}

		@Override
		public String toString() {
			return "Departement [idDepart=" + idDepart + ", nomDepart=" + nomDepart + "]";
		}
		
	    
}
