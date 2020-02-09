package isa.klinicki_centar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.klinicki_centar.model.Operacija;

public interface OperacijaAdvanceRepository extends JpaRepository<Operacija, Integer>{

	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1", nativeQuery = true)
	List<Operacija> fromDate(String date);
	
	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1 AND salaID = ?2", nativeQuery = true)
	List<Operacija> byDateAndSalaID(String date, Integer salaID);
	
	@Query(value = "select * from operacija where DATE(datum_operacije) = ?1 AND salaID = ?2 order by time(satnica_pocetka_operacije)", nativeQuery = true)
	List<Operacija> byDateAndSalaIDSortedByStartTime(String date, Integer salaID);
}
