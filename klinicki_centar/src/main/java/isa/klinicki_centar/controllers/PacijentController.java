package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.dto.PacijentDTO;
import isa.klinicki_centar.services.PacijentService;

@RestController
@RequestMapping(path = "/pacijent")
@CrossOrigin(origins = "*")
public class PacijentController {
	
	@Autowired
	private PacijentService pacijentService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<PacijentDTO>> getAll() {
		
		List<PacijentDTO> retVal = new ArrayList<PacijentDTO>();
		
		Iterable<Pacijent> queryResult = pacijentService.findAll();
		
		for(Pacijent p : queryResult) {
			retVal.add(new PacijentDTO(p));
		}
		
		return new ResponseEntity<List<PacijentDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/sort/ime")
	public ResponseEntity<List<PacijentDTO>> sortIme() {
		
		List<PacijentDTO> retVal = new ArrayList<PacijentDTO>();
		
		Iterable<Pacijent> queryResult = pacijentService.findAllSortedByIme();
		
		for(Pacijent p : queryResult) {
			retVal.add(new PacijentDTO(p));
		}
		
		return new ResponseEntity<List<PacijentDTO>>(retVal, HttpStatus.OK);
 	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacijentDTO> getPacijent(@PathVariable Integer id) {
		
		Pacijent queryResult = pacijentService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<PacijentDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(queryResult), HttpStatus.OK);
	}
	
	@PutMapping("/aktivacija/{id}")
	public void activatePatientAccount(@PathVariable Integer id) {
		pacijentService.activatePatientAccount(id);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<PacijentDTO> savePacijent(@RequestBody PacijentDTO pacijent) {
		
		Pacijent noviPacijent = new Pacijent();
		
		noviPacijent.setAdresa(pacijent.getAdresa());
		noviPacijent.setBroj_osiguranika(pacijent.getBroj_osiguranika());
		noviPacijent.setDrzava(pacijent.getDrzava());
		noviPacijent.setEmail(pacijent.getEmail());
		noviPacijent.setGrad(pacijent.getGrad());
		noviPacijent.setIme(pacijent.getIme());
		noviPacijent.setKontakt_telefon(pacijent.getKontakt_telefon());
		noviPacijent.setPacijentID(pacijent.getPacijentID());
		noviPacijent.setPassword(pacijent.getPassword());
		noviPacijent.setPrezime(pacijent.getPrezime());
		noviPacijent.setZdravstveni_kartonID(pacijent.getZdravstveni_kartonID());
		
		noviPacijent = pacijentService.save(noviPacijent);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(noviPacijent), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PacijentDTO> updatePacijent(@RequestBody PacijentDTO pacijent) {

		Pacijent queryResult = pacijentService.findOne(pacijent.getPacijentID());
		
		if(queryResult == null) {
			return new ResponseEntity<PacijentDTO>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Nasao pacijenta");
		
		queryResult.setPassword(pacijent.getPassword());
		queryResult.setIme(pacijent.getIme());
		queryResult.setPrezime(pacijent.getPrezime());
		queryResult.setAdresa(pacijent.getAdresa());
		queryResult.setGrad(pacijent.getGrad());
		queryResult.setDrzava(pacijent.getDrzava());
		queryResult.setKontakt_telefon(pacijent.getKontakt_telefon());
		
		queryResult = pacijentService.save(queryResult);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePacijent(@PathVariable Integer id) {
		
		Pacijent queryResult = pacijentService.findOne(id);
		
		if(queryResult != null) {
			pacijentService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
