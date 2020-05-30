package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.PredefPregled;
import isa.klinicki_centar.repositories.PredefPregledRepository;
import isa.klinicki_centar.services.PredefPregledService;

@Service
public class PredefPregledServiceImpl implements PredefPregledService {

	@Autowired
	private PredefPregledRepository predefPregledRepository;
	
	@Override
	public Iterable<PredefPregled> findAll() {
		return predefPregledRepository.findAll();
	}

	@Override
	public PredefPregled findOne(Integer id) {
		return predefPregledRepository.findById(id).orElseGet(null);
	}

	@Override
	public PredefPregled save(PredefPregled predefPregled) {
		return predefPregledRepository.save(predefPregled);
	}

	@Override
	public void remove(Integer id) {
		predefPregledRepository.deleteById(id);
	}
	
	@Override
	public void zakaziPredefinisanPregled(Integer predefPregledID, Integer pacijentID) {
		
	}

	@Override
	public ArrayList<PredefPregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID) {
		return predefPregledRepository.nadjiPredefinisanePregledeKlinike(klinikaID);
	}



}
