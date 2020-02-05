package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.ZdravstveniKarton;
import isa.klinicki_centar.repositories.ZdravstveniKartonRepository;
import isa.klinicki_centar.services.ZdravstveniKartonService;

@Service
public class ZdravstveniKartonServiceImpl implements ZdravstveniKartonService{

	@Autowired
	private ZdravstveniKartonRepository zdravstveniKartonRepository;
	
	@Override
	public Iterable<ZdravstveniKarton> findAll() {
		// TODO Auto-generated method stub
		return zdravstveniKartonRepository.findAll();
	}

	@Override
	public ZdravstveniKarton findOne(Integer id) {
		// TODO Auto-generated method stub
		return zdravstveniKartonRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZdravstveniKarton save(ZdravstveniKarton karton) {
		// TODO Auto-generated method stub
		return zdravstveniKartonRepository.save(karton);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		zdravstveniKartonRepository.deleteById(id);
	}

}
