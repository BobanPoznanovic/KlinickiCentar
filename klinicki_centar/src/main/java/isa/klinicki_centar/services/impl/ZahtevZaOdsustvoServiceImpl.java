package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.ZahtevZaOdsustvo;
import isa.klinicki_centar.repositories.ZahtevZaOdsustvoRepository;
import isa.klinicki_centar.services.ZahtevZaOdsustvoService;

@Service
public class ZahtevZaOdsustvoServiceImpl implements ZahtevZaOdsustvoService{

	@Autowired
	private ZahtevZaOdsustvoRepository zahtevZaOdsustvoRepository;
	
	@Override
	public Iterable<ZahtevZaOdsustvo> findAll() {
		// TODO Auto-generated method stub
		return zahtevZaOdsustvoRepository.findAll();
	}

	@Override
	public ZahtevZaOdsustvo findOne(Integer id) {
		// TODO Auto-generated method stub
		return zahtevZaOdsustvoRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaOdsustvo save(ZahtevZaOdsustvo zahtev) {
		// TODO Auto-generated method stub
		return zahtevZaOdsustvoRepository.save(zahtev);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		zahtevZaOdsustvoRepository.deleteById(id);
	}

}
