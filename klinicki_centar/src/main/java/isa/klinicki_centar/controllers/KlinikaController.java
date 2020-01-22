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

import isa.klinicki_centar.model.Klinika;
import isa.klinicki_centar.model.dto.KlinikaDTO;
import isa.klinicki_centar.services.KlinikaService;

@Controller
@RequestMapping(path = "/klinika")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<KlinikaDTO>> getAll() {
		
		List<KlinikaDTO> retVaI = new ArrayList<KlinikaDTO>();
		
		Iterable<Klinika> queryResult = klinikaService.findAll();
		
		for(Klinika k : queryResult) {
			retVaI.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(retVaI, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable Integer id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		if(klinika == null) {
			return new ResponseEntity<KlinikaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<KlinikaDTO> saveKlinika(@RequestBody KlinikaDTO klinikaDTO) {
		
		Klinika klinika = new Klinika();
		
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		
		klinika = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<KlinikaDTO> updateKlinika(@RequestBody KlinikaDTO klinikaDTO) {
		
		Klinika klinika = klinikaService.findOne(klinikaDTO.getKlinikaID());
		
		if(klinika == null) {
			return new ResponseEntity<KlinikaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		klinika.setKlinikaID(klinikaDTO.getKlinikaID());
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		
		klinika = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(klinika), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteKlinika(@PathVariable Integer id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		if (klinika != null) {
			klinikaService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
