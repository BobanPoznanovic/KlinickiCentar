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
			value="/show",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Dijagnoza>> getAll() {
		System.out.println("Prikupljanje svih dijagnoza...");
		
		
		ArrayList<Dijagnoza> retVal = null;
		retVal = dijagnozaService.findAll();
		
		System.out.println("Sve dijagnoze pokupljene");
		return new ResponseEntity<ArrayList<Dijagnoza>>(retVal, HttpStatus.OK);
	}

}
