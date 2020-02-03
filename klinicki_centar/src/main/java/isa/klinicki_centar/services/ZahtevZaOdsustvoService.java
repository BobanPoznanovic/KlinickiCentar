package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZahtevZaOdsustvo;

public interface ZahtevZaOdsustvoService {

	Iterable<ZahtevZaOdsustvo> findAll();
	
	ZahtevZaOdsustvo findOne(Integer id);
	
	ZahtevZaOdsustvo save(ZahtevZaOdsustvo zahtev);

	void remove(Integer id);
}
