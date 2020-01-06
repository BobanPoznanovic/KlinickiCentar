package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Klinika;

public interface KlinikaService {

	Iterable<Klinika> findAll();
	
	Klinika save(Klinika klinika);
}
