package isa.klinicki_centar.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.Klinika;

public interface KlinikaRepository extends CrudRepository<Klinika, Integer>{
	
	@Query(value = "SELECT * FROM `db_example`.`klinika` k WHERE (k.naziv = ?1 OR k.grad = ?1)", nativeQuery = true)
	Klinika findByNazivOrGrad(String nazivOrGrad);
	
	
	
//	@Query(value = "", nativeQuery = true)
//	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIDatumu(@Param("tipPregledaID") Integer tipPregledaID, @Param("datum") Date datum);
	
	
	
	
	@Query(value = "SELECT * FROM db_example.klinika k WHERE k.klinikaID IN ( SELECT l.klinikaID FROM lekar l WHERE l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_id = ?1) )", nativeQuery = true)
	ArrayList<Klinika> nadjiKlinikePoTipuPregleda(@Param("tipPregledaID") Integer tipPregledaID);
	
	@Query(value = "SELECT * FROM db_example.klinika k WHERE k.prosecna_ocena >= ?2 AND k.klinikaID IN (SELECT l.klinikaID FROM lekar l WHERE l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_id = ?1))", nativeQuery = true)
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIOceni(@Param("tipPregledaID") Integer tipPregledaID, @Param("ocena") float ocena);
	
	@Query(value = "SELECT * FROM db_example.klinika k WHERE k.grad = ?2 AND k.klinikaID IN (SELECT l.klinikaID FROM lekar l WHERE l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_id = ?1))", nativeQuery = true)
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaIGradu(@Param("tipPregledaID") Integer tipPregledaID, @Param("grad") String grad);
	
	@Query(value = "SELECT * FROM db_example.klinika k WHERE k.grad = ?2 AND k.prosecna_ocena = ?3 AND k.klinikaID IN (SELECT l.klinikaID FROM lekar l WHERE l.lekarID IN (SELECT tpl.lekar_id FROM tipovi_pregleda_lekara tpl WHERE tpl.tip_pregleda_id = ?1))", nativeQuery = true)
	ArrayList<Klinika> nadjiKlinikePoTipuPregledaGraduIOceni(@Param("tipPregledaID") Integer tipPregledaID, @Param("grad") String grad, @Param("ocena") float ocena);
	
	
}
