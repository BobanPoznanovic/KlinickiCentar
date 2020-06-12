package isa.klinicki_centar.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.Recept;

@Repository
public interface ReceptRepository extends CrudRepository<Recept, Integer> {

	@Query(value = "SELECT * FROM recept r WHERE r.overen = ?1", nativeQuery = true)
	ArrayList<Recept> findByOveren(Boolean status);
	
	@Query(value = "SELECT * FROM recept r WHERE r.izvestaj_pregledaID = ?1 AND r.overen = false", nativeQuery = true)
	ArrayList<Recept> findNeovereniByIzvestajID(Integer id);
	
	@Query(value = "SELECT * FROM recept r WHERE r.izvestaj_pregledaID = ?1", nativeQuery = true)
	ArrayList<Recept> findByIzvestajID(Integer id);
}
