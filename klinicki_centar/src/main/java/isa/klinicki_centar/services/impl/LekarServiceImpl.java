package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.services.LekarService;

@Service
public class LekarServiceImpl implements LekarService{

	@Autowired
	private LekarRepository lekarRepository;
	
	@Override
	public Iterable<Lekar> findAll() {
		// TODO Auto-generated method stub
		return lekarRepository.findAll();
	}

	@Override
	public Lekar findOne(Integer id) {
		// TODO Auto-generated method stub
		return lekarRepository.findById(id).orElseGet(null);
	}

	@Override
	public Lekar save(Lekar lekar) {
		// TODO Auto-generated method stub
		return lekarRepository.save(lekar);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		lekarRepository.deleteById(id);
	}

}
