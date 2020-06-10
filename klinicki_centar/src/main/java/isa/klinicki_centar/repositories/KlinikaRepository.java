package isa.klinicki_centar.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.model.Klinika;

@Repository
public interface KlinikaRepository extends JpaRepository<Klinika, Integer>{
	
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
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE klinika k SET k.prosecna_ocena = ?2, k.broj_ocena = ?3 WHERE k.klinikaID = ?1", nativeQuery = true)
    void updateRatingKlinika(Integer klinikaID, float prosecnaOcena, int brojOcena);
	
	@Query(value = "SELECT * FROM db_example.klinika ORDER BY naziv", nativeQuery = true)
	ArrayList<Klinika> sortKlinikePoNazivu();
	
	@Query(value = "SELECT * FROM db_example.klinika ORDER BY adresa", nativeQuery = true)
	ArrayList<Klinika> sortKlinikePoAdresi();
	
	@Query(value = "SELECT * FROM db_example.klinika ORDER BY grad", nativeQuery = true)
	ArrayList<Klinika> sortKlinikePoGradu();
	
	@Query(value = "SELECT * FROM db_example.klinika ORDER BY prosecna_ocena", nativeQuery = true)
	ArrayList<Klinika> sortKlinikePoOceni();
	
}
