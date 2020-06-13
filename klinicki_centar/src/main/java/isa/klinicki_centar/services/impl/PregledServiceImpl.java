package isa.klinicki_centar.services.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.klinicki_centar.model.AdminKlinike;
import isa.klinicki_centar.model.KategorijaPregleda;
import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.repositories.AdminKlinikeRepository;
import isa.klinicki_centar.repositories.KlinikaRepository;
import isa.klinicki_centar.repositories.LekarRepository;
import isa.klinicki_centar.repositories.OperacijaRepository;
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
	
	@Autowired
	private OperacijaRepository operacijaRepository;
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
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
		AdminKlinike adminKlinike = adminKlinikeRepository.nadjiAdminaKlinike(klinika.getKlinikaID());
		
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
		
		String message2 = "\n Detalji zakazanog pregleda: "
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
		emailService.sendMailToUser(adminKlinike.getEmail(), message2, "Automatski generisan mejl: Pacijent je zakazao predefinisani pregled");
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
	
	@Override
	public Collection<String> nadjiSlobodneTermineLekara(Integer lekarID, String datum) throws ParseException {
		return this.nadjiSlobodneTermine(lekarID, datum, null);
	}
	
	public Collection<String> nadjiSlobodneTermine(Integer lekarID, String date, Integer zahtevZaPregledID) throws ParseException {
		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
		Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 1); //same as c.add(Calendar.DAY_OF_MONTH, 1);
        
        // + mesec dana
//        Date date2 = c.getTime();
//        System.out.println(date2);
		
		Lekar lekar = lekarRepository.getOne(lekarID);
		
