package isa.klinicki_centar.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public void oceniLekara(Integer lekarID, Integer ocena) {
		Lekar lekar = lekarRepository.getOne(lekarID);
		int brojOcena = lekar.getBroj_ocena();
		float prosecnaOcena = lekar.getProsecna_ocena();
		float novaProsecna = (prosecnaOcena * brojOcena + ocena) / (brojOcena + 1);
		lekar.setBroj_ocena(brojOcena + 1);
		lekar.setProsecna_ocena(novaProsecna);
		
		lekarRepository.updateRating(lekarID, novaProsecna, brojOcena + 1);
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

	@Override
	public ArrayList<Lekar> nadjiLekareZaTipPregledaIDatum(Integer tipPregledaID, Integer klinikaID, String datum) {
		return lekarRepository.nadjiLekareZaTipPregledaIDatum(tipPregledaID, klinikaID, datum);
	}

	@Override
	public ArrayList<Lekar> pretregaLekara(String ime, String prezime, float prosecnaOcena, Integer tipPregledaID, String datum) {
		return lekarRepository.pretregaLekara(ime, prezime, prosecnaOcena, tipPregledaID, datum);
	}

	@Override
	public ArrayList<Lekar> sortLekaraPoImenu() {
		return lekarRepository.sortLekaraPoImenu();
	}

	@Override
	public ArrayList<Lekar> sortLekaraPoPrezimenu() {
		return lekarRepository.sortLekaraPoPrezimenu();
	}

	@Override
	public ArrayList<Lekar> sortLekaraPoOceni() {
		return lekarRepository.sortLekaraPoOceni();
	}

	@Override
	public ArrayList<Lekar> pretregaLekaraPoTipuPregledaIKlinici(Integer tipPregledaID, Integer klinikaID) {
		return lekarRepository.pretregaLekaraPoTipuPregledaIKlinici(tipPregledaID, klinikaID);
	}

}
