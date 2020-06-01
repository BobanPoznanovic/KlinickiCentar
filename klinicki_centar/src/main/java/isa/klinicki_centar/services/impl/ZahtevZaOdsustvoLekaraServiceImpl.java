package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.ZahtevZaOdsustvoLekar;
import isa.klinicki_centar.repositories.ZahtevZaOdsustvoLekaraRepository;
import isa.klinicki_centar.services.ZahtevZaOdsustvoLekaraService;

@Service
public class ZahtevZaOdsustvoLekaraServiceImpl implements ZahtevZaOdsustvoLekaraService {

	@Autowired
	private ZahtevZaOdsustvoLekaraRepository zahtevZaOdsustvoLekaraRepository;
	
	@Override
	public Iterable<ZahtevZaOdsustvoLekar> findAll() {
		return zahtevZaOdsustvoLekaraRepository.findAll();
	}

	@Override
	public ZahtevZaOdsustvoLekar findOne(Integer id) {
		return zahtevZaOdsustvoLekaraRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaOdsustvoLekar save(ZahtevZaOdsustvoLekar zahtev) {
		return zahtevZaOdsustvoLekaraRepository.save(zahtev);
	}

	@Override
	public void remove(Integer id) {
		zahtevZaOdsustvoLekaraRepository.deleteById(id);
	}

}
