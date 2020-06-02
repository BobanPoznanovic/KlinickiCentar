package isa.klinicki_centar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.klinicki_centar.model.ZahtevZaPregled;

@Repository
public interface ZahtevZaPregledRepository extends JpaRepository<ZahtevZaPregled, Integer> {

}