//		ArrayList<Pregled> preglediLekara = pregledRepository.sviDoktoroviPreglediPoDatumu(lekarID, date1, date2);
//		ArrayList<ZahtevZaPregled> zahteviZaPregledKodLekara = zahtevZaPregledRepository.nadjiLekaroveZahtevePoDatumu(lekarID, date1, date2);
//		ArrayList<Operacija> operacijeLekara = operacijaRepository.nadjiOperacijeLekaraUNekomPeriodu(lekarID, date1, date2);
		
		ArrayList<Pregled> preglediLekara = pregledRepository.sviDoktoroviPreglediTrazenogDatuma(lekarID, date1);
		ArrayList<ZahtevZaPregled> zahteviZaPregledKodLekara = zahtevZaPregledRepository.nadjiLekaroveZahtevePoDatumu(lekarID, date1);
		ArrayList<Operacija> operacijeLekara = operacijaRepository.nadjiOperacijeLekaraPoDatumu(lekarID, date1);
		
		
		
		// zahtevi za operacije ?
		// operacije na kojima prisustvuje ?
		
		Collection<String> sviSlobodniTermini = new ArrayList<>();
		Collection<String> sviSlobodniTerminiPregled = new ArrayList<>();
		Collection<String> sviSlobodniTerminiZahtevZaPregled = new ArrayList<>();
		Collection<String> sviSlobodniTerminiOperacija = new ArrayList<>();

		LocalTime lekarPocetakSmene = lekar.getPocetak_radnog_vremena();
		LocalTime lekarKrajSmene = lekar.getKraj_radnog_vremena();
	
		String	lekPoc = lekarPocetakSmene.toString().substring(0, 5);
		String	lekKraj = lekarKrajSmene.toString().substring(0, 5);
		
		lekarPocetakSmene = LocalTime.parse(lekPoc);
		lekarKrajSmene = LocalTime.parse(lekKraj);
		
		for(Pregled pregled : preglediLekara) {
			LocalTime pocetakPregleda = pregled.getSatnica_pocetak();
			LocalTime krajPregleda = pregled.getSatnica_kraj();
			
			String	pregPoc = pocetakPregleda.toString().substring(0, 5);
			String	pregKraj = krajPregleda.toString().substring(0, 5);
			
			pocetakPregleda = LocalTime.parse(pregPoc);
			krajPregleda = LocalTime.parse(pregKraj);
			
			sviSlobodniTerminiPregled = termini(lekarPocetakSmene, lekarKrajSmene, pocetakPregleda, krajPregleda);
			
			if(sviSlobodniTerminiPregled.size() != 0) {
				sviSlobodniTermini = sviSlobodniTerminiPregled;
			}
			
		}
		
		for(ZahtevZaPregled zahtev : zahteviZaPregledKodLekara) {
			if(zahtev.getZahtevID().equals(zahtevZaPregledID)) {
				continue;
			}
			
			LocalTime pocetakPregleda = zahtev.getSatnica_pocetak();
			LocalTime krajPregleda = zahtev.getSatnica_kraj();
			
			String	pregPoc = pocetakPregleda.toString().substring(0, 5);
			String	pregKraj = krajPregleda.toString().substring(0, 5);
			
			pocetakPregleda = LocalTime.parse(pregPoc);
			krajPregleda = LocalTime.parse(pregKraj);
			
			sviSlobodniTerminiZahtevZaPregled = termini(lekarPocetakSmene, lekarKrajSmene, pocetakPregleda, krajPregleda);
			
			if(sviSlobodniTermini.size() != 0) {
				sviSlobodniTermini.retainAll(sviSlobodniTerminiZahtevZaPregled);
			} else {
				sviSlobodniTermini = sviSlobodniTerminiZahtevZaPregled;
			}
		}
		
		for (Operacija operacija : operacijeLekara) {
			LocalTime pocetakOperacije = operacija.getSatnica_pocetka_operacije();
			LocalTime krajOperacije = operacija.getSatnica_kraja_operacije();
			
			String	opPoc = pocetakOperacije.toString().substring(0, 5);
			String	opKraj = krajOperacije.toString().substring(0, 5);
			
			pocetakOperacije = LocalTime.parse(opPoc);
			krajOperacije = LocalTime.parse(opKraj);
			
			sviSlobodniTerminiOperacija = termini(lekarPocetakSmene, lekarKrajSmene, pocetakOperacije, krajOperacije);
			
			if(sviSlobodniTermini.size() != 0) {
				sviSlobodniTermini.retainAll(sviSlobodniTerminiOperacija);
			} else {
				sviSlobodniTermini = sviSlobodniTerminiOperacija;
			}
			
		}
		
		if(sviSlobodniTermini.size() == 0) {
			System.out.println("\nNema slobodnih termina");
		} else {
			System.out.println("\nPoceci slobodnih termina - " + sviSlobodniTermini);
		}
			
		return sviSlobodniTermini;
	}
	
	public static Collection<String> termini(LocalTime timeStart, LocalTime timeEnd, LocalTime vremePocetak, LocalTime vremeKraj) {
		
		String termini = "";
		String terminiPom = "";
		
		long noOfHoursVreme = ChronoUnit.HOURS.between(vremePocetak, vremeKraj);
		int smenaVreme = Math.toIntExact(noOfHoursVreme);
		
		long noOfMinutesVreme = ChronoUnit.MINUTES.between(vremePocetak, vremeKraj);
		int trajanjeTerminaMinuti = Math.toIntExact(noOfMinutesVreme);
		
		System.out.println("Trajanje termina: " + trajanjeTerminaMinuti + " minuta");
		
		long noOfHours = ChronoUnit.HOURS.between(timeStart, timeEnd);
		int smena = Math.toIntExact(noOfHours);
		
		ArrayList<LocalTime> vremenaPom = new ArrayList<>();
		vremenaPom.add(vremePocetak);
		
		if(trajanjeTerminaMinuti == 59 || trajanjeTerminaMinuti == 119 || trajanjeTerminaMinuti == 179 || trajanjeTerminaMinuti == 239 || trajanjeTerminaMinuti == 299 ||
		   trajanjeTerminaMinuti == 60 || trajanjeTerminaMinuti == 120 || trajanjeTerminaMinuti == 180 || trajanjeTerminaMinuti == 240 || trajanjeTerminaMinuti == 300 ||
		   trajanjeTerminaMinuti == 359 || trajanjeTerminaMinuti == 360 || trajanjeTerminaMinuti == 419 || trajanjeTerminaMinuti == 420 ||
		   trajanjeTerminaMinuti == 479 || trajanjeTerminaMinuti == 480) {
			for(int i = 0; i <  smenaVreme*2 + 1; i++) {
				// timeStart = timeStart.plusHours(1);
				vremePocetak = vremePocetak.plusMinutes(30);
				vremenaPom.add(vremePocetak);
			}
		} else {
			for(int i = 0; i <  smenaVreme*2; i++) {
				// timeStart = timeStart.plusHours(1);
				vremePocetak = vremePocetak.plusMinutes(30);
				vremenaPom.add(vremePocetak);
			}
		}
		
		Collection<String> parsedTerminiPom = new ArrayList<String>();
		
		terminiPom = vremenaPom.toString();
		String strNewPom = terminiPom.replace("[", "");
		String strNew2Pom = strNewPom.replace(" ", "");
		terminiPom = strNew2Pom.replace("]", "");
		
		String[] pomPom = terminiPom.split(",");
		
		for(int k = 0; k < pomPom.length; k++) {
			parsedTerminiPom.add(pomPom[k]);
		}
		
		ArrayList<LocalTime> vremena = new ArrayList<>();
		vremena.add(timeStart);
		
		for(int i = 0; i <  smena*2; i++) {
			// timeStart = timeStart.plusHours(1);
			timeStart = timeStart.plusMinutes(30);
			vremena.add(timeStart);
		}
		
		Collection<String> slobodniTermini = new ArrayList<String>();
		
		termini = vremena.toString();
		String strNew = termini.replace("[", "");
		String strNew2 = strNew.replace(" ", "");
		termini = strNew2.replace("]", "");
		
		String[] pom = termini.split(",");
		
		// -1 uklanja poslednji pocetak termina u okviru radnog vremena
		// odnosno taj poslednji pocetak termina je zapravo jednak kraju radnog vremena
		for(int j = 0; j < pom.length - 1; j++) {
			slobodniTermini.add(pom[j]);
		}

		for(String s : parsedTerminiPom) {
			String ss = s.trim();
			slobodniTermini.remove(ss);
		}
		
		return slobodniTermini;
		
	}

	@Override
	public void potvrditiZakazanPregled(Integer pregledID) {
		pregledRepository.potvrdiPregled(pregledID);
	}
	
	@Override
	public void odbitiZakazanPregled(Integer pregledID) {
		pregledRepository.deleteById(pregledID);
	}

	
	// zavrsiPregled koristiti prilikom pravljenja izvestaja pregleda
	
	@Override
	public void zavrsiPregled(Integer pregledID) {
		pregledRepository.zavrsiPregled(pregledID);
	}
	
	@Override
	public void lekarOcenjenZaPregled(Integer pregledID) {
		pregledRepository.lekarOcenjenZaPregled(pregledID);
	}

	@Override
	public void klinikaOcenjenaZaPregled(Integer pregledID) {
		pregledRepository.klinikaOcenjenaZaPregled(pregledID);
	}

	@Override
	public ArrayList<Pregled> nadjiSvePacijentovePreglede(Integer pacijentID) {
		return pregledRepository.nadjiSvePacijentovePreglede(pacijentID);
	}

	@Override
	public ArrayList<Pregled> nadjiSvePregledeZaOcenjivanje(Integer pacijentID) {
		return pregledRepository.nadjiSvePregledeZaOcenjivanje(pacijentID);
	}

	@Override
	public ArrayList<Pregled> sviZavrseniDoktoroviPregledi(Integer lekarID) {
		// TODO Auto-generated method stub
		
		return pregledRepository.sviZavrseniDoktoroviPregledi(lekarID);
	}

	@Override
	public void sacuvajPregled(Date datum, String satnica_pocetak, String satnica_kraj, float popust,
			Integer salaID, Integer klinikaID, Integer lekarID, Integer pacijentID, Integer tipPregledaID,
			Integer zahtevZaPregledID, KategorijaPregleda kategorijaPregleda) {
		
		TipPregleda tipPregleda = tipPregledaRepository.getOne(tipPregledaID);
		Lekar lekar = lekarRepository.getOne(lekarID);
		Klinika klinika = klinikaRepository.getOne(klinikaID);
		
		Pacijent pacijent = null;
		
		if (pacijentID != null) {
			pacijent = pacijentRepository.getOne(pacijentID);
		}
		
		String[] pocetak = satnica_pocetak.split(":");
		String[] kraj = satnica_kraj.split(":");
		
		int poc = Integer.parseInt(pocetak[0]);  
		int kr = Integer.parseInt(pocetak[1]);  
		
		int poc2 = Integer.parseInt(kraj[0]);  
		int kr2 = Integer.parseInt(kraj[1]);
		
		LocalTime vrPocetak = LocalTime.of(poc, kr);
		LocalTime vrKraj = LocalTime.of(poc2, kr2);
		
		Sala sala = salaRepository.getOne(salaID);
		
		Pregled pregled = new Pregled(kategorijaPregleda, lekarID, pacijentID, salaID, datum, vrPocetak, vrKraj, tipPregledaID, popust);
		
		this.pregledRepository.save(pregled);
		
		if (zahtevZaPregledID != null) {
			this.zahtevZaPregledRepository.deleteById(zahtevZaPregledID);
			
			String porukaZaPacijenta = "Pregled je uspesno zakazan." 
					+ "\n\n Detalji zakazanog pregleda: "
					+ "\n\n Datum: " + pregled.getDatum_pregleda()
					+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
					+ "\n Lekar: " + lekar.getIme() + " " + lekar.getPrezime()
					+ "\n Sala: " + sala.getBroj_sale()
					+ "\n Pocetak pregleda: " + pregled.getSatnica_pocetak()
					+ "\n Kraj pregleda: " + pregled.getSatnica_kraj()
					+ "\n Tip pregleda: " + tipPregleda.getNaziv()
					+ "\n Originalna cena: " + tipPregleda.getCena()
					+ "\n Popust: " + pregled.getPopust()
					+ "\n\n Potvrditi pregled: " + "http://localhost:4200/potvrditiPregled/" + pregled.getPregledID()
					+ "\n Odbiti pregled: " + "http://localhost:4200/odbitiPregled/" + pregled.getPregledID();
			
			String porukaZaLekara = "Imate zakazan pregled." 
					+ "\n\n Detalji zakazanog pregleda: "
					+ "\n\n Datum: " + pregled.getDatum_pregleda()
					+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
					+ "\n Pacijent: " + pacijent.getIme() + " " + pacijent.getPrezime()
					+ "\n Sala: " + sala.getBroj_sale()
					+ "\n Tip pregleda: " + tipPregleda.getNaziv()
					+ "\n Pocetak pregleda: " + pregled.getSatnica_pocetak()
					+ "\n Kraj pregleda: " + pregled.getSatnica_kraj();
			
			emailService.sendMailToUser(pacijent.getEmail(), porukaZaPacijenta, "Automatski generisan mejl: Potvrdite ili odbijte zakazani pregled");
			emailService.sendMailToUser(lekar.getEmail(), porukaZaLekara, "Automatski generisan mejl: Zakazan pregled");
			
		}
		
		
	}

	@Override
	public void sacuvajZahtevaniPregled(Integer zahtevZaPregledID) {
		
		ZahtevZaPregled zahtevZaPregled = zahtevZaPregledRepository.getOne(zahtevZaPregledID);
		
		System.out.println("Pronadjen zahtev ID  -  " + zahtevZaPregled.getZahtevID());
		
		TipPregleda tipPregleda = tipPregledaRepository.getOne(zahtevZaPregled.getTip_pregledaID());
		Lekar lekar = lekarRepository.getOne(zahtevZaPregled.getLekarID());
		Klinika klinika = klinikaRepository.getOne(zahtevZaPregled.getKlinikaID());
		
		Pacijent pacijent = null;
		
		if (zahtevZaPregled.getPacijentID() != null) {
			pacijent = pacijentRepository.getOne(zahtevZaPregled.getPacijentID());
		}
		
		String	start = zahtevZaPregled.getSatnica_pocetak().toString().substring(0, 5);
		String	end = zahtevZaPregled.getSatnica_kraj().toString().substring(0, 5);
		
		String[] pocetak = start.split(":");
		String[] kraj = end.split(":");
		
		int poc = Integer.parseInt(pocetak[0]);  
		int kr = Integer.parseInt(pocetak[1]);  
		
		int poc2 = Integer.parseInt(kraj[0]);  
		int kr2 = Integer.parseInt(kraj[1]);
		
		LocalTime vrPocetak = LocalTime.of(poc, kr);
		LocalTime vrKraj = LocalTime.of(poc2, kr2);
		
		// Sala sala = salaRepository.getOne(zahtevZaPregled);
		
		Pregled pregled = new Pregled(
										KategorijaPregleda.Normalan,
										zahtevZaPregled.getLekarID(),
										zahtevZaPregled.getPacijentID(),
										null,
										zahtevZaPregled.getDatum(),
										vrPocetak,
										vrKraj,
										zahtevZaPregled.getTip_pregledaID(),
										zahtevZaPregled.getPopust()
									);
		
		this.pregledRepository.save(pregled);
		
		if (zahtevZaPregledID != null) {
			zahtevZaPregledRepository.deleteById(zahtevZaPregledID);
			
			String porukaZaPacijenta = "Pregled je uspesno zakazan." 
					+ "\n\n Detalji zakazanog pregleda: "
					+ "\n\n Datum: " + pregled.getDatum_pregleda()
					+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
					+ "\n Lekar: " + lekar.getIme() + " " + lekar.getPrezime()
					+ "\n Pocetak pregleda: " + pregled.getSatnica_pocetak()
					+ "\n Kraj pregleda: " + pregled.getSatnica_kraj()
					+ "\n Tip pregleda: " + tipPregleda.getNaziv()
					+ "\n Originalna cena: " + tipPregleda.getCena()
					+ "\n Popust: " + pregled.getPopust()
					+ "\n\n Potvrditi pregled: " + "http://localhost:4200/potvrditiPregled/" + pregled.getPregledID()
					+ "\n Odbiti pregled: " + "http://localhost:4200/odbitiPregled/" + pregled.getPregledID();
			
			String porukaZaLekara = "Imate zakazan pregled." 
					+ "\n\n Detalji zakazanog pregleda: "
					+ "\n\n Datum: " + pregled.getDatum_pregleda()
					+ "\n Klinika: " + klinika.getNaziv() + ", " + klinika.getAdresa() + ", " + klinika.getGrad()
					+ "\n Pacijent: " + pacijent.getIme() + " " + pacijent.getPrezime()
					+ "\n Tip pregleda: " + tipPregleda.getNaziv()
					+ "\n Pocetak pregleda: " + pregled.getSatnica_pocetak()
					+ "\n Kraj pregleda: " + pregled.getSatnica_kraj();
			
			emailService.sendMailToUser(pacijent.getEmail(), porukaZaPacijenta, "Automatski generisan mejl: Potvrdite ili odbijte zakazani pregled");
			emailService.sendMailToUser(lekar.getEmail(), porukaZaLekara, "Automatski generisan mejl: Zakazan pregled");
			
		}
		
	}

	@Override
	public ArrayList<Pregled> sortPregledPoDatumu() {
		return pregledRepository.sortPregledPoDatumu();
	}

	@Override
	public ArrayList<Pregled> sviDoktoroviPreglediPoDatumu(Integer lekarID, String date) {
		// TODO Auto-generated method stub
		return pregledRepository.sviDoktoroviPreglediPoDatumu(lekarID, date);
	}

	

}
