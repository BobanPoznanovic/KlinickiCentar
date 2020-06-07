package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.dto.LekarDTO;
import isa.klinicki_centar.services.LekarService;
import isa.klinicki_centar.services.PregledService;

@RestController
@RequestMapping(path = "/lekar")
public class LekarController {
	
	@Autowired
	private LekarService lekarService;
	
	@Autowired
	private PregledService pregledService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<LekarDTO>> getAll() {
		
		List<LekarDTO> retVal = new ArrayList<LekarDTO>();
		
		Iterable<Lekar> queryResult = lekarService.findAll();
		
		for(Lekar l : queryResult) {
			retVal.add(new LekarDTO(l));
		}
		
		return new ResponseEntity<List<LekarDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LekarDTO> getLekar(@PathVariable Integer id) {
		
		Lekar queryResult = lekarService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<LekarDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<LekarDTO> saveLekar(@RequestBody LekarDTO lekar) {
		
		Lekar noviLekar = new Lekar();
		
		noviLekar.setAdresa(lekar.getAdresa());
		noviLekar.setEmail(lekar.getEmail());
		noviLekar.setIme(lekar.getIme());
		noviLekar.setIzmenjena_sifra_nakon_prvog_logovanja(lekar.getIzmenjena_sifra_nakon_prvog_logovanja());
		noviLekar.setKlinikaID(lekar.getKlinikaID());
		noviLekar.setKontakt_telefon(lekar.getKontakt_telefon());
		noviLekar.setLekarID(lekar.getLekarID());
		noviLekar.setPassword(lekar.getPassword());
		noviLekar.setPrezime(lekar.getPrezime());
//		noviLekar.setSpecijalizacijaID(lekar.getSpecijalizacijaID());
		noviLekar.setUsername(lekar.getUsername());
		
		// tipovi pregleda
		
		noviLekar.setProsecna_ocena(lekar.getProsecna_ocena());
		noviLekar.setBroj_ocena(lekar.getBroj_ocena());
		noviLekar.setPocetak_radnog_vremena(lekar.getPocetak_radnog_vremena());
		noviLekar.setKraj_radnog_vremena(lekar.getKraj_radnog_vremena());
		
		noviLekar = lekarService.save(noviLekar);
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(noviLekar), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<LekarDTO> updateLekar(@RequestBody LekarDTO lekar) {
		
		Lekar queryResult = lekarService.findOne(lekar.getLekarID());
		
		if(queryResult == null) {
			return new ResponseEntity<LekarDTO>(HttpStatus.BAD_REQUEST);
		}
		
		//queryResult.setDijagnozaID(dijagnoza.getDijagnozaID());
		queryResult.setAdresa(lekar.getAdresa());
		queryResult.setEmail(lekar.getEmail());
		queryResult.setIme(lekar.getIme());
		queryResult.setIzmenjena_sifra_nakon_prvog_logovanja(lekar.getIzmenjena_sifra_nakon_prvog_logovanja());
		queryResult.setKlinikaID(lekar.getKlinikaID());
		queryResult.setKontakt_telefon(lekar.getKontakt_telefon());
		queryResult.setLekarID(lekar.getLekarID());
		queryResult.setPassword(lekar.getPassword());
		queryResult.setPrezime(lekar.getPrezime());
//		queryResult.setSpecijalizacijaID(lekar.getSpecijalizacijaID());
		queryResult.setUsername(lekar.getUsername());
		
		// tipovi pregleda
		
		queryResult.setProsecna_ocena(lekar.getProsecna_ocena());
		queryResult.setBroj_ocena(lekar.getBroj_ocena());
		queryResult.setPocetak_radnog_vremena(lekar.getPocetak_radnog_vremena());
		queryResult.setKraj_radnog_vremena(lekar.getKraj_radnog_vremena());
		
		queryResult = lekarService.save(queryResult);
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLekar(@PathVariable Integer id) {
		
		Lekar queryResult = lekarService.findOne(id);
		
		if(queryResult != null) {
			lekarService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/poImenu")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenu(@RequestParam(name = "ime") String ime) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenu(ime);
		
		return lekari;
	}

	@GetMapping("/search/poPrezimenu")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoPrezimenu(@RequestParam(name = "prezime") String prezime) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoPrezimenu(prezime);
		
		return lekari;
	}

	@GetMapping("/search/poOceni")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoOceni(@RequestParam(name = "prosecnaOcena") float ocena) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoOceni(ocena);
		
		return lekari;
	}

	@GetMapping("/search/poKlinici")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoKliniciUKojojSeNalazi(@RequestParam(name = "klinikaID") Integer klinikaID) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoKliniciUKojojSeNalazi(klinikaID);
		
		return lekari;
	}

	@GetMapping("/search/poImenuIPrezimenu")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenu(@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenuIPrezimenu(ime, prezime);
		
		return lekari;
	}
	
	@GetMapping("/search/poImenuITipuPregleda")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenuITipuPregleda(@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "tipPregledaID") Integer tipPregledaID) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenuITipuPregleda(ime, tipPregledaID);
		
		return lekari;
	}
	
