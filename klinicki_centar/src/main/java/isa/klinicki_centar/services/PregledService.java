package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Pregled;

public interface PregledService {

	Iterable<Pregled> findAll();
	
	Pregled findOne(Integer id);
	
	Pregled save(Pregled pregled);
	
	void remove(Integer id);
}
