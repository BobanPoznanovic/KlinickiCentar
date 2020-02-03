package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.services.PacijentService;

@Service
public class PacijentServiceImpl implements PacijentService{

	@Autowired
	private PacijentRepository pacijentRepository;
	
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

}
