package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Lek;

public interface LekService {

	Iterable<Lek> findAll();
	
	Lek findOne(Integer id);
	
	Lek save(Lek lek);

	void remove(Integer id);
}
