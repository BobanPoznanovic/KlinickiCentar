package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.ZahtevZaDodeluSale;
import isa.klinicki_centar.repositories.ZahtevZaDodeluSaleRepository;
import isa.klinicki_centar.services.ZahtevZaDodeluSaleService;

@Service
public class ZahtevZaDodeluSaleServiceImpl implements ZahtevZaDodeluSaleService {

	@Autowired
	private ZahtevZaDodeluSaleRepository zahtevZaDodeluSaleRepository;
	
	@Override
	public Iterable<ZahtevZaDodeluSale> findAll() {
		// TODO Auto-generated method stub
		return zahtevZaDodeluSaleRepository.findAll();
	}

	@Override
	public ZahtevZaDodeluSale findOne(Integer id) {
		// TODO Auto-generated method stub
		return zahtevZaDodeluSaleRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaDodeluSale save(ZahtevZaDodeluSale zahtev) {
		// TODO Auto-generated method stub
		return zahtevZaDodeluSaleRepository.save(zahtev);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		zahtevZaDodeluSaleRepository.deleteById(id);
	}

}
