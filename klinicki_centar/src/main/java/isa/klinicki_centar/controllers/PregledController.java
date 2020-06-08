package isa.klinicki_centar.controllers;

import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.KategorijaPregleda;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.dto.PregledDTO;
import isa.klinicki_centar.services.PregledService;

@RestController
@RequestMapping(path = "/pregled")
@CrossOrigin(origins = "*")
public class PregledController {

	@Autowired
	private PregledService pregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PregledDTO>> findAll() {
		
		List<PregledDTO> retVal = new ArrayList<PregledDTO>();
		
		Iterable<Pregled> queryResult = pregledService.findAll();
		
		for(Pregled p : queryResult) {
			retVal.add(new PregledDTO(p));
		}
		
		return new ResponseEntity<List<PregledDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PregledDTO> getPregled(@PathVariable Integer id) {
		
		Pregled queryResult = pregledService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<PregledDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PregledDTO>(new PregledDTO(queryResult), HttpStatus.OK);
	}
	
	@GetMapping(value = "/predefinisanNaKlinici/{klinikaID}")
	public ArrayList<Pregled> nadjiPredefinisanePregledeKlinike(@PathVariable Integer klinikaID) {
		return pregledService.nadjiPredefinisanePregledeKlinike(klinikaID);
	}
	
	@PutMapping(value = "zakazivanjePredefinisanogPregleda/{pregledID}/{pacijentID}")
	public void zakaziPredefinisanPregled(@PathVariable Integer pregledID, @PathVariable Integer pacijentID) {
		pregledService.zakaziPredefinisanPregled(pregledID, pacijentID);
	}
	
	@GetMapping(value = "/predefinisaniPregledi")
	public ArrayList<Pregled> nadjiSvePredefinisanePreglede() {
		return pregledService.nadjiSvePredefinisanePreglede();
	}
	
	@GetMapping(value = "/lekarPregledi/{lekarID}")
	public ArrayList<Pregled> sviDoktoroviPregledi(@PathVariable Integer lekarID) {
		return pregledService.sviDoktoroviPregledi(lekarID);
	}

	@GetMapping(value = "/lekarPreglediDatum/{lekarID}/{datum}")
	public ArrayList<Pregled> sviDoktoroviPreglediTrazenogDatuma(@PathVariable Integer lekarID, @PathVariable Date datum) throws ParseException {
		return pregledService.sviDoktoroviPreglediTrazenogDatuma(lekarID, datum);
	}

	@GetMapping(value = "/klinikaPreglediDatum/{klinikaID}/{datum}")
	public ArrayList<Pregled> sviPreglediNaKliniciTrazenogDatuma(@PathVariable Integer klinikaID, @PathVariable Date datum) throws ParseException {
		return pregledService.sviPreglediNaKliniciTrazenogDatuma(klinikaID, datum);
	}
	
	@GetMapping(value = "/slobodniTermini/{lekarID}/{datum}")
	public Collection<String> nadjiSlobodneTermineLekara(@PathVariable Integer lekarID, @PathVariable String datum) throws ParseException {
		return pregledService.nadjiSlobodneTermineLekara(lekarID, datum);
	}
	
	@PutMapping("/potvrditi/{pregledID}")
	public void potvrditiZakazanPregled(@PathVariable Integer pregledID) {
		pregledService.potvrditiZakazanPregled(pregledID);
	}
	
	@DeleteMapping("/odbiti/{pregledID}")
	public void odbitiZakazanPregled(@PathVariable Integer pregledID) {
		pregledService.odbitiZakazanPregled(pregledID);
	}
	
	@GetMapping("/pacijentoviPregledi/{pacijentID}")
	public ArrayList<Pregled> nadjiSvePacijentovePreglede(@PathVariable Integer pacijentID) {
		return pregledService.nadjiSvePacijentovePreglede(pacijentID);
	}

	@GetMapping("/pacijentoviPreglediOcenjivanje/{pacijentID}")
	public ArrayList<Pregled> nadjiSvePregledeZaOcenjivanje(@PathVariable Integer pacijentID) {
		return pregledService.nadjiSvePregledeZaOcenjivanje(pacijentID);
	}
	
//	@PutMapping("/sacuvajPregled/{datum}/{satnica_pocetak}/{satnica_kraj}/{popust}/{salaID}/{klinikaID}/{lekarID}/{pacijentID}/{tipPregledaID}/{zahtevZaPregledID}/{kategorijaPregleda}")
//	public void sacuvajPregled(
//					@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datum, @PathVariable String satnica_pocetak,
//					@PathVariable String satnica_kraj, @PathVariable float popust,
//					@PathVariable Integer salaID, @PathVariable Integer klinikaID,
//					@PathVariable Integer lekarID, @PathVariable Integer pacijentID, 
//					@PathVariable Integer tipPregledaID, @PathVariable Integer zahtevZaPregledID,
//					@PathVariable KategorijaPregleda kategorijaPregleda) throws ParseException {
//		
//		pregledService.sacuvajPregled(datum, satnica_pocetak, satnica_kraj, popust, salaID, klinikaID, lekarID, pacijentID, tipPregledaID, zahtevZaPregledID, kategorijaPregleda);
//		
//	}
	
	
	// admin treba da dodeli salu nakon sto je pregled sacuvan
	
	@PutMapping("/sacuvajZahtevaniPregled/{zahtevZaPregledID}")
	public void sacuvajZahtevaniPregled( @PathVariable Integer zahtevZaPregledID) {
		
		pregledService.sacuvajZahtevaniPregled(zahtevZaPregledID);
		
	}
	
	//Pregledi u jednoj sali
	
}
