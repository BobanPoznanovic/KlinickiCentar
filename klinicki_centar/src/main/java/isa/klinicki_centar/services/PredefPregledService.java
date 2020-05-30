package isa.klinicki_centar.services;

import java.util.ArrayList;
import java.util.Collection;

import isa.klinicki_centar.model.PredefPregled;

public interface PredefPregledService {
	
	Iterable<PredefPregled> findAll();
	
	PredefPregled findOne(Integer id);
	
	PredefPregled save(PredefPregled predefPregled);
	
	void remove(Integer id);

	void zakaziPredefinisanPregled(Integer predefPregledID, Integer pacijentID);
	
	ArrayList<PredefPregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID);
		
	
}
