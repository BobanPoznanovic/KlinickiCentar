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

import isa.klinicki_centar.model.Lek;
import isa.klinicki_centar.model.dto.LekDTO;
import isa.klinicki_centar.services.LekService;

@Controller
@RequestMapping(path = "/lek")
@CrossOrigin(origins = "*")
public class LekController {
	
	@Autowired
	private LekService lekService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<LekDTO>> getAll() {
		
		List<LekDTO> retVal = new ArrayList<LekDTO>();
		
		Iterable<Lek> queryResult = lekService.findAll();
		
		for(Lek l : queryResult) {
			retVal.add(new LekDTO(l));
		}
		
		return new ResponseEntity<List<LekDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LekDTO> getLek(@PathVariable Integer id) {
		
		Lek queryResult = lekService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<LekDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LekDTO>(new LekDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<LekDTO> saveLek(@RequestBody LekDTO lek) {
		
		Lek noviLek = new Lek();
		
		noviLek.setNaziv(lek.getNaziv());
		noviLek.setProizvodjac(lek.getProizvodjac());
		noviLek.setDoza(lek.getDoza());
		
		noviLek = lekService.save(noviLek);
		
		return new ResponseEntity<LekDTO>(new LekDTO(noviLek), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<LekDTO> updateLek(@RequestBody LekDTO lek) {
		
		Lek queryResult = lekService.findOne(lek.getLekID());
		
		if(queryResult == null) {
			return new ResponseEntity<LekDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setLekID(lek.getLekID());
		queryResult.setNaziv(lek.getNaziv());
		queryResult.setProizvodjac(lek.getProizvodjac());
		queryResult.setDoza(lek.getDoza());
		
		queryResult = lekService.save(queryResult);
		
		return new ResponseEntity<LekDTO>(new LekDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLek(@PathVariable Integer id) {
		
		Lek queryResult = lekService.findOne(id);
		
		if(queryResult != null) {
			lekService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