	@GetMapping("/search/poImenuIPrezimenuIOceni")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceni (
			@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime, 
			@RequestParam(name = "prosecnaOcena") float prosecnaOcena) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenuIPrezimenuIOceni(ime, prezime, prosecnaOcena);
		
		return lekari;
	}
	
	@GetMapping("/search/poImenuIPrezimenuITipuPregleda")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuITipuPregleda (
			@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime,  
			@RequestParam(name = "tipPregledaID") Integer tipPregledaID ) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenuIPrezimenuITipuPregleda(ime, prezime, tipPregledaID);
		
		return lekari;
	}
	
	@GetMapping("/search/poImenuIPrezimenuIOceniITipuPregleda")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda (
			@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime, 
			@RequestParam(name = "prosecnaOcena") float prosecnaOcena, 
			@RequestParam(name = "tipPregledaID") Integer tipPregledaID ) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraPoImenuIPrezimenuIOceniITipuPregleda(ime, prezime, prosecnaOcena, tipPregledaID);
		
		return lekari;
	}
	
	@GetMapping("/search/lekariIzKlinike")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraIzKlinike (
			@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime, 
			@RequestParam(name = "prosecnaOcena") float prosecnaOcena, 
			@RequestParam(name = "IDlekaraKlinike") Integer lekarIDuKlinici ) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraIzKlinike(ime, prezime, prosecnaOcena, lekarIDuKlinici);
		
		return lekari;
	}
	
	@GetMapping("/search/lekariAdvanced")
    @ResponseBody
	public ArrayList<Lekar> pretregaLekaraAdvanced(
			@RequestParam(name = "ime") String ime, 
			@RequestParam(name = "prezime") String prezime, 
			@RequestParam(name = "prosecnaOcena") float prosecnaOcena, 
			@RequestParam(name = "tipPregledaID") Integer tipPregledaID,
			@RequestParam(name = "klinikaID") Integer klinikaID) {
		
		ArrayList<Lekar> lekari = null;
		lekari = lekarService.pretregaLekaraAdvanced(ime, prezime, prosecnaOcena, tipPregledaID, klinikaID);
		
		return lekari;
	}
	
	@GetMapping("/search/lekariZaPregled/{tipPregledaID}/{klinikaID}/{datum}")
	public ArrayList<Lekar> nadjiLekareZaTipPregledaIDatum(@PathVariable Integer tipPregledaID, @PathVariable Integer klinikaID, @PathVariable String datum) {
		return lekarService.nadjiLekareZaTipPregledaIDatum(tipPregledaID, klinikaID, datum);
	}
	
	@PutMapping("/oceniLekara/{pregledID}/{ocena}/{lekarID}")
	public void oceniLekara(@PathVariable Integer pregledID, @PathVariable Integer ocena, @PathVariable Integer lekarID) {
		lekarService.oceniLekara(lekarID, ocena);
		pregledService.doktorOcenjenZaPregled(pregledID);
	}
	
}
