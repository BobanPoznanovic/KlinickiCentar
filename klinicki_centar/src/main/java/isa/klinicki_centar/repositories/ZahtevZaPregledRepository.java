package isa.klinicki_centar.repositories;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.ZahtevZaPregled;

@Repository
public interface ZahtevZaPregledRepository extends JpaRepository<ZahtevZaPregled, Integer> {

	@Lock(LockModeType.PESSIMISTIC_READ)
    @Override
    ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled);
	
}
