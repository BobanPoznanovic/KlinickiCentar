package isa.klinicki_centar.services.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.repositories.PacijentRepository;
import isa.klinicki_centar.repositories.PregledRepository;
import isa.klinicki_centar.repositories.SalaRepository;
import isa.klinicki_centar.repositories.TipPregledaRepository;
import isa.klinicki_centar.repositories.ZahtevZaPregledRepository;
import isa.klinicki_centar.services.EmailService;
import isa.klinicki_centar.services.PregledService;

@Service
public class PregledServiceImpl implements PregledService{

	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PacijentRepository pacijentRepository;
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
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
	
	@Override
	public ArrayList<Pregled> nadjiPredefinisanePregledeKlinike(Integer klinikaID) {
		return pregledRepository.nadjiPredefinisanePregledeKlinike(klinikaID);
	}

	@Override
	public void zakaziPredefinisanPregled(Integer pregledID, Integer pacijentID) {
		pregledRepository.zakaziPredefinisanPregled(pregledID, pacijentID);
		Pregled pregled = pregledRepository.getOne(pregledID);
		Pacijent pacijent = pacijentRepository.getOne(pacijentID);
		Lekar lekar = lekarRepository.getOne(pregled.getLekarID());
		Klinika klinika = klinikaRepository.getOne(lekar.getKlinikaID());
		TipPregleda tipPregleda = tipPregledaRepository.getOne(pregled.getTip_pregledaID());
		Sala sala = salaRepository.getOne(pregled.getSalaID());
		
		String message = "Predefinisani pregled, ID: " + pregledID + ", je uspesno zakazan." 
				+ "\n Detalji zakazanog pregleda: "
				+ "\n Datum: " + pregled.getDatum_pregleda()
				+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
				+ "\n Lekar: " + lekar.getIme() + " " + lekar.getPrezime()
				+ "\n Sala: " + sala.getBroj_sale()
				+ "\n Pocetak pregleda: " + pregled.getSatnica_pocetak()
				+ "\n Kraj pregleda: " + pregled.getSatnica_kraj()
				+ "\n Tip pregleda: " + tipPregleda.getNaziv()
				+ "\n Originalna cena: " + tipPregleda.getCena()
				+ "\n Popust: " + pregled.getPopust() + "\n" ;
		
		emailService.sendMailToUser(pacijent.getEmail(), message, "Automatski generisan mejl: Zakazivanje predefinisanog pregleda");
	}

	@Override
	public ArrayList<Pregled> nadjiSvePredefinisanePreglede() {
		return pregledRepository.nadjiSvePredefinisanePreglede();
	}

	@Override
	public ArrayList<Pregled> sviDoktoroviPregledi(Integer lekarID) {
		return pregledRepository.sviDoktoroviPregledi(lekarID);
	}

	@Override
	public ArrayList<Pregled> sviDoktoroviPreglediTrazenogDatuma(Integer lekarID, Date datum) throws ParseException {
		return pregledRepository.sviDoktoroviPreglediTrazenogDatuma(lekarID, datum);
	}
	
	@Override
	public ArrayList<Pregled> sviDoktoroviPreglediPoDatumu(Integer lekarID, Date pocetak, Date kraj) throws ParseException {
		return pregledRepository.sviDoktoroviPreglediPoDatumu(lekarID, pocetak, kraj);
	}

	@Override
	public ArrayList<Pregled> sviPreglediNaKliniciTrazenogDatuma(Integer klinikaID, Date datum) throws ParseException {
		return pregledRepository.sviPreglediNaKliniciTrazenogDatuma(klinikaID, datum);
	}
	
	public Collection<String> nadjiSlobodneTermineLekara(Integer lekarID, String date, Integer zahtevZaPregledID) throws ParseException {
		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
		Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 1); //same as c.add(Calendar.DAY_OF_MONTH, 1);
        
        // + mesec dana
        Date date2 = c.getTime();
        System.out.println(date2);
		
		Lekar lekar = lekarRepository.getOne(lekarID);
		ArrayList<Pregled> preglediLekara = pregledRepository.sviDoktoroviPreglediPoDatumu(lekarID, date1, date2);
		ArrayList<ZahtevZaPregled> zahteviZaPregledKodLekara = zahtevZaPregledRepository.nadjiLekaroveZahtevePoDatumu(lekarID, date1, date2);
		
		
		
		
		
		
		
		
		return null;
	}

}
