package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.repositories.PacijentSortRepository;
import isa.klinicki_centar.services.PacijentService;

@Service
public class PacijentServiceImpl implements PacijentService{

	@Autowired
	private PacijentRepository pacijentRepository;
	
	@Autowired
	private PacijentSortRepository pacijentSortRepository;
	
	@Override
	public Iterable<Pacijent> findAll() {
		// TODO Auto-generated method stub
		return pacijentRepository.findAll();
	}

	@Override
	public Pacijent findOne(Integer id) {
		// TODO Auto-generated method stub
		return pacijentRepository.findById(id).orElseGet(null);
	}

	@Override
	public Pacijent save(Pacijent pacijent) {
		// TODO Auto-generated method stub
		return pacijentRepository.save(pacijent);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		pacijentRepository.deleteById(id);
	}

	@Override
	public Iterable<Pacijent> findAllSortedByIme() {
		// TODO Auto-generated method stub
		return pacijentSortRepository.findAll(Sort.by("ime"));
		
	}

	@Override
	public Iterable<Pacijent> findAllSortedByBroj_Osiguranika() {
		// TODO Auto-generated method stub
		return null;
	}

}
