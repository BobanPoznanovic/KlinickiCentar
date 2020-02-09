package isa.klinicki_centar.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.StatusZahtevaZaOdsustvo;
import isa.klinicki_centar.model.TipOdsustva;
import isa.klinicki_centar.model.ZahtevZaOdsustvo;
import isa.klinicki_centar.model.dto.ZahtevZaOdsustvoDTO;
import isa.klinicki_centar.services.ZahtevZaOdsustvoService;

@Controller
@RequestMapping(path = "/zahtev/odsustvo")
@CrossOrigin(origins = "*")
public class ZahtevZaOdsustvoController {

	@Autowired
	private ZahtevZaOdsustvoService zahtevZaOdsustvoService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaOdsustvoDTO>> getAll() {
		
		List<ZahtevZaOdsustvoDTO> retVal = new ArrayList<ZahtevZaOdsustvoDTO>();
		
		Iterable<ZahtevZaOdsustvo> zahtevi = zahtevZaOdsustvoService.findAll();
		
		for(ZahtevZaOdsustvo z : zahtevi) {
			retVal.add(new ZahtevZaOdsustvoDTO(z));
		}
		
		return new ResponseEntity<List<ZahtevZaOdsustvoDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaOdsustvoDTO> getZahtevZaOdsustvo(@PathVariable Integer id) {
		
		ZahtevZaOdsustvo queryResult = zahtevZaOdsustvoService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaOdsustvoDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaOdsustvoDTO>(new ZahtevZaOdsustvoDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaOdsustvoDTO> saveZahtevZaodsustvo(@RequestBody ZahtevZaOdsustvoDTO zahtev) {
		
		ZahtevZaOdsustvo noviZahtev = new ZahtevZaOdsustvo();
		
		noviZahtev.setPodnosilac_zahtevaID(zahtev.getPodnosilac_zahtevaID());
		noviZahtev.setDatum_kraja(LocalDate.parse(zahtev.getDatum_kraja()));
		noviZahtev.setDatum_pocetka(LocalDate.parse(zahtev.getDatum_pocetka()));
		
		noviZahtev.setRazlog_odbijanja(zahtev.getRazlog_odbijanja());
		for(StatusZahtevaZaOdsustvo status : StatusZahtevaZaOdsustvo.values()) {
			if(status.name().equalsIgnoreCase(zahtev.getStatus_odobrenja())) {
				noviZahtev.setStatus_odobrenja(status);
			}
		}
		
		for(TipOdsustva tip : TipOdsustva.values()) {
			if(tip.name().equalsIgnoreCase(zahtev.getTip_odsustva())) {
				noviZahtev.setTip_odsustva(tip);
			}
		}
		noviZahtev.setZahtevID(zahtev.getZahtevID());
		
		noviZahtev = zahtevZaOdsustvoService.save(noviZahtev);
		
		return new ResponseEntity<ZahtevZaOdsustvoDTO>(new ZahtevZaOdsustvoDTO(noviZahtev), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaOdsustvoDTO> updateZahtevZaOdsustvo(@RequestBody ZahtevZaOdsustvoDTO zahtev) {
		
		ZahtevZaOdsustvo queryResult = zahtevZaOdsustvoService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaOdsustvoDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDatum_kraja(LocalDate.parse(zahtev.getDatum_kraja()));
		queryResult.setDatum_pocetka(LocalDate.parse(zahtev.getDatum_pocetka()));
		queryResult.setPodnosilac_zahtevaID(zahtev.getPodnosilac_zahtevaID());
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
		
		queryResult = zahtevZaOdsustvoService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaOdsustvoDTO>(new ZahtevZaOdsustvoDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZahtevZaOdsustvo(@PathVariable Integer id) {
		
		ZahtevZaOdsustvo queryResult = zahtevZaOdsustvoService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaOdsustvoService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
