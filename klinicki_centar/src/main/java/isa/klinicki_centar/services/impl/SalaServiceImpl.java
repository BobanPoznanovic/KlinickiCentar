package isa.klinicki_centar.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.repositories.SalaRepository;
import isa.klinicki_centar.services.SalaService;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {
	
	@Autowired
	private SalaRepository salaRepository;

	@Override
	public Iterable<Sala> findAll() {
		// TODO Auto-generated method stub
		return salaRepository.findAll();
	}

	@Override
	@Transactional
	public Sala findOne(Integer id) {
		// TODO Auto-generated method stub
		return salaRepository.findById(id).orElseGet(null);
	}

	@Override
	public Sala save(Sala sala) {
		// TODO Auto-generated method stub
		return salaRepository.save(sala);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		salaRepository.deleteById(id);
	}

}
