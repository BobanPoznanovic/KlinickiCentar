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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.dto.PregledDTO;
import isa.klinicki_centar.services.PregledService;

@RestController
@RequestMapping(path = "/pregled")
@CrossOrigin(origins = "*")
public class PregledController {

	@Autowired
	private PregledService pregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PregledDTO>> findAll() {
		
		List<PregledDTO> retVal = new ArrayList<PregledDTO>();
		
		Iterable<Pregled> queryResult = pregledService.findAll();
		
		for(Pregled p : queryResult) {
			retVal.add(new PregledDTO(p));
		}
		
		return new ResponseEntity<List<PregledDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PregledDTO> getPregled(@PathVariable Integer id) {
		
		Pregled queryResult = pregledService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<PregledDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PregledDTO>(new PregledDTO(queryResult), HttpStatus.OK);
	}
	
	@GetMapping(value = "/predefinisanNaKlinici/{klinikaID}")
	public ArrayList<Pregled> nadjiPredefinisanePregledeKlinike2(@PathVariable Integer klinikaID) {
		return pregledService.nadjiPredefinisanePregledeKlinike2(klinikaID);
	}
	
	@PutMapping(value = "zakazivanjePredefinisanogPregleda/{pregledID}/{pacijentID}")
	public void zakaziPredefinisanPregled(@PathVariable Integer pregledID, @PathVariable Integer pacijentID) {
		pregledService.zakaziPredefinisanPregled(pregledID, pacijentID);
		System.out.println("Predefinisani pregled, ID - " + pregledID + " je uspesno zakazan za pacijenta, ID - " + pacijentID);
	}
	
	//Pregledi jednog lekara
	
	//Pregledi u jednoj sali
	
	//Pregledi jednog pacijenta
}
