package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.repositories.OperacijaAdvanceRepository;
import isa.klinicki_centar.repositories.OperacijaRepository;
import isa.klinicki_centar.services.OperacijaService;

@Service
public class OperacijaServiceImpl implements OperacijaService {

	@Autowired
	private OperacijaRepository operacijaRepository;
	
	@Autowired
	private OperacijaAdvanceRepository operacijaAdvanceRepository;
	
	@Override
	public Iterable<Operacija> findAll() {
		return operacijaRepository.findAll();
	}

	@Override
	public Operacija findOne(Integer id) {
		return operacijaRepository.findById(id).orElseGet(null);
	}

	@Override
	public Operacija save(Operacija operacija) {
		return operacijaRepository.save(operacija);
	}

	@Override
	public void remove(Integer id) {
		operacijaRepository.deleteById(id);
	}

	@Override
	public List<Operacija> fromDate(String date) {
		return operacijaRepository.fromDate(date);
	}

	@Override
	public List<Operacija> byDateAndSalaID(String date, Integer salaID) {
		return operacijaAdvanceRepository.byDateAndSalaID(date, salaID);
	}

	@Override
	public List<Operacija> byDateAndSalaIDSortedByStartTime(String date, Integer salaID) {
		return operacijaAdvanceRepository.byDateAndSalaIDSortedByStartTime(date, salaID);
	}

	@Override
	public void lekarOcenjenZaOperaciju(Integer operacijaID) {
		operacijaRepository.lekarOcenjenZaOperaciju(operacijaID);		
	}

	@Override
	public void klinikaOcenjenaZaOperaciju(Integer operacijaID) {
		operacijaRepository.klinikaOcenjenaZaOperaciju(operacijaID);
	}

	@Override
	public ArrayList<Operacija> nadjiSvePacijentoveOperacije(Integer pacijentID) {
		return operacijaRepository.nadjiSvePacijentoveOperacije(pacijentID);
	}

	@Override
	public ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(Integer pacijentID, Date datumOperacije) {
		return operacijaRepository.nadjiSveOperacijeZaOcenjivanje(pacijentID, datumOperacije);
	}

	@Override
	public ArrayList<Operacija> sortOperacijePoDatumu() {
		return operacijaRepository.sortOperacijePoDatumu();
	}
	
	
	
	// mozda ovako da se uzima danasnji datum ???
	
//	/*@Override
//	public ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(Integer pacijentID) {
//		Date date = new Date();
//		return return operacijaRepository.nadjiSveOperacijeZaOcenjivanje(pacijentID);
//	}*/

}
