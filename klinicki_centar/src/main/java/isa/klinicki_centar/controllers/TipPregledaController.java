package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.TipPregleda;
import isa.klinicki_centar.model.dto.TipPregledaDTO;
import isa.klinicki_centar.services.TipPregledaService;

@RestController
@RequestMapping(path = "/tipPregleda")
@CrossOrigin(origins = "*")
public class TipPregledaController {

	@Autowired
	private TipPregledaService tipPregledaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<TipPregledaDTO>> getAll() {
		List<TipPregledaDTO> retVal = new ArrayList<TipPregledaDTO>();
		
		Iterable<TipPregleda> queryResult = tipPregledaService.findAll();
		
		for(TipPregleda tp : queryResult) {
			retVal.add(new TipPregledaDTO(tp));
		}
		
		return new ResponseEntity<List<TipPregledaDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TipPregledaDTO> getTipPregleda(@PathVariable Integer id) {
		
		TipPregleda queryResult = tipPregledaService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<TipPregledaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TipPregledaDTO>(new TipPregledaDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<TipPregledaDTO> saveTipPregleda(@RequestBody TipPregledaDTO tipPregledaDTO) {
		
		TipPregleda noviTipPregleda = new TipPregleda();
		
		noviTipPregleda.setNaziv(tipPregledaDTO.getNaziv());
		noviTipPregleda.setCena(tipPregledaDTO.getCena());
		
		noviTipPregleda = tipPregledaService.save(noviTipPregleda);
		
		return new ResponseEntity<TipPregledaDTO>(new TipPregledaDTO(noviTipPregleda), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<TipPregledaDTO> updateTipPregleda(@RequestBody TipPregledaDTO tipPregledaDTO) {
		
		TipPregleda queryResult = tipPregledaService.findOne(tipPregledaDTO.getTip_pregledaID());
		
		if(queryResult == null) {
			return new ResponseEntity<TipPregledaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setNaziv(tipPregledaDTO.getNaziv());
		queryResult.setCena(tipPregledaDTO.getCena());
		
		queryResult = tipPregledaService.save(queryResult);
		
		return new ResponseEntity<TipPregledaDTO>(new TipPregledaDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTipPregleda(@PathVariable Integer id) {
		
		TipPregleda queryResult = tipPregledaService.findOne(id);
		
		if(queryResult != null) {
			tipPregledaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
