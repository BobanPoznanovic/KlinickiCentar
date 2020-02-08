package isa.klinicki_centar.services.impl;

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
		// TODO Auto-generated method stub
		return operacijaRepository.findAll();
	}

	@Override
	public Operacija findOne(Integer id) {
		// TODO Auto-generated method stub
		return operacijaRepository.findById(id).orElseGet(null);
	}

	@Override
	public Operacija save(Operacija operacija) {
		// TODO Auto-generated method stub
		return operacijaRepository.save(operacija);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		operacijaRepository.deleteById(id);
	}

	@Override
	public List<Operacija> fromDate(String date) {
		// TODO Auto-generated method stub
		return operacijaAdvanceRepository.fromDate(date);
	}

	@Override
	public List<Operacija> byDataAndSalaID(String date, Integer salaID) {
		// TODO Auto-generated method stub
		return operacijaAdvanceRepository.byDateAndSalaID(date, salaID);
	}

}
