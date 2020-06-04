package isa.klinicki_centar.repositories;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.model.Pregled;

@Repository
public interface PregledRepository extends JpaRepository<Pregled, Integer>{

	@Query(value = "select * from pregled where DATE(datum_pregleda) = ?1 AND salaID = ?2", nativeQuery = true)
	List<Pregled> byDateAndSalaID(String date, Integer salaID);
	
	@Query(value = "select * from pregled where DATE(datum_pregleda) = ?1", nativeQuery = true)
	List<Pregled> byDate(String date);
	
	@Query(value = "select * from pregled where DATE(datum_pregleda) = ?1 AND salaID = ?2 order by time(satnica_pocetak)", nativeQuery = true)
	List<Pregled> byDateAndSalaIDSortedByStartTime(String date, Integer salaID);
	
	@Query(value = "SELECT * FROM pregled p WHERE p.kategorija_pregleda = 'Predefinisan' AND p.lekarID IN (SELECT l.lekarID FROM lekar l WHERE l.klinikaID = ?1);", nativeQuery = true)
	ArrayList<Pregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE pregled SET pacijentID = ?2 WHERE pregledID = ?1", nativeQuery = true)
	void zakaziPredefinisanPregled(Integer pregledID, Integer pacijentID);
	
	@Query(value = "SELECT * FROM pregled p WHERE p.kategorija_pregleda = 'Predefinisan' ", nativeQuery = true)
	ArrayList<Pregled> nadjiSvePredefinisanePreglede();
	
	@Query(value = "SELECT * FROM pregled p WHERE p.lekarID = ?1", nativeQuery = true)
	ArrayList<Pregled> sviDoktoroviPregledi(Integer lekarID);
	
	@Query(value = "SELECT * FROM pregled p WHERE p.lekarID = ?1 AND p.datum_pregleda = ?2", nativeQuery = true)
	ArrayList<Pregled> sviDoktoroviPreglediTrazenogDatuma(Integer lekarID, Date datum);
	
	@Query(value = "SELECT * FROM pregled p WHERE p.lekarID = ?1 AND p.datum_pregleda BETWEEN ?2 AND ?3", nativeQuery = true)
	ArrayList<Pregled> sviDoktoroviPreglediPoDatumu(Integer lekarID, Date pocetak, Date kraj);
	
	@Query(value = "SELECT * FROM pregled p WHERE p.datum_pregleda = ?2 AND p.lekarID IN (SELECT l.lekarID FROM lekar l WHERE l.klinikaID = ?1)", nativeQuery = true)
	ArrayList<Pregled> sviPreglediNaKliniciTrazenogDatuma(Integer klinikaID, Date datum);
	
}
