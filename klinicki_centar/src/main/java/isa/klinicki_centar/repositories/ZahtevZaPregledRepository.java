package isa.klinicki_centar.repositories;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.ZahtevZaPregled;

@Repository
public interface ZahtevZaPregledRepository extends JpaRepository<ZahtevZaPregled, Integer> {

	@Lock(LockModeType.PESSIMISTIC_READ)
    @Override
    ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled);
	
    @Query(value = "SELECT * FROM zahtev_za_pregled zzp WHERE zzp.lekarID = ?1 AND zzp.datum = ?2", nativeQuery = true)
	ArrayList<ZahtevZaPregled> nadjiLekaroveZahtevePoDatumu(Integer lekarID, Date datum);
    
    @Query(value = "SELECT * FROM zahtev_za_pregled zzp WHERE zzp.lekarID = ?1 AND zzp.datum BETWEEN ?2 AND ?3", nativeQuery = true)
	ArrayList<ZahtevZaPregled> nadjiLekaroveZahteveUNekomPeriodu(Integer lekarID, Date pocetak, Date kraj);
	
}
