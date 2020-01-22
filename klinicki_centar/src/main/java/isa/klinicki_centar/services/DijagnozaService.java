package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Dijagnoza;

public interface DijagnozaService {
	
	Iterable<Dijagnoza> findAll();
	
	Dijagnoza findOne(Integer id);
	
	Dijagnoza save(Dijagnoza dijagnoza);

	void remove(Integer id);
}
