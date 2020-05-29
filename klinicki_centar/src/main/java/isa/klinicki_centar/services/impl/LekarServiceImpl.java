package isa.klinicki_centar.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.services.LekarService;

@Service
public class LekarServiceImpl implements LekarService{

	@Autowired
	private LekarRepository lekarRepository;
	
	@Override
	public Iterable<Lekar> findAll() {
		return lekarRepository.findAll();
	}

	@Override
	public Lekar findOne(Integer id) {
		return lekarRepository.findById(id).orElseGet(null);
	}

	@Override
	public Lekar save(Lekar lekar) {
		return lekarRepository.save(lekar);
	}

	@Override
	public void remove(Integer id) {
		lekarRepository.deleteById(id);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenu(String ime) {
		return lekarRepository.pretregaLekaraPoImenu(ime);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoPrezimenu(String prezime) {
		return lekarRepository.pretregaLekaraPoPrezimenu(prezime);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoOceni(float ocena) {
		return lekarRepository.pretregaLekaraPoOceni(ocena);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoKliniciUKojojSeNalazi(Integer klinikaID) {
		return lekarRepository.pretregaLekaraPoKliniciUKojojSeNalazi(klinikaID);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenu(String ime, String prezime) {
		return lekarRepository.pretregaLekaraPoImenuIPrezimenu(ime, prezime);
	}
	
	@Override
	public ArrayList<Lekar> pretregaLekaraIzKlinike(String ime, String prezime, float prosecnaOcena, Integer lekarIDuKlinici) {
		return lekarRepository.pretregaLekaraIzKlinike(ime, prezime, prosecnaOcena, lekarIDuKlinici);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraAdvanced(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID, Integer klinikaID) {
		return lekarRepository.pretregaLekaraAdvanced(ime, prezime, prosecnaOcena, tipPregledaID, klinikaID);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenuITipuPregleda(String ime, Integer tipPregledaID) {
		return lekarRepository.pretregaLekaraPoImenuITipuPregleda(ime, tipPregledaID);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceni(String ime, String prezime, float prosecnaOcena) {
		return lekarRepository.pretregaLekaraPoImenuIPrezimenuIOceni(ime, prezime, prosecnaOcena);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID) {
		return lekarRepository.pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda(ime, prezime, prosecnaOcena, tipPregledaID);
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuITipuPregleda(String ime, String prezime, Integer tipPregledaID) {
		return lekarRepository.pretregaLekaraPoImenuIPrezimenuITipuPregleda(ime, prezime, tipPregledaID);
	}

}
