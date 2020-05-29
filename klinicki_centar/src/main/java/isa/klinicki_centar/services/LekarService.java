package isa.klinicki_centar.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;

import isa.klinicki_centar.model.Lekar;

public interface LekarService {

	Iterable<Lekar> findAll();
	
	Lekar findOne(Integer id);
	
	Lekar save(Lekar lekar);
	
	void remove(Integer id);
	
	ArrayList<Lekar> pretregaLekaraPoImenu(String ime);
	
	ArrayList<Lekar> pretregaLekaraPoPrezimenu(String prezime);
	
	ArrayList<Lekar> pretregaLekaraPoOceni(float ocena);
	
	ArrayList<Lekar> pretregaLekaraPoKliniciUKojojSeNalazi(Integer klinikaID);
	
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenu(String ime, String prezime);
	
	ArrayList<Lekar> pretregaLekaraPoImenuITipuPregleda(String ime, Integer tipPregledaID);
	
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceni(String ime, String prezime, float prosecnaOcena);
	
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID);
	
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuITipuPregleda(String ime, String prezime, Integer tipPregledaID);

	ArrayList<Lekar> pretregaLekaraIzKlinike(String ime, String prezime, float prosecnaOcena, Integer klinikaID);
	
	ArrayList<Lekar> pretregaLekaraAdvanced(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID, Integer klinikaID);
	
}
