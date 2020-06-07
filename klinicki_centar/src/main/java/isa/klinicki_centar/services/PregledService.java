package isa.klinicki_centar.services;

import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import isa.klinicki_centar.model.Pregled;

public interface PregledService {

	Iterable<Pregled> findAll();
	
	Pregled findOne(Integer id);
	
	Pregled save(Pregled pregled);
	
	void remove(Integer id);
	
	List<Pregled> byDateAndSalaID(String date, Integer salaID);
	
	List<Pregled> byDate(String date);
	
	List<Pregled> byDateAndSalaIDSortedByStartTime(String date, Integer salaID);
	
	ArrayList<Pregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID);
	
	void zakaziPredefinisanPregled(Integer pregledID, Integer pacijentID);
	
	void potvrditiZakazanPregled(Integer pregledID);
	
	void odbitiZakazanPregled(Integer pregledID);
	
	void zavrsiPregled(Integer pregledID);
	
	void doktorOcenjenZaPregled(Integer pregledID);
	
	void klinikaOcenjenaZaPregled(Integer pregledID);
	
	ArrayList<Pregled> nadjiSvePredefinisanePreglede();
	
	ArrayList<Pregled> sviDoktoroviPregledi(Integer lekarID);
	
	ArrayList<Pregled> sviDoktoroviPreglediTrazenogDatuma(Integer lekarID, Date datum) throws ParseException;
	
	ArrayList<Pregled> sviDoktoroviPreglediPoDatumu(Integer lekarID, Date pocetak, Date kraj) throws ParseException;
	
	ArrayList<Pregled> sviPreglediNaKliniciTrazenogDatuma(Integer klinikaID, Date datum) throws ParseException;
	
	Collection<String> nadjiSlobodneTermineLekara(Integer lekarID, String datum) throws ParseException;
	
	ArrayList<Pregled> nadjiSvePacijentovePreglede(Integer pacijentID);
	
	ArrayList<Pregled> nadjiSvePregledaZaOcenjivanje(Integer pacijentID);

}
