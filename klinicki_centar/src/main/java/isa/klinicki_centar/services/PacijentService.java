package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Pacijent;

public interface PacijentService {

	Iterable<Pacijent> findAll();
	
	Pacijent findOne(Integer id);
	
	Pacijent save(Pacijent pacijent);
	
	void remove(Integer id);
	
	Iterable<Pacijent> findAllSortedByIme();
	
	Iterable<Pacijent> findAllSortedByBroj_Osiguranika();
}
