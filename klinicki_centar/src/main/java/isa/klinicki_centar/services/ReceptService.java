package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Recept;

public interface ReceptService {

	Iterable<Recept> findAll();
	
	Recept findOne(Integer id);
	
	Recept save(Recept recept);
	
	void remove(Integer id);
	
	Iterable<Recept> findByOveren(Boolean status);
	
	Iterable<Recept> findAllNeovereniByPregledID(Integer pregledID);
	
	Iterable<Recept> findAllNeovereniByKlinika(Integer id);
}
