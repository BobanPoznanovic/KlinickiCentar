package isa.klinicki_centar.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.repositories.TipPregledaRepository;
import isa.klinicki_centar.services.TipPregledaService;

@Service
public class TipPregledaServiceImpl implements TipPregledaService {

	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	@Override
	public Iterable<TipPregleda> findAll() {
		return tipPregledaRepository.findAll();
	}

	@Override
	public TipPregleda findOne(Integer id) {
		return tipPregledaRepository.findById(id).orElseGet(null);
	}

	@Override
	public TipPregleda save(TipPregleda tip) {
		return tipPregledaRepository.save(tip);
	}

	@Override
	public void remove(Integer id) {
		tipPregledaRepository.deleteById(id);
	}

}
