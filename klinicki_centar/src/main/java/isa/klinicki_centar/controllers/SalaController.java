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

import isa.klinicki_centar.model.Sala;
import isa.klinicki_centar.model.dto.LekDTO;
import isa.klinicki_centar.model.dto.SalaDTO;
import isa.klinicki_centar.services.SalaService;

@Controller
@RequestMapping(path = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<SalaDTO>> getAll() {
		List<SalaDTO> retVal = new ArrayList<SalaDTO>();
		
		Iterable<Sala> queryResult = salaService.findAll();
		
		for(Sala s : queryResult) {
			retVal.add(new SalaDTO(s));
		}
		
		return new ResponseEntity<List<SalaDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SalaDTO> getSala(@PathVariable Integer id) {
		
		Sala queryResult = salaService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<SalaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SalaDTO>(new SalaDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<SalaDTO> saveSala(@RequestBody SalaDTO sala) {
		
		Sala novaSala = new Sala();
		
		novaSala.setBroj_sale(sala.getBroj_sale());
		novaSala.setKlinikaID(sala.getKlinikaID());
		novaSala.setNaziv_sale(sala.getNaziv_sale());
		
		novaSala = salaService.save(novaSala);
		
		return new ResponseEntity<SalaDTO>(new SalaDTO(novaSala), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<SalaDTO> updateSala(@RequestBody SalaDTO sala) {
		
		Sala queryResult = salaService.findOne(sala.getSalaID());
		
		if(queryResult == null) {
			return new ResponseEntity<SalaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setBroj_sale(sala.getBroj_sale());
		queryResult.setKlinikaID(sala.getKlinikaID());
		queryResult.setNaziv_sale(sala.getNaziv_sale());
		queryResult.setSalaID(sala.getSalaID());
		
		queryResult = salaService.save(queryResult);
		
		return new ResponseEntity<SalaDTO>(new SalaDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSala(@PathVariable Integer id) {
		
		Sala queryResult = salaService.findOne(id);
		
		if(queryResult != null) {
			salaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
