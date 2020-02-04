package isa.klinicki_centar.services;

import isa.klinicki_centar.model.IzvestajPregleda;

public interface IzvestajPregledaService {

	Iterable<IzvestajPregleda> findAll();
	
	IzvestajPregleda findOne(Integer id);
	
	IzvestajPregleda save(IzvestajPregleda izvestaj);
	
	void remove(Integer id);
}
