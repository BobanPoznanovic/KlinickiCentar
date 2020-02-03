package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Sala;

public interface SalaService {

	Iterable<Sala> findAll();
	
	Sala findOne(Integer id);
	
	Sala save(Sala sala);

	void remove(Integer id);
}
