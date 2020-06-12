package isa.klinicki_centar.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;

public interface SpisakLekaraNaOperacijiRepository extends CrudRepository<SpisakLekaraNaOperaciji, Integer> {
	
	@Query(value = "SELECT * FROM spisak_lekara_na_operaciji sl WHERE sl.lekarID = ?1", nativeQuery = true)
	ArrayList<SpisakLekaraNaOperaciji> findByLekarID(Integer lekarID);

}
