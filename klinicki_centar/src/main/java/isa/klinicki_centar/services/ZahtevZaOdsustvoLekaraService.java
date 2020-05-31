package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZahtevZaOdsustvoLekar;

public interface ZahtevZaOdsustvoLekaraService {

	Iterable<ZahtevZaOdsustvoLekar> findAll();
	
	ZahtevZaOdsustvoLekar findOne(Integer id);
	
	ZahtevZaOdsustvoLekar save(ZahtevZaOdsustvoLekar zahtev);
	
	void remove(Integer id);
}
