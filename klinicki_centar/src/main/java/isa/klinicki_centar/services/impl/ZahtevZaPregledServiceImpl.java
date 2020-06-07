package isa.klinicki_centar.services.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.repositories.TipPregledaRepository;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;
import isa.klinicki_centar.services.ZahtevZaPregledService;

@Service
public class ZahtevZaPregledServiceImpl implements ZahtevZaPregledService {

	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private PacijentRepository pacijentRepository;
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	@Override
	public Iterable<ZahtevZaPregled> findAll() {
		return zahtevZaPregledRepository.findAll();
	}

	@Override
	public ZahtevZaPregled findOne(Integer id) {
		return zahtevZaPregledRepository.findById(id).orElseGet(null);
	}

	@Override
	public ZahtevZaPregled save(ZahtevZaPregled zahtevZaPregled) {
		return zahtevZaPregledRepository.save(zahtevZaPregled);
	}

	@Override
	public void remove(Integer id) {
		zahtevZaPregledRepository.deleteById(id);
	}

	@Override
	public void posaljiZahtev(Integer tipPregledaID, Date datum, Integer klinikaID, Integer lekarID, Integer pacijentID) {
		TipPregleda tipPregleda = tipPregledaRepository.findById(tipPregledaID).get();
		Klinika klinika = klinikaRepository.findById(klinikaID).get();
		Lekar lekar = lekarRepository.findById(lekarID).get();
		Pacijent pacijent = pacijentRepository.findById(pacijentID).get();
		
		ZahtevZaPregled zahtevZaPregled = new ZahtevZaPregled(tipPregledaID, datum, klinikaID, lekarID, pacijentID);
		zahtevZaPregledRepository.save(zahtevZaPregled);
		
		System.out.println("\nZahtev za pregled je sacuvan."
				+ "\n\n\tDatum: " + datum
				+ "\n\tKlinika: ID-" + klinikaID + ", " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
				+ "\n\tTip regleda: " + tipPregleda.getNaziv()
				+ "\n\tLekar: " + lekar.getIme() + " " + lekar.getPrezime()
				+ "\n\tPacijent: " + pacijent.getIme() + " " + pacijent.getPrezime()
				+ "\n\tCena: " + tipPregleda.getCena());
	}

	@Override
	public ArrayList<ZahtevZaPregled> nadjiLekaroveZahtevePoDatumu(Integer lekarID, Date datum) {
		return zahtevZaPregledRepository.nadjiLekaroveZahtevePoDatumu(lekarID, datum);
	}

	@Override
	public ArrayList<ZahtevZaPregled> nadjiLekaroveZahteveUNekomPeriodu(Integer lekarID, Date pocetak, Date kraj) {
		return zahtevZaPregledRepository.nadjiLekaroveZahteveUNekomPeriodu(lekarID, pocetak, kraj);
	}

}
