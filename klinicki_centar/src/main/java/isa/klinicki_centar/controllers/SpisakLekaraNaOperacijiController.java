package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;
import isa.klinicki_centar.model.dto.SpisakLekarNaOperacijiDTO;
import isa.klinicki_centar.services.SpisakLekaraNaOperacijiService;

@Controller
@RequestMapping(path = "/spisak")
public class SpisakLekaraNaOperacijiController {

	@Autowired
	private SpisakLekaraNaOperacijiService spisakLekaraNaOperacijiService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<SpisakLekarNaOperacijiDTO>> findAll() {
		
		List<SpisakLekarNaOperacijiDTO> retVal = new ArrayList<SpisakLekarNaOperacijiDTO>();
		
		Iterable<SpisakLekaraNaOperaciji> queryResult = spisakLekaraNaOperacijiService.findAll();
		
		for(SpisakLekaraNaOperaciji s : queryResult) {
			retVal.add(new SpisakLekarNaOperacijiDTO(s));
		}
		
		return new ResponseEntity<List<SpisakLekarNaOperacijiDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SpisakLekarNaOperacijiDTO> getSpisakLekaraNaOperaciji(@PathVariable Integer id) {
		
		SpisakLekaraNaOperaciji queryResult = spisakLekaraNaOperacijiService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<SpisakLekarNaOperacijiDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SpisakLekarNaOperacijiDTO>(new SpisakLekarNaOperacijiDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<SpisakLekarNaOperacijiDTO> saveSpisakLekaraNaOperaciji(@RequestBody SpisakLekarNaOperacijiDTO spisak) {
		
		SpisakLekaraNaOperaciji noviSpisak = new SpisakLekaraNaOperaciji();
		
		noviSpisak.setLekarID(spisak.getLekarID());
		noviSpisak.setOperacijaID(spisak.getOperacijaID());
		noviSpisak.setSpisakID(spisak.getSpisakID());
		
		noviSpisak = spisakLekaraNaOperacijiService.save(noviSpisak);
		
		return new ResponseEntity<SpisakLekarNaOperacijiDTO>(new SpisakLekarNaOperacijiDTO(noviSpisak), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<SpisakLekarNaOperacijiDTO> updateSpisakLekaraNaOperaciji(@RequestBody SpisakLekarNaOperacijiDTO spisak) {
		
		SpisakLekaraNaOperaciji queryResult = spisakLekaraNaOperacijiService.findOne(spisak.getSpisakID());
		
		if(queryResult == null) {
			return new ResponseEntity<SpisakLekarNaOperacijiDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setLekarID(spisak.getLekarID());
		queryResult.setOperacijaID(spisak.getOperacijaID());
		queryResult.setSpisakID(spisak.getSpisakID());
		
		queryResult = spisakLekaraNaOperacijiService.save(queryResult);
		
		return new ResponseEntity<SpisakLekarNaOperacijiDTO>(new SpisakLekarNaOperacijiDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSpisakLekaraNaOperaciji(@PathVariable Integer id) {
		
		SpisakLekaraNaOperaciji queryResult = spisakLekaraNaOperacijiService.findOne(id);
		
		if(queryResult != null) {
			spisakLekaraNaOperacijiService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
