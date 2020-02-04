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

import isa.klinicki_centar.model.Lekar;
import isa.klinicki_centar.model.dto.LekarDTO;
import isa.klinicki_centar.services.LekarService;

@Controller
@RequestMapping(path = "/lekar")
public class LekarController {
	
	@Autowired
	private LekarService lekarService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<LekarDTO>> getAll() {
		
		List<LekarDTO> retVal = new ArrayList<LekarDTO>();
		
		Iterable<Lekar> queryResult = lekarService.findAll();
		
		for(Lekar l : queryResult) {
			retVal.add(new LekarDTO(l));
		}
		
		return new ResponseEntity<List<LekarDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LekarDTO> getDijagnoza(@PathVariable Integer id) {
		
		Lekar queryResult = lekarService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<LekarDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<LekarDTO> saveDijagnoza(@RequestBody LekarDTO lekar) {
		
		Lekar noviLekar = new Lekar();
		
		noviLekar.setAdresa(lekar.getAdresa());
		noviLekar.setEmail(lekar.getEmail());
		noviLekar.setIme(lekar.getIme());
		noviLekar.setIzmenjena_sifra_nakon_prvog_logovanja(lekar.getIzmenjena_sifra_nakon_prvog_logovanja());
		noviLekar.setKlinikaID(lekar.getKlinikaID());
		noviLekar.setKontakt_telefon(lekar.getKontakt_telefon());
		noviLekar.setLekarID(lekar.getLekarID());
		noviLekar.setPassword(lekar.getPassword());
		noviLekar.setPrezime(lekar.getPrezime());
		noviLekar.setSpecijalizacijaID(lekar.getSpecijalizacijaID());
		noviLekar.setUsername(lekar.getUsername());
		
		noviLekar = lekarService.save(noviLekar);
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(noviLekar), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<LekarDTO> updateDijagnoz(@RequestBody LekarDTO lekar) {
		
		Lekar queryResult = lekarService.findOne(lekar.getLekarID());
		
		if(queryResult == null) {
			return new ResponseEntity<LekarDTO>(HttpStatus.BAD_REQUEST);
		}
		
		//queryResult.setDijagnozaID(dijagnoza.getDijagnozaID());
		queryResult.setAdresa(lekar.getAdresa());
		queryResult.setEmail(lekar.getEmail());
		queryResult.setIme(lekar.getIme());
		queryResult.setIzmenjena_sifra_nakon_prvog_logovanja(lekar.getIzmenjena_sifra_nakon_prvog_logovanja());
		queryResult.setKlinikaID(lekar.getKlinikaID());
		queryResult.setKontakt_telefon(lekar.getKontakt_telefon());
		queryResult.setLekarID(lekar.getLekarID());
		queryResult.setPassword(lekar.getPassword());
		queryResult.setPrezime(lekar.getPrezime());
		queryResult.setSpecijalizacijaID(lekar.getSpecijalizacijaID());
		queryResult.setUsername(lekar.getUsername());
		
		queryResult = lekarService.save(queryResult);
		
		return new ResponseEntity<LekarDTO>(new LekarDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDijagnoza(@PathVariable Integer id) {
		
		Lekar queryResult = lekarService.findOne(id);
		
		if(queryResult != null) {
			lekarService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
