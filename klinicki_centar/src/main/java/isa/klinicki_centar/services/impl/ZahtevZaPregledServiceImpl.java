package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;
import isa.klinicki_centar.services.ZahtevZaPregledService;

public class ZahtevZaPregledServiceImpl implements ZahtevZaPregledService {

	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	@Override
	public Iterable<ZahtevZaPregled> findAll() {
		return zahtevZaPregledRepository.findAll();
	}

	@Override
	public ZahtevZaPregled findOne(Integer id) {
		return zahtevZaPregledRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled) {
		return zahtevZaPregledRepository.save(zahtevZaPregled);
	}

	@Override
	public void remove(Integer id) {
		zahtevZaPregledRepository.deleteById(id);
	}

}
