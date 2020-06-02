package isa.klinicki_centar.services;

import isa.klinicki_centar.model.PredefPregled;

public interface PredefPregledService {
	
	Iterable<PredefPregled> findAll();
	
	PredefPregled findOne(Integer id);
	
	PredefPregled save(PredefPregled predefPregled);
	
	void remove(Integer id);			
	
}
