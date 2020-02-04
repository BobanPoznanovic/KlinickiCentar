package isa.klinicki_centar.services;

import isa.klinicki_centar.model.ZahtevZaDodeluSale;

public interface ZahtevZaDodeluSaleService {

	Iterable<ZahtevZaDodeluSale> findAll();
	
	ZahtevZaDodeluSale findOne(Integer id);
	
	ZahtevZaDodeluSale save(ZahtevZaDodeluSale zahtev);
	
	void remove(Integer id);
}
