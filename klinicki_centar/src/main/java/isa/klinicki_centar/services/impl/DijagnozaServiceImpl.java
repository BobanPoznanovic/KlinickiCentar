package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.repositories.DijagnozaRepository;
import isa.klinicki_centar.services.DijagnozaService;

@Service
public class DijagnozaServiceImpl implements DijagnozaService {
	
	@Autowired
	private DijagnozaRepository dijagnozaRepository;

	@Override
	public Iterable<Dijagnoza> findAll() {
		
		return dijagnozaRepository.findAll();
	}


	@Override
	public Dijagnoza save(Dijagnoza dijagnoza) {
		// TODO Auto-generated method stub
		
		dijagnozaRepository.save(dijagnoza);
		
		return null;
	}

}
