package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.repositories.PregledRepository;
import isa.klinicki_centar.services.PregledService;

@Service
public class PregledServiceImpl implements PregledService{

	@Autowired
	private PregledRepository pregledRepository;
	
	@Override
	public Iterable<Pregled> findAll() {
		// TODO Auto-generated method stub
		return pregledRepository.findAll();
	}

	@Override
	public Pregled findOne(Integer id) {
		// TODO Auto-generated method stub
		return pregledRepository.findById(id).orElseGet(null);
	}

	@Override
	public Pregled save(Pregled pregled) {
		// TODO Auto-generated method stub
		return pregledRepository.save(pregled);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		pregledRepository.deleteById(id);
	}

}
