package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isa.klinicki_centar.model.Dijagnoza;
import isa.klinicki_centar.model.dto.DijagnozaDTO;
import isa.klinicki_centar.repositories.DijagnozaRepository;
import isa.klinicki_centar.services.DijagnozaService;

@Controller
@RequestMapping(path="/dijagnoza")
public class DijagnozaController {
	
	@Autowired
	private DijagnozaService dijagnozaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DijagnozaDTO>> getAll() {
		
		List<DijagnozaDTO> retVal = new ArrayList<DijagnozaDTO>();
		
		Iterable<Dijagnoza> queryResult = dijagnozaService.findAll();
		
		for(Dijagnoza d : queryResult) {
			retVal.add(new DijagnozaDTO(d));
		}
		
		return new ResponseEntity<List<DijagnozaDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DijagnozaDTO> getDijagnoza(@PathVariable Integer id) {
		
		Dijagnoza queryResult = dijagnozaService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<DijagnozaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<DijagnozaDTO>(new DijagnozaDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<DijagnozaDTO> saveDijagnoza(@RequestBody DijagnozaDTO dijagnoza) {
		
		Dijagnoza novaDijagnoza = new Dijagnoza();
		
		novaDijagnoza.setNaziv(dijagnoza.getNaziv());
		
		novaDijagnoza = dijagnozaService.save(novaDijagnoza);
		
		return new ResponseEntity<DijagnozaDTO>(new DijagnozaDTO(novaDijagnoza), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<DijagnozaDTO> updateDijagnoz(@RequestBody DijagnozaDTO dijagnoza) {
		
		Dijagnoza queryResult = dijagnozaService.findOne(dijagnoza.getDijagnozaID());
		
		if(queryResult == null) {
			return new ResponseEntity<DijagnozaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDijagnozaID(dijagnoza.getDijagnozaID());
		queryResult.setNaziv(dijagnoza.getNaziv());
		
		queryResult = dijagnozaService.save(queryResult);
		
		return new ResponseEntity<DijagnozaDTO>(new DijagnozaDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDijagnoza(@PathVariable Integer id) {
		
		Dijagnoza queryResult = dijagnozaService.findOne(id);
		
		if(queryResult != null) {
			dijagnozaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
