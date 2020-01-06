package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.services.KlinikaService;

@Service
public class KlinikaServiceImpl implements KlinikaService {

	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Override
	public Iterable<Klinika> findAll() {
		// TODO Auto-generated method stub
		return klinikaRepository.findAll();
	}

	@Override
	public Klinika save(Klinika klinika) {
		// TODO Auto-generated method stub
		return klinikaRepository.save(klinika);
	}

}
