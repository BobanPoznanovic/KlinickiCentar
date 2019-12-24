package isa.klinicki_centar.services;

import isa.klinicki_centar.model.Dijagnoza;

public interface DijagnozaService {
	
	Iterable<Dijagnoza> findAll();
	
	Dijagnoza insertData(Dijagnoza dijagnoza);

}
