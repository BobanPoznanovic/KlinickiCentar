package isa.klinicki_centar.services;

import java.util.List;

import isa.klinicki_centar.model.Pregled;

public interface PregledService {

	Iterable<Pregled> findAll();
	
	Pregled findOne(Integer id);
	
	Pregled save(Pregled pregled);
	
	void remove(Integer id);
	
	List<Pregled> byDateAndSalaID(String date, Integer salaID);
}
