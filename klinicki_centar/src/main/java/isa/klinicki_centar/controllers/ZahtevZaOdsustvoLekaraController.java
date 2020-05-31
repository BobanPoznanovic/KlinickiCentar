package isa.klinicki_centar.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.StatusZahtevaZaOdsustvo;
import isa.klinicki_centar.model.TipOdsustva;
import isa.klinicki_centar.model.ZahtevZaOdsustvoLekar;
import isa.klinicki_centar.model.dto.ZahtevZaOdsustvoLekaraDTO;
import isa.klinicki_centar.services.ZahtevZaOdsustvoLekaraService;

@RestController
@RequestMapping(path = "/zahtev/odsustvo/lekar")
@CrossOrigin(origins = "*")
public class ZahtevZaOdsustvoLekaraController {

	@Autowired
	private ZahtevZaOdsustvoLekaraService zahtevZaOdsustvoLekaraService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaOdsustvoLekaraDTO>> getAll () {
		
		List<ZahtevZaOdsustvoLekaraDTO> retVal = new ArrayList<ZahtevZaOdsustvoLekaraDTO>();
		
		Iterable<ZahtevZaOdsustvoLekar> zahtevi = zahtevZaOdsustvoLekaraService.findAll();
		
		for(ZahtevZaOdsustvoLekar z : zahtevi) {
			retVal.add(new ZahtevZaOdsustvoLekaraDTO(z));
		}
		
		return new ResponseEntity<List<ZahtevZaOdsustvoLekaraDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaOdsustvoLekaraDTO> getZahtevZaOdsustvoLekara(@PathVariable Integer id) {
		
		ZahtevZaOdsustvoLekar queryResult = zahtevZaOdsustvoLekaraService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaOdsustvoLekaraDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaOdsustvoLekaraDTO>(new ZahtevZaOdsustvoLekaraDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaOdsustvoLekaraDTO> saveZahtevZaOdsustvoLekara(@RequestBody ZahtevZaOdsustvoLekaraDTO zahtev) {
		
		ZahtevZaOdsustvoLekar noviZahtev = new ZahtevZaOdsustvoLekar();
		
		noviZahtev.setLekarID(zahtev.getLekarID());
		noviZahtev.setDatum_kraja(LocalDate.parse(zahtev.getDatum_kraja()));
		noviZahtev.setDatum_pocetka(LocalDate.parse(zahtev.getDatum_pocetka()));
		noviZahtev.setRazlog_odbijanja("");
		noviZahtev.setStatus_odobrenja(StatusZahtevaZaOdsustvo.Na_cekanju);
		
		for(TipOdsustva tip : TipOdsustva.values()) {
			if(tip.name().equalsIgnoreCase(zahtev.getTip_odsustva())) {
				noviZahtev.setTip_odsustva(tip);
			}
		}
		
		noviZahtev = zahtevZaOdsustvoLekaraService.save(noviZahtev);
		
		return new ResponseEntity<ZahtevZaOdsustvoLekaraDTO>(new ZahtevZaOdsustvoLekaraDTO(noviZahtev), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaOdsustvoLekaraDTO> updateZahtevZaOdsustvoLekara(@RequestBody ZahtevZaOdsustvoLekaraDTO zahtev) {
		
		ZahtevZaOdsustvoLekar queryResult = zahtevZaOdsustvoLekaraService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaOdsustvoLekaraDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDatum_kraja(LocalDate.parse(zahtev.getDatum_kraja()));
		queryResult.setDatum_pocetka(LocalDate.parse(zahtev.getDatum_pocetka()));
		queryResult.setLekarID(zahtev.getLekarID());
		queryResult.setRazlog_odbijanja(zahtev.getRazlog_odbijanja());
		for(StatusZahtevaZaOdsustvo status : StatusZahtevaZaOdsustvo.values()) {
			if(status.name().equalsIgnoreCase(zahtev.getStatus_odobrenja())) {
				queryResult.setStatus_odobrenja(status);
			}
		}
		for(TipOdsustva tip : TipOdsustva.values()) {
			if(tip.name().equalsIgnoreCase(zahtev.getTip_odsustva())) {
				queryResult.setTip_odsustva(tip);
			}
		}
		queryResult.setZahtevID(zahtev.getZahtevID());
		
		queryResult = zahtevZaOdsustvoLekaraService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaOdsustvoLekaraDTO>(new ZahtevZaOdsustvoLekaraDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZahtevZaOdsustvo(@PathVariable Integer id) {
		
		ZahtevZaOdsustvoLekar queryResult = zahtevZaOdsustvoLekaraService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaOdsustvoLekaraService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
