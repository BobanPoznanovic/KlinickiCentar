package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import isa.klinicki_centar.model.Pacijent;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent, Integer> {
	
	@Query(value = "SELECT * FROM pacijent WHERE email = ?1", nativeQuery = true)
	Pacijent findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE pacijent SET aktivan = TRUE WHERE pacijentID = ?1", nativeQuery = true)
	void activatePatientAccount(Integer id);
}
