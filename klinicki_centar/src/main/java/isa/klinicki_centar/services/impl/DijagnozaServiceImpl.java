package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

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
	public Dijagnoza insertData(Dijagnoza dijagnoza) {
		// TODO Auto-generated method stub
		
		dijagnozaRepository.save(dijagnoza);
		
		return null;
	}

}
