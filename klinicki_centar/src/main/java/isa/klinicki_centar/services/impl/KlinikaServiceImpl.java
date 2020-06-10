package isa.klinicki_centar.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.services.KlinikaService;

@Service
public class KlinikaServiceImpl implements KlinikaService {

	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Override
	public Iterable<Klinika> findAll() {
		return klinikaRepository.findAll();
	}

	@Override
	public Klinika save(Klinika klinika) {
		return klinikaRepository.save(klinika);
	}

	@Override
	public Klinika findOne(Integer id) {
		return klinikaRepository.findById(id).orElseGet(null);
	}

	@Override
	public void remove(Integer id) {
		klinikaRepository.deleteById(id);
	}

	@Override
	public Klinika findByNazivOrGrad(String nazivOrGrad) {
		return klinikaRepository.findByNazivOrGrad(nazivOrGrad);
	}

//	@Override
//	public ArrayList<Klinika> nadjiKlinikePoTipuPregledaIDatumu(Integer tipPregledaID, Date datum) {
//		return klinikaRepository.nadjiKlinikePoTipuPregledaIDatumu(tipPregledaID, datum);
//	}

	@Override
	public ArrayList<Klinika> nadjiKlinikePoTipuPregleda(Integer tipPregledaID) {
		return klinikaRepository.nadjiKlinikePoTipuPregleda(tipPregledaID);
	}

	@Override
	public ArrayList<Klinika> nadjiKlinikePoTipuPregledaIOceni(Integer tipPregledaID, float ocena) {
		return klinikaRepository.nadjiKlinikePoTipuPregledaIOceni(tipPregledaID, ocena);
	}

	@Override
	public ArrayList<Klinika> nadjiKlinikePoTipuPregledaIGradu(Integer tipPregledaID, String grad) {
		return klinikaRepository.nadjiKlinikePoTipuPregledaIGradu(tipPregledaID, grad);
	}

	@Override
	public ArrayList<Klinika> nadjiKlinikePoTipuPregledaGraduIOceni(Integer tipPregledaID, String grad, float ocena) {
		return klinikaRepository.nadjiKlinikePoTipuPregledaGraduIOceni(tipPregledaID, grad, ocena);
	}
	
	@Transactional
	@Override
	public void oceniKliniku(Integer klinikaID, Integer ocena) {
		Klinika klinika = klinikaRepository.getOne(klinikaID);
		int brojOcena = klinika.getBrojOcena();
		float prosecnaOcena = klinika.getProsecnaOcena();
		float novaProsecna = (prosecnaOcena * brojOcena + ocena) / (brojOcena + 1);
		klinika.setBrojOcena(brojOcena + 1);
		klinika.setProsecnaOcena(novaProsecna);
		
		klinikaRepository.updateRatingKlinika(klinikaID, novaProsecna, brojOcena + 1);
	}

	@Override
	public ArrayList<Klinika> sortKlinikePoNazivu() {
		return klinikaRepository.sortKlinikePoNazivu();
	}

	@Override
	public ArrayList<Klinika> sortKlinikePoAdresi() {
		return klinikaRepository.sortKlinikePoAdresi();
	}

	@Override
	public ArrayList<Klinika> sortKlinikePoGradu() {
		return klinikaRepository.sortKlinikePoGradu();
	}

	@Override
	public ArrayList<Klinika> sortKlinikePoOceni() {
		return klinikaRepository.sortKlinikePoOceni();
	}


}
