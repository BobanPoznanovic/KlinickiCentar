package isa.klinicki_centar.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import isa.klinicki_centar.model.ZahtevZaRegistraciju;

public interface ZahtevZaRegistracijuRepository extends CrudRepository<ZahtevZaRegistraciju, Integer>{
	
	@Query(value = "SELECT * FROM zahtev_za_registraciju z WHERE z.status_zahteva = ?1", nativeQuery = true)
	ArrayList<ZahtevZaRegistraciju> findNonProcessed(String status);

}
