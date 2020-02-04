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

import isa.klinicki_centar.model.IzvestajPregleda;
import isa.klinicki_centar.model.dto.IzvestajPregledaDTO;
import isa.klinicki_centar.services.IzvestajPregledaService;

@Controller
@RequestMapping(path = "/pregled/izvestaj")
public class IzvestajPregledaController {

	@Autowired
	private IzvestajPregledaService izvestajPregledaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<IzvestajPregledaDTO>> findAll() {
		
		List<IzvestajPregledaDTO> retVal = new ArrayList<IzvestajPregledaDTO>();
		
		Iterable<IzvestajPregleda> queryResult = izvestajPregledaService.findAll();
		
		for(IzvestajPregleda i : queryResult) {
			retVal.add(new IzvestajPregledaDTO(i));
		}
		
		return new ResponseEntity<List<IzvestajPregledaDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IzvestajPregledaDTO> findIzvestajPregleda(@PathVariable Integer id) {
		
		IzvestajPregleda queryResult = izvestajPregledaService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<IzvestajPregledaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<IzvestajPregledaDTO>(new IzvestajPregledaDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<IzvestajPregledaDTO> saveIzvestajPregleda(@RequestBody IzvestajPregledaDTO izvestaj) {
		
		IzvestajPregleda noviIzvestaj = new IzvestajPregleda();
		
		noviIzvestaj.setDijagnozaID(izvestaj.getDijagnozaID());
		noviIzvestaj.setIzvestaj_pregledaID(izvestaj.getIzvestaj_pregledaID());
		noviIzvestaj.setOpis_pregleda(izvestaj.getOpis_pregleda());
		noviIzvestaj.setPregledID(izvestaj.getPregledID());
		
		noviIzvestaj = izvestajPregledaService.save(noviIzvestaj);
		
		return new ResponseEntity<IzvestajPregledaDTO>(new IzvestajPregledaDTO(noviIzvestaj), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<IzvestajPregledaDTO> updateIzvestajPregleda(@RequestBody IzvestajPregledaDTO izvestaj) {
		
		IzvestajPregleda queryResult = izvestajPregledaService.findOne(izvestaj.getIzvestaj_pregledaID());
		
		if(queryResult == null) {
			return new ResponseEntity<IzvestajPregledaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDijagnozaID(izvestaj.getDijagnozaID());
		queryResult.setIzvestaj_pregledaID(izvestaj.getIzvestaj_pregledaID());
		queryResult.setOpis_pregleda(izvestaj.getOpis_pregleda());
		queryResult.setPregledID(izvestaj.getPregledID());
		
		queryResult = izvestajPregledaService.save(queryResult);
		
		return new ResponseEntity<IzvestajPregledaDTO>(new IzvestajPregledaDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteIzvestajPregleda(@PathVariable Integer id) {
		
		IzvestajPregleda queryResult = izvestajPregledaService.findOne(id);
		
		if(queryResult != null) {
			izvestajPregledaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
