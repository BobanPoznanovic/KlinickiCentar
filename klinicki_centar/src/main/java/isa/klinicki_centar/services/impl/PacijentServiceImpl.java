package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.repositories.PacijentSortRepository;
import isa.klinicki_centar.services.PacijentService;

@Service
public class PacijentServiceImpl implements PacijentService{

	@Autowired
	private PacijentRepository pacijentRepository;
	
	@Autowired
	private PacijentSortRepository pacijentSortRepository;
	
	@Override
	public Iterable<Pacijent> findAll() {
		return pacijentRepository.findAll();
	}

	@Override
	public Pacijent findOne(Integer id) {
		return pacijentRepository.findById(id).orElseGet(null);
	}

	@Override
	public Pacijent save(Pacijent pacijent) {
		return pacijentRepository.save(pacijent);
	}

	@Override
	public void remove(Integer id) {
		pacijentRepository.deleteById(id);
	}

	@Override
	public Iterable<Pacijent> findAllSortedByIme() {
		return pacijentSortRepository.findAll(Sort.by("ime"));
	}

	@Override
	public Iterable<Pacijent> findAllSortedByBroj_Osiguranika() {
		return null;
	}

	@Override
	public Pacijent findByEmail(String email) {
		return pacijentRepository.findByEmail(email);
	}

	@Override
	public void activatePatientAccount(Integer id) {
		Pacijent pacijent = pacijentRepository.findById(id).get();
		pacijent.setAktivan(true);
		System.out.println("Nalog pacijenta aktivan ?  -  " + pacijent.isAktivan());
		pacijentRepository.activatePatientAccount(id);
	}

}
