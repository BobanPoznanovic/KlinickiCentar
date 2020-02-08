package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.repositories.IzvestajPregledaRepository;
import isa.klinicki_centar.services.IzvestajPregledaService;

@Service
public class IzvestajPregledaServiceImpl implements IzvestajPregledaService {

	@Autowired
	private IzvestajPregledaRepository izvestajPregledaRepository;
	
	@Override
	public Iterable<IzvestajPregleda> findAll() {
		// TODO Auto-generated method stub
		return izvestajPregledaRepository.findAll();
	}

	@Override
	public IzvestajPregleda findOne(Integer id) {
		// TODO Auto-generated method stub
		return izvestajPregledaRepository.findById(id).orElseGet(null);
	}

	@Override
	public IzvestajPregleda save(IzvestajPregleda izvestaj) {
		// TODO Auto-generated method stub
		return izvestajPregledaRepository.save(izvestaj);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		izvestajPregledaRepository.deleteById(id);
	}

}
