package isa.klinicki_centar.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import isa.klinicki_centar.model.Operacija;

public interface OperacijaService {

	Iterable<Operacija> findAll();
	
	Operacija findOne(Integer id);
	
	Operacija save(Operacija operacija);
	
	void remove(Integer id);
	
	List<Operacija> fromDate(String date);
	
	List<Operacija> byDateAndSalaID(String date, Integer salaID);
	
	List<Operacija> byDateAndSalaIDSortedByStartTime(String date, Integer salaID);
	
	void lekarOcenjenZaOperaciju(Integer operacijaID);
	
	void klinikaOcenjenaZaOperaciju(Integer operacijaID);
	
	ArrayList<Operacija> nadjiSvePacijentoveOperacije(Integer pacijentID);
	
	ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(Integer pacijentID, Date datumOperacije);
	
	ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(Integer pacijentID);
	
	ArrayList<Operacija> sortOperacijePoDatumu();
}
