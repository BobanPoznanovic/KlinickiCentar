package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Klinika;

public interface KlinikaService {

	Iterable<Klinika> findAll();
	
	Klinika findOne(Integer id);
	
	Klinika save(Klinika klinika);
	
	Klinika findByNazivOrGrad(String nazivOrGrad);
	
	void remove(Integer id);
}
