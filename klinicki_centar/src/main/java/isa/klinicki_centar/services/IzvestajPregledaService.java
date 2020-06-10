package isa.klinicki_centar.services;

import java.util.ArrayList;

import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.model.Pregled;

public interface IzvestajPregledaService {

	Iterable<IzvestajPregleda> findAll();
	
	IzvestajPregleda findOne(Integer id);
	
	IzvestajPregleda save(IzvestajPregleda izvestaj);
	
	void remove(Integer id);
	
	ArrayList<IzvestajPregleda> getIzvestajiByPregledID(ArrayList<Pregled> pregledi);
	
	IzvestajPregleda getIzvestajByPregledID(Integer pregledID);
}
