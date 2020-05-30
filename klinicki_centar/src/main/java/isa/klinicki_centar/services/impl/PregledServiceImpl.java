package isa.klinicki_centar.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.repositories.PregledRepository;
import isa.klinicki_centar.services.PregledService;

@Service
public class PregledServiceImpl implements PregledService{

	@Autowired
	private PregledRepository pregledRepository;
	
	@Override
	public Iterable<Pregled> findAll() {
		return pregledRepository.findAll();
	}

	@Override
	public Pregled findOne(Integer id) {
		return pregledRepository.findById(id).orElseGet(null);
	}

	@Override
	public Pregled save(Pregled pregled) {
		return pregledRepository.save(pregled);
	}

	@Override
	public void remove(Integer id) {
		pregledRepository.deleteById(id);
	}

	@Override
	public List<Pregled> byDateAndSalaID(String date, Integer salaID) {
		return pregledRepository.byDateAndSalaID(date, salaID);
	}

	@Override
	public List<Pregled> byDate(String date) {
		return pregledRepository.byDate(date);
	}

	@Override
	public List<Pregled> byDateAndSalaIDSortedByStartTime(String date, Integer salaID) {
		return pregledRepository.byDateAndSalaIDSortedByStartTime(date, salaID);
	}

}
