package isa.klinicki_centar.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.repositories.DijagnozaRepository;
import isa.klinicki_centar.services.DijagnozaService;

@Controller
@RequestMapping(path="/dijagnoza")
public class DijagnozaController {
	
	@Autowired
	private DijagnozaService dijagnozaService;
	
	@RequestMapping(
			value="/insertData",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<ArrayList<Dijagnoza>> insertData() {
		
		ArrayList<Dijagnoza> array = new ArrayList<Dijagnoza>();
		
		Dijagnoza d1 = new Dijagnoza();
		dijagnozaService.save(d1);
		
		Dijagnoza d2 = new Dijagnoza();
		dijagnozaService.save(d2);
		
		array.add(d1);
		array.add(d2);
		
		return new ResponseEntity<ArrayList<Dijagnoza>>(array, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/show",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Dijagnoza>> getAll() {
		
		Iterable<Dijagnoza> retVal = null;
		retVal = dijagnozaService.findAll();
		
		return new ResponseEntity<Iterable<Dijagnoza>>(retVal, HttpStatus.OK);
	}

}
