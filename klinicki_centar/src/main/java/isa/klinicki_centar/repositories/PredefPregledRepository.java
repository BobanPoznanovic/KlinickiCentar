package isa.klinicki_centar.repositories;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.model.PredefPregled;

@Repository
public interface PredefPregledRepository extends JpaRepository<PredefPregled, Integer> {

	//@Transactional
   // @Modifying
    //@Query(value = "UPDATE db.medical_examination SET confirmed = true, patient_id = :patientId WHERE id = :examinationId", nativeQuery = true)
    //void zakaziPredefinisanPregled(Integer predefPregledID, Integer pacijentID);
	
	@Query(value = "SELECT * FROM db_example.predef_pregled pp WHERE pp.klinikaID=?1", nativeQuery = true)
	ArrayList<PredefPregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID);
	
}
