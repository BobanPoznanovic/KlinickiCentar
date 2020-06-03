package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.StatusZahtevZaRegistraciju;
import isa.klinicki_centar.model.ZahtevZaRegistraciju;
import isa.klinicki_centar.model.ZdravstveniKarton;
import isa.klinicki_centar.model.dto.ZahtevZaRegistracijuDTO;
import isa.klinicki_centar.services.EmailService;
import isa.klinicki_centar.services.PacijentService;
import isa.klinicki_centar.services.ZahtevZaRegistracijuService;
import isa.klinicki_centar.services.ZdravstveniKartonService;

@Controller
@RequestMapping(path = "/zahtev/registracija")
@CrossOrigin(origins = "*")
public class ZahtevZaRegistracijuController {

	@Autowired
	private ZahtevZaRegistracijuService zahtevZaRegistracijuService;
	
	@Autowired
	private ZdravstveniKartonService zdravstveniKartonService;
	
	@Autowired
	private PacijentService pacijentService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaRegistracijuDTO>> getAll() {
		
		List<ZahtevZaRegistracijuDTO> retVal = new ArrayList<ZahtevZaRegistracijuDTO>();
		
		Iterable<ZahtevZaRegistraciju> zahtevi = zahtevZaRegistracijuService.findAll();
		
		for(ZahtevZaRegistraciju zahtev : zahtevi) {
			retVal.add(new ZahtevZaRegistracijuDTO(zahtev));
		}
		
		return new ResponseEntity<List<ZahtevZaRegistracijuDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaRegistracijuDTO> getZahtevZaRegistraciju(@PathVariable Integer id) {
		
		ZahtevZaRegistraciju queryResult = zahtevZaRegistracijuService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaRegistracijuDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaRegistracijuDTO>(new ZahtevZaRegistracijuDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaRegistracijuDTO> saveZahtevZaRegistraciju(@RequestBody ZahtevZaRegistracijuDTO zahtev) {
		
		ZahtevZaRegistraciju noviZahtev = new ZahtevZaRegistraciju();
		
		Random rand = new Random();
		int num = rand. nextInt(90000000) + 10000000;
		
		noviZahtev.setBroj_osiguranika(num);
		noviZahtev.setAdresa(zahtev.getAdresa());
		noviZahtev.setBroj_telefona(zahtev.getBroj_telefona());
		noviZahtev.setDrzava(zahtev.getDrzava());
		noviZahtev.setEmail(zahtev.getEmail());
		noviZahtev.setGrad(zahtev.getGrad());
		noviZahtev.setIme(zahtev.getIme());
		noviZahtev.setPassword(zahtev.getPassword());
		noviZahtev.setPrezime(zahtev.getPrezime());
		noviZahtev.setRazlog_odbijanja("");
		noviZahtev.setStatus_zahteva(StatusZahtevZaRegistraciju.Na_cekanju);
		noviZahtev.setZahtevID(zahtev.getZahtevID());
		
		noviZahtev = zahtevZaRegistracijuService.save(noviZahtev);
		
		return new ResponseEntity<ZahtevZaRegistracijuDTO>(new ZahtevZaRegistracijuDTO(noviZahtev), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaRegistracijuDTO> updateZahtevZaRegistraciju(@RequestBody ZahtevZaRegistracijuDTO zahtev) {
		
		ZahtevZaRegistraciju queryResult = zahtevZaRegistracijuService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaRegistracijuDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setEmail(zahtev.getEmail());
		queryResult.setBroj_osiguranika(zahtev.getBroj_osiguranika());
		
		queryResult.setAdresa(zahtev.getAdresa());
		queryResult.setBroj_telefona(zahtev.getBroj_telefona());
		queryResult.setDrzava(zahtev.getDrzava());
		queryResult.setGrad(zahtev.getGrad());
		queryResult.setIme(zahtev.getIme());
		queryResult.setPassword(zahtev.getPassword());
		queryResult.setPrezime(zahtev.getPrezime());
		queryResult.setRazlog_odbijanja(zahtev.getRazlog_odbijanja());
		for(StatusZahtevZaRegistraciju status : StatusZahtevZaRegistraciju.values()) {
			if(status.name().equalsIgnoreCase(zahtev.getStatus_zahteva())) {
				queryResult.setStatus_zahteva(status);
			}
		}
		queryResult.setZahtevID(zahtev.getZahtevID());
		
		queryResult = zahtevZaRegistracijuService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaRegistracijuDTO>(new ZahtevZaRegistracijuDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZahtevZaRegistraciju(@PathVariable Integer id) {
		
		ZahtevZaRegistraciju queryResult = zahtevZaRegistracijuService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaRegistracijuService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/prihvati/{id}")
	public ResponseEntity<ZahtevZaRegistracijuDTO> prihvatitiZahtevZaRegistraciju(@PathVariable Integer id) {
		
		ZahtevZaRegistraciju queryResult = zahtevZaRegistracijuService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaRegistracijuDTO>(HttpStatus.NOT_FOUND);
		}
		
		queryResult.setStatus_zahteva(StatusZahtevZaRegistraciju.Odobren);
		
		queryResult = zahtevZaRegistracijuService.save(queryResult);
		
		// Kreiranje pacijenta
		ZdravstveniKarton zdravstveniKarton = new ZdravstveniKarton();
		Pacijent pacijent = new Pacijent(
					queryResult.getBroj_osiguranika(), 
					queryResult.getEmail(),
					queryResult.getPassword(), 
					queryResult.getIme(),
					queryResult.getPrezime(),
					queryResult.getAdresa(), 
					queryResult.getGrad(), 
					queryResult.getDrzava(), 
					queryResult.getBroj_telefona() 
				);
		// brisanje zahteva ?
		
		pacijent.setZdravstveni_kartonID(zdravstveniKarton.getKartonID());
		
		zdravstveniKartonService.save(zdravstveniKarton);
		
		pacijentService.save(pacijent);
		
		// Slanje mejla za aktivaciju
		Pacijent p = pacijentService.findByEmail(queryResult.getEmail());
		emailService.sendMailToUser(pacijent.getEmail(), "Kliknite na sledeci link kako biste aktivirali vas nalog: http://localhost:8080/pacijent/aktivacija/" + p.getPacijentID(), "Automatski generisan mejl : Aktivacija naloga");
		
		return new ResponseEntity<ZahtevZaRegistracijuDTO>(new ZahtevZaRegistracijuDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(
			value = "/odbiti",
			consumes = "application/json")
	public ResponseEntity<ZahtevZaRegistracijuDTO> odbitiZahtevZaRegistraciju(@RequestBody ZahtevZaRegistracijuDTO zahtev) {
		
		ZahtevZaRegistraciju queryResult = zahtevZaRegistracijuService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaRegistracijuDTO>(HttpStatus.NOT_FOUND);
		}
		else if(zahtev.getRazlog_odbijanja().isEmpty()) {
			return new ResponseEntity<ZahtevZaRegistracijuDTO>(HttpStatus.BAD_REQUEST);
		}
		
		zahtev.setStatus_zahteva(StatusZahtevZaRegistraciju.Odbijen.name());
		
		return updateZahtevZaRegistraciju(zahtev);
	}
	
	@DeleteMapping(value = "/odbijanje/{id}")
	public void odbijanjeZahtevaZaRegistraciju(@PathVariable Integer id, @PathVariable String message) {
		
		ZahtevZaRegistraciju zahtevZaRegistraciju = zahtevZaRegistracijuService.findOne(id);
		emailService.sendMailToUser(zahtevZaRegistraciju.getEmail(), "Vas zahtev je odbijen.", "Automatski generisan mejl : Zahtev odbijen");
		
		zahtevZaRegistraciju.setStatus_zahteva(StatusZahtevZaRegistraciju.Odbijen);
		
		zahtevZaRegistracijuService.remove(id);
		
	}
}
