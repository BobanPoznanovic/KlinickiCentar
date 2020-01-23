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

import isa.klinicki_centar.model.MedicinskaSestra;
import isa.klinicki_centar.model.dto.MedicinskaSestraDTO;
import isa.klinicki_centar.services.MedicinskaSestraService;

@Controller
@RequestMapping(path = "/sestra")
public class MedicinskaSestraController {
	
	@Autowired
	private MedicinskaSestraService medicinskaSestraService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicinskaSestraDTO>> getAll() {
		
		List<MedicinskaSestraDTO> retVal = new ArrayList<MedicinskaSestraDTO>();
		
		Iterable<MedicinskaSestra> sestre = medicinskaSestraService.findAll();
		
		for(MedicinskaSestra s : sestre) {
			retVal.add(new MedicinskaSestraDTO(s));
		}
		
		return new ResponseEntity<List<MedicinskaSestraDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicinskaSestraDTO> getMedicinskaSestra(@PathVariable Integer id) {
		
		MedicinskaSestra queryResult = medicinskaSestraService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<MedicinskaSestraDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MedicinskaSestraDTO>(new MedicinskaSestraDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<MedicinskaSestraDTO> saveMedicinskaSestra(@RequestBody MedicinskaSestraDTO sestra) {
		
		MedicinskaSestra novaSestra = new MedicinskaSestra();
		
		novaSestra.setAdresa(sestra.getAdresa());
		novaSestra.setEmail(sestra.getEmail());
		novaSestra.setIme(sestra.getIme());
		novaSestra.setIzmenjana_sifra_nakon_prvog_logovanja(sestra.getIzmenjana_sifra_nakon_prvog_logovanja());
		novaSestra.setKlinikaID(sestra.getKlinikaID());
		novaSestra.setKontakt_telefon(sestra.getKontakt_telefon());
		novaSestra.setMedicinska_sestraID(sestra.getMedicinska_sestraID());
		novaSestra.setPassword(sestra.getPassword());
		novaSestra.setPrezime(sestra.getPrezime());
		novaSestra.setUsername(sestra.getUsername());
		
		novaSestra = medicinskaSestraService.save(novaSestra);
		
		return new ResponseEntity<MedicinskaSestraDTO>(new MedicinskaSestraDTO(novaSestra), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<MedicinskaSestraDTO> updateMedicinskaSestra(@RequestBody MedicinskaSestraDTO sestra) {
		
		MedicinskaSestra queryResult = medicinskaSestraService.findOne(sestra.getMedicinska_sestraID());
		
		if(queryResult == null) {
			return new ResponseEntity<MedicinskaSestraDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setAdresa(sestra.getAdresa());
		queryResult.setEmail(sestra.getEmail());
		queryResult.setIme(sestra.getIme());
		queryResult.setIzmenjana_sifra_nakon_prvog_logovanja(sestra.getIzmenjana_sifra_nakon_prvog_logovanja());
		queryResult.setKlinikaID(sestra.getKlinikaID());
		queryResult.setKontakt_telefon(sestra.getKontakt_telefon());
		queryResult.setMedicinska_sestraID(sestra.getMedicinska_sestraID());
		queryResult.setPassword(sestra.getPassword());
		queryResult.setPrezime(sestra.getPrezime());
		queryResult.setUsername(sestra.getUsername());
		
		queryResult = medicinskaSestraService.save(queryResult);
		
		return new ResponseEntity<MedicinskaSestraDTO>(new MedicinskaSestraDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteMedicinskaSestra(@PathVariable Integer id) {
		
		MedicinskaSestra queryResult = medicinskaSestraService.findOne(id);
		
		if(queryResult != null) {
			medicinskaSestraService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
