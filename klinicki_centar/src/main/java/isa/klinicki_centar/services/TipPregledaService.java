package isa.klinicki_centar.services;

import isa.klinicki_centar.model.TipPregleda;;

public interface TipPregledaService {

	Iterable<TipPregleda> findAll();
	
	TipPregleda findOne(Integer id);
	
	TipPregleda save(TipPregleda sala);

	void remove(Integer id);
	
}
