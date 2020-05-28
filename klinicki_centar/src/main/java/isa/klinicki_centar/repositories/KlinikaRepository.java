package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.Klinika;

@Repository
public interface KlinikaRepository extends JpaRepository<Klinika, Integer>{
	
	@Query(value = "SELECT * FROM `db_example`.`klinika` k WHERE (k.naziv = ?1 OR k.grad = ?1)", nativeQuery = true)
	Klinika findByNazivOrGrad(String nazivOrGrad);
	
	

	
}
