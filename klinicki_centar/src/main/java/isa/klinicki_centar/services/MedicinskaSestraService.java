package isa.klinicki_centar.services;

import isa.klinicki_centar.model.MedicinskaSestra;

public interface MedicinskaSestraService {

	Iterable<MedicinskaSestra> findAll();
	
	MedicinskaSestra findOne(Integer id);
	
	MedicinskaSestra save(MedicinskaSestra medicinskaSestra);

	void remove(Integer id);
}
