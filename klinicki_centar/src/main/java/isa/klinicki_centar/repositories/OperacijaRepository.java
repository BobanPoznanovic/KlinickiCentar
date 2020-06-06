package isa.klinicki_centar.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.Operacija;

public interface OperacijaRepository extends CrudRepository<Operacija, Integer> {

	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1", nativeQuery = true)
	List<Operacija> fromDate(String date);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekara(Integer id);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1 AND o.datum_operacije = ?2", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekaraPoDatumu(Integer id, Date datum);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1 AND o.datum_operacije BETWEEN ?2 AND ?3", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekaraUNekomPeriodu(Integer id, Date pocetak, Date kraj);
}
