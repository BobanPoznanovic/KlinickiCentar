package isa.klinicki_centar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.Pregled;

public interface PregledRepository extends CrudRepository<Pregled, Integer>{

	@Query(value = "select * from pregled where DATE(datum_pregleda) = ?1 AND salaID = ?2", nativeQuery = true)
	List<Pregled> byDateAndSalaID(String date, Integer salaID);
}