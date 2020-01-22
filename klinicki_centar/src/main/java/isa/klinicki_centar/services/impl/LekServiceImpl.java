package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import isa.klinicki_centar.model.Lek;
import isa.klinicki_centar.repositories.LekRepository;
import isa.klinicki_centar.services.LekService;

public class LekServiceImpl implements LekService{
	
	@Autowired
	private LekRepository lekRepository;

	@Override
	public Iterable<Lek> findAll() {
		// TODO Auto-generated method stub
		return lekRepository.findAll();
	}

	@Override
	public Lek findOne(Integer id) {
		// TODO Auto-generated method stub
		return lekRepository.findById(id).orElseGet(null);
	}

	@Override
	public Lek save(Lek lek) {
		// TODO Auto-generated method stub
		return lekRepository.save(lek);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		lekRepository.deleteById(id);
	}

}
