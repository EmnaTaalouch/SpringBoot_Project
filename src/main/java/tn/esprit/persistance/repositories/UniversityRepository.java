package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Universite;
@Repository
public interface UniversityRepository extends JpaRepository<Universite, Integer> {

}
