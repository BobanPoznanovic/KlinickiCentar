package isa.klinicki_centar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.Operacija;

public interface OperacijaRepository extends CrudRepository<Operacija, Integer> {

	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1", nativeQuery = true)
	List<Operacija> fromDate(String date);
}
