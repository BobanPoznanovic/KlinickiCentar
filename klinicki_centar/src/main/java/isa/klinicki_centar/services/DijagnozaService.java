package isa.klinicki_centar.services;

import java.util.ArrayList;

import isa.klinicki_centar.model.Dijagnoza;

public interface DijagnozaService {
	
	Iterable<Dijagnoza> findAll();
	
	Dijagnoza insertData(Dijagnoza dijagnoza);

}
