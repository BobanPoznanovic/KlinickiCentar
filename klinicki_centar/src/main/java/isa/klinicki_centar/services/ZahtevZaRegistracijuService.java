package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZahtevZaRegistraciju;

public interface ZahtevZaRegistracijuService {

	Iterable<ZahtevZaRegistraciju> findAll();
	
	ZahtevZaRegistraciju findOne(Integer id);
	
	ZahtevZaRegistraciju save(ZahtevZaRegistraciju zahtev);
	
	void remove(Integer id);
}
