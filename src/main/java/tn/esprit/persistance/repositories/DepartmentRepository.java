package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Departement;
@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

}
