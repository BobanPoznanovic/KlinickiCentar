package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Recept;
import isa.klinicki_centar.repositories.ReceptRepository;
import isa.klinicki_centar.services.ReceptService;

@Service
public class ReceptServicesImpl implements ReceptService {

	@Autowired
	private ReceptRepository receptRepository;
	
	@Override
	public Iterable<Recept> findAll() {
		// TODO Auto-generated method stub
		return receptRepository.findAll();
	}

	@Override
	public Recept findOne(Integer id) {
		// TODO Auto-generated method stub
		return receptRepository.findById(id).orElse(null);
	}

	@Override
	public Recept save(Recept recept) {
		// TODO Auto-generated method stub
		return receptRepository.save(recept);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		receptRepository.deleteById(id);
	}

	@Override
	public Iterable<Recept> findByOveren(Boolean status) {
		// TODO Auto-generated method stub
		if(status == true) {
			return receptRepository.findByOveren(true);
		}
		else
			return receptRepository.findByOveren(false);
	}

}
