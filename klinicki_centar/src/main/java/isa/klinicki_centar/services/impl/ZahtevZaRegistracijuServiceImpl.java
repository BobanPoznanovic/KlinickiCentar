package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.ZahtevZaRegistraciju;
import isa.klinicki_centar.repositories.ZahtevZaRegistracijuRepository;
import isa.klinicki_centar.services.ZahtevZaRegistracijuService;

@Service
public class ZahtevZaRegistracijuServiceImpl implements ZahtevZaRegistracijuService {
	
	@Autowired
	private ZahtevZaRegistracijuRepository zahtevZaRegistracijuRepository;

	@Override
	public Iterable<ZahtevZaRegistraciju> findAll() {
		// TODO Auto-generated method stub
		return zahtevZaRegistracijuRepository.findAll();
	}

	@Override
	public ZahtevZaRegistraciju findOne(Integer id) {
		// TODO Auto-generated method stub
		return zahtevZaRegistracijuRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaRegistraciju save(ZahtevZaRegistraciju zahtev) {
		// TODO Auto-generated method stub
		return zahtevZaRegistracijuRepository.save(zahtev);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		zahtevZaRegistracijuRepository.deleteById(id);
	}

	@Override
	public Iterable<ZahtevZaRegistraciju> nonProcessed(String status) {
		// TODO Auto-generated method stub
		
		return zahtevZaRegistracijuRepository.findNonProcessed(status);
	}
	
	

}
