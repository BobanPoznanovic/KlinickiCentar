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
		return klinikaRepository.findAll();
	}

	@Override
	public Klinika save(Klinika klinika) {
		return klinikaRepository.save(klinika);
	}

	@Override
	public Klinika findOne(Integer id) {
		return klinikaRepository.findById(id).orElseGet(null);
	}

	@Override
	public void remove(Integer id) {
		klinikaRepository.deleteById(id);
	}

	@Override
	public Klinika findByNazivOrGrad(String nazivOrGrad) {
		return klinikaRepository.findByNazivOrGrad(nazivOrGrad);
	}


}
