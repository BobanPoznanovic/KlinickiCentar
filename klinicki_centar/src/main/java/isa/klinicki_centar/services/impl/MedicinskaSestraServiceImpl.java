package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.MedicinskaSestra;
import isa.klinicki_centar.repositories.MedicinskaSestraRepository;
import isa.klinicki_centar.services.MedicinskaSestraService;

@Service
public class MedicinskaSestraServiceImpl implements MedicinskaSestraService{

	@Autowired
	private MedicinskaSestraRepository medicinskaSestraRepository;
	
	@Override
	public Iterable<MedicinskaSestra> findAll() {
		// TODO Auto-generated method stub
		return medicinskaSestraRepository.findAll();
	}

	@Override
	public MedicinskaSestra findOne(Integer id) {
		// TODO Auto-generated method stub
		return medicinskaSestraRepository.findById(id).orElseGet(null);
	}

	@Override
	public MedicinskaSestra save(MedicinskaSestra medicinskaSestra) {
		// TODO Auto-generated method stub
		return medicinskaSestraRepository.save(medicinskaSestra);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		medicinskaSestraRepository.deleteById(id);
	}

}
