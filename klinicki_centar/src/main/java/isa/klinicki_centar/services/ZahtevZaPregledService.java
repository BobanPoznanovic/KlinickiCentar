package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZahtevZaPregled;

public interface ZahtevZaPregledService {

	Iterable<ZahtevZaPregled> findAll();
	
	ZahtevZaPregled findOne(Integer id);
	
	ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled);
	
	void remove(Integer id);
	
}
