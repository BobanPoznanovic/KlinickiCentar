package isa.klinicki_centar.services;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
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
	
	ArrayList<Pregled> nadjiPredefinisanePregledeKlinike2(Integer klinikaID);
	
	void zakaziPredefinisanPregled(Integer pregledID, Integer pacijentID);
	
	ArrayList<Pregled> nadjiSvePredefinisanePreglede();
	
	ArrayList<Pregled> sviDoktoroviPregledi(Integer lekarID);
	
	ArrayList<Pregled> sviDoktoroviPreglediTrazenogDatuma(Integer lekarID, Date datum) throws ParseException;
	
	ArrayList<Pregled> sviPreglediNaKliniciTrazenogDatuma(Integer klinikaID, Date datum) throws ParseException;
	
}
