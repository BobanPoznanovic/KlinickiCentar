package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.PredefPregled;
import isa.klinicki_centar.model.dto.PredefPregledDTO;
import isa.klinicki_centar.services.PredefPregledService;

@RestController
@RequestMapping(path = "/predefPregled")
@CrossOrigin(origins = "*")
public class PredefPregledController {

	@Autowired
	private PredefPregledService predefPregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PredefPregledDTO>> findAll() {
		
		List<PredefPregledDTO> pregledDTOs = new ArrayList<PredefPregledDTO>();
		
		Iterable<PredefPregled> queryResult = predefPregledService.findAll();
		
		for(PredefPregled p : queryResult) {
			pregledDTOs.add(new PredefPregledDTO(p));
		}
		
		return new ResponseEntity<List<PredefPregledDTO>>(pregledDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PredefPregledDTO> getPredefPregled(@PathVariable Integer id) {
		
		PredefPregled queryResult = predefPregledService.findOne(id);
		
		if (queryResult == null) {
			return new ResponseEntity<PredefPregledDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PredefPregledDTO>(new PredefPregledDTO(queryResult), HttpStatus.OK);
	}
	
	@GetMapping("/klinika/{klinikaID}")
	public ArrayList<PredefPregled> nadjiPredefinisanePregledeKlinike(@PathVariable Integer klinikaID) {
		return predefPregledService.nadjiPredefinisanePregledeKlinike(klinikaID);
	}
}
