package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Lekar;

public interface LekarService {

	Iterable<Lekar> findAll();
	
	Lekar findOne(Integer id);
	
	Lekar save(Lekar lekar);
	
	void remove(Integer id);
}
