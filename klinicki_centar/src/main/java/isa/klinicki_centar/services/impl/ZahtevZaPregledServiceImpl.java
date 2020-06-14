package isa.klinicki_centar.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.AdminKlinike;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.AdminKlinikeRepository;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.repositories.TipPregledaRepository;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;
import isa.klinicki_centar.services.EmailService;
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
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	@Autowired
	private EmailService emailService;
	
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
		TipPregleda tipPregleda = tipPregledaRepository.getOne(tipPregledaID);
		Klinika klinika = klinikaRepository.getOne(klinikaID);
		Lekar lekar = lekarRepository.getOne(lekarID);
		Pacijent pacijent = pacijentRepository.getOne(pacijentID);
		
		ZahtevZaPregled zahtevZaPregled = new ZahtevZaPregled(tipPregledaID, datum, klinikaID, lekarID, pacijentID);
		zahtevZaPregledRepository.save(zahtevZaPregled);
		
		AdminKlinike adminKlinike = adminKlinikeRepository.nadjiAdminaKlinike(klinika.getKlinikaID());
		
		
		System.out.println("\nZahtev za pregled je sacuvan."
				+ "\n\n\tDatum: " + datum
				+ "\n\tKlinika: ID-" + klinika.getKlinikaID() + ", " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
				+ "\n\tTip regleda: " + tipPregleda.getNaziv()
				+ "\n\tLekar: " + lekar.getIme() + " " + lekar.getPrezime()
				+ "\n\tPacijent: " + pacijent.getIme() + " " + pacijent.getPrezime()
				+ "\n\tCena: " + tipPregleda.getCena());
		
		String message = "\n Detalji zakazanog pregleda: "
				+ "\n Datum: " + zahtevZaPregled.getDatum()
				+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
				+ "\n Lekar: " + lekar.getIme() + " " + lekar.getPrezime()
				+ "\n Pocetak pregleda: " + zahtevZaPregled.getSatnica_pocetak()
				+ "\n Kraj pregleda: " + zahtevZaPregled.getSatnica_kraj()
				+ "\n Tip pregleda: " + tipPregleda.getNaziv()
				+ "\n Originalna cena: " + tipPregleda.getCena()
				+ "\n Popust: " + zahtevZaPregled.getPopust() + "\n" ;
		
		emailService.sendMailToUser(adminKlinike.getEmail(), message, "Automatski generisan mejl: Pacijent je zakazao pregled");
		
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
