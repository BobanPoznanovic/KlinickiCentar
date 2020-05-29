package isa.klinicki_centar.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.Lekar;

@Repository
public interface LekarRepository extends JpaRepository<Lekar, Integer>{
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenu(String ime);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.prezime = ?1", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoPrezimenu(String prezime);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.prosecna_ocena >= ?1", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoOceni(float ocena);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.klinikaID = ?1", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoKliniciUKojojSeNalazi(Integer klinikaID);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.prezime = ?2", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenu(String ime, String prezime);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_ID = ?2)", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuITipuPregleda(String ime, Integer tipPregledaID);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.prezime = ?2 AND l.prosecna_ocena >= ?3", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceni(String ime, String prezime, float prosecnaOcena);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.prezime = ?2 AND l.prosecna_ocena >= ?3 AND l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_ID = ?4)", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 OR l.prezime = ?2 AND l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_ID = ?3)", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuITipuPregleda(String ime, String prezime, Integer tipPregledaID);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.prezime = ?2 AND l.prosecna_ocena >= ?3 AND l.klinikaID IN (SELECT klinikaID FROM lekar lek WHERE lek.lekarID = ?4)", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraIzKlinike(String ime, String prezime, float prosecnaOcena, Integer lekarIDuKlinici);
	
	@Query(value = "SELECT * FROM lekar l WHERE l.klinikaID = ?5 AND l.ime = ?1 AND l.prezime = ?2 AND l.prosecna_ocena >= ?3 AND l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_ID = ?4)", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraAdvanced(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID, Integer klinikaID);
	
}
