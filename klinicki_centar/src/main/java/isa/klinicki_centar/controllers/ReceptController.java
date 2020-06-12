package isa.klinicki_centar.controllers;

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

import isa.klinicki_centar.model.Recept;
import isa.klinicki_centar.model.dto.ReceptDTO;
import isa.klinicki_centar.services.ReceptService;

@Controller
@RequestMapping(path = "/recept")
@CrossOrigin(origins = "*")
public class ReceptController {
	
	@Autowired
	private ReceptService receptService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ReceptDTO>> getAll() {
		
		List<ReceptDTO> retVal = new ArrayList<ReceptDTO>();
		
		Iterable<Recept> recepti = receptService.findAll();
		
		for(Recept recept : recepti) {
			retVal.add(new ReceptDTO(recept));
		}
		
		return new ResponseEntity<List<ReceptDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/neovereni")
	public ResponseEntity<List<ReceptDTO>> getNeovereni() {
		
		List<ReceptDTO> retVal = new ArrayList<ReceptDTO>();
		
		Iterable<Recept> recepti = receptService.findByOveren(false);
		
		for(Recept recept : recepti) {
			retVal.add(new ReceptDTO(recept));
		}
		
		return new ResponseEntity<List<ReceptDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/neovereni/klinika/{id}")
	public ResponseEntity<List<ReceptDTO>> getNeovereniSaKlinike(@PathVariable Integer id) {
		
		List<ReceptDTO> retVal = new ArrayList<ReceptDTO>();
		
		Iterable<Recept> queryResult = receptService.findAllNeovereniByKlinika(id);
		
		for(Recept r : queryResult) {
			retVal.add(new ReceptDTO(r));
		}
		
		return new ResponseEntity<List<ReceptDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/neovereni/pregled/{id}")
	public ResponseEntity<List<ReceptDTO>> getNeovereniSaPregleda(@PathVariable Integer id) {
		
		List<ReceptDTO> retVal = new ArrayList<ReceptDTO>();
		
		Iterable<Recept> queryResult = receptService.findAllNeovereniByPregledID(id);
		
		for(Recept r : queryResult) {
			retVal.add(new ReceptDTO(r));
		}
		
		return new ResponseEntity<List<ReceptDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReceptDTO> getRecept(@PathVariable Integer id) {
		
		Recept queryResult = receptService.findOne(id);
	
		if(queryResult == null) {
			return new ResponseEntity<ReceptDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ReceptDTO>(new ReceptDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ReceptDTO> saveRecept(@RequestBody ReceptDTO recept) {
		
		Recept noviRecept = new Recept();
		
		noviRecept.setIzvestaj_pregledaID(recept.getIzvestaj_pregledaID());
		noviRecept.setLekID(recept.getLekID());
		noviRecept.setOveren(recept.getOveren());
		noviRecept.setUpotreba(recept.getUpotreba());
		noviRecept.setOverila_medicinska_sestraID(recept.getOverila_medicinska_sestraID());
		
		noviRecept = receptService.save(noviRecept);
		
		return new ResponseEntity<ReceptDTO>(new ReceptDTO(noviRecept), HttpStatus.CREATED);		
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ReceptDTO> updateRecept(@RequestBody ReceptDTO recept) {
		
		Recept queryResult = receptService.findOne(recept.getReceptID());
		
		if(queryResult == null) {
			return new ResponseEntity<ReceptDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setIzvestaj_pregledaID(recept.getIzvestaj_pregledaID());
		queryResult.setLekID(recept.getLekID());
		queryResult.setOveren(recept.getOveren());
		queryResult.setReceptID(recept.getReceptID());
		queryResult.setUpotreba(recept.getUpotreba());
		queryResult.setOverila_medicinska_sestraID(recept.getOverila_medicinska_sestraID());
		
		queryResult = receptService.save(queryResult);
		
		return new ResponseEntity<ReceptDTO>(new ReceptDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteRecept(@PathVariable Integer id) {
		
		Recept queryResult = receptService.findOne(id);
		
		if(queryResult != null) {
			receptService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/overi/{id}/{sestra}")
	public ResponseEntity<ReceptDTO> overiRecept(@PathVariable Integer id, @PathVariable Integer sestra) {
		
		Recept queryResult = receptService.findOne(id);
	
		if(queryResult == null) {
			return new ResponseEntity<ReceptDTO>(HttpStatus.NOT_FOUND);
		}
		
		queryResult.setOveren(true);
		queryResult.setOverila_medicinska_sestraID(sestra);
		
		queryResult = receptService.save(queryResult);
		
		return new ResponseEntity<ReceptDTO>(new ReceptDTO(queryResult), HttpStatus.OK);
	}

}
