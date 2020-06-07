package isa.klinicki_centar.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.model.Operacija;

@Repository
public interface OperacijaRepository extends JpaRepository<Operacija, Integer> {

	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1", nativeQuery = true)
	List<Operacija> fromDate(String date);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekara(Integer id);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1 AND o.datum_operacije = ?2", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekaraPoDatumu(Integer id, Date datum);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.lekarID = ?1 AND o.datum_operacije BETWEEN ?2 AND ?3", nativeQuery = true)
	ArrayList<Operacija> nadjiOperacijeLekaraUNekomPeriodu(Integer id, Date pocetak, Date kraj);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE operacija SET lekar_ocenjen = true WHERE operacijaID = ?1", nativeQuery = true)
	void lekarOcenjenZaOperaciju(Integer operacijaID);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE operacija SET klinika_ocenjena = true WHERE operacijaID = ?1", nativeQuery = true)
	void klinikaOcenjenaZaOperaciju(Integer operacijaID);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.pacijentID = ?1", nativeQuery = true)
	ArrayList<Operacija> nadjiSvePacijentoveOperacije(Integer pacijentID);
	
	@Query(value = "SELECT * FROM operacija o WHERE o.pacijentID = ?1 AND o.datum_operacije < ?2", nativeQuery = true)
	ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(Integer pacijentID, Date datumOperacije);
}
