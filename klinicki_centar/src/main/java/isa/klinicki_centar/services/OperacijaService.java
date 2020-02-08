package isa.klinicki_centar.services;

import java.util.List;

import isa.klinicki_centar.model.Operacija;

public interface OperacijaService {

	Iterable<Operacija> findAll();
	
	Operacija findOne(Integer id);
	
	Operacija save(Operacija operacija);
	
	void remove(Integer id);
	
	List<Operacija> fromDate(String date);
	
	List<Operacija> byDataAndSalaID(String date, Integer salaID);
}