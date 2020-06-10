package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.IzvestajPregleda;

public interface IzvestajPregledaRepository extends CrudRepository<IzvestajPregleda, Integer>{
	
	@Query(value = "SELECT * FROM izvestaj_pregleda i WHERE i.pregledID = ?1", nativeQuery = true)
	IzvestajPregleda findByPregledID(Integer id);

}
