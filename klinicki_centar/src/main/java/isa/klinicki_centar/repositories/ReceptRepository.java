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
}
