package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.AdminKlinike;

@Repository
public interface AdminKlinikeRepository extends JpaRepository<AdminKlinike, Integer>{

	@Query(value = "SELECT * FROM db_example.admin_klinike WHERE klinikaID = ?1", nativeQuery = true)
	AdminKlinike nadjiAdminaKlinike(Integer klinikaID);
	
}
