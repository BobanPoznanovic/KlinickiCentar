package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.repositories.DijagnozaRepository;
import isa.klinicki_centar.services.DijagnozaService;

@Service
public class DijagnozaServiceImpl implements DijagnozaService {
	
	private DijagnozaRepository dijagnozaRepository;

	@Override
	public ArrayList<Dijagnoza> findAll() {
		
		Iterator<Dijagnoza> iterator = dijagnozaRepository.findAll().iterator();
		
		ArrayList<Dijagnoza> dijagnoze = new ArrayList<Dijagnoza>();
		
		if(iterator.hasNext()) {
			dijagnoze.add(iterator.next());
		}
		
		return dijagnoze;
	}

}
