package isa.klinicki_centar.controllers;

import java.time.LocalDate;
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

import isa.klinicki_centar.model.Pacijent;
import isa.klinicki_centar.model.ZdravstveniKarton;
import isa.klinicki_centar.model.dto.ZdravstveniKartonDTO;
import isa.klinicki_centar.services.PacijentService;
import isa.klinicki_centar.services.ZdravstveniKartonService;

@RestController
@RequestMapping(path = "/karton")
@CrossOrigin(origins = "*")
public class ZdravstveniKartonController {
	
	@Autowired
	private ZdravstveniKartonService zdravstveniKartonService;
	
	@Autowired
	private PacijentService pacijentService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZdravstveniKartonDTO>> findAll() {
		
		List<ZdravstveniKartonDTO> retVal = new ArrayList<ZdravstveniKartonDTO>();
		
		Iterable<ZdravstveniKarton> queryResult = zdravstveniKartonService.findAll();
		
		for(ZdravstveniKarton z : queryResult) {
			retVal.add(new ZdravstveniKartonDTO(z));
		}
		
		return new ResponseEntity<List<ZdravstveniKartonDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZdravstveniKartonDTO> getZdravstveniKarton(@PathVariable Integer id) {
		
		ZdravstveniKarton queryResult = zdravstveniKartonService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZdravstveniKartonDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZdravstveniKartonDTO>(new ZdravstveniKartonDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZdravstveniKartonDTO> saveZdravstveniKarton(@RequestBody ZdravstveniKartonDTO karton) {
		
		Pacijent pacijent = pacijentService.findOne(karton.getPacijentID());
		
		if(pacijent == null) {
			return new ResponseEntity<ZdravstveniKartonDTO>(HttpStatus.NOT_FOUND);
		}
		
		ZdravstveniKarton noviKarton = new ZdravstveniKarton();
		
		noviKarton.setDatum_rodjenja(LocalDate.parse(karton.getDatum_rodjenja()));
		noviKarton.setDioptrija(karton.getDioptrija());
		noviKarton.setKartonID(karton.getKartonID());
		noviKarton.setKrvna_grupa(karton.getKrvna_grupa());
		noviKarton.setPacijentID(karton.getPacijentID());
		noviKarton.setTezina_pacijenta(karton.getTezina_pacijenta());
		noviKarton.setVisina_pacijenta(karton.getVisina_pacijenta());
		
		noviKarton = zdravstveniKartonService.save(noviKarton);
		
		pacijent.setZdravstveni_kartonID(noviKarton.getKartonID());
		
		pacijentService.save(pacijent);
		
		return new ResponseEntity<ZdravstveniKartonDTO>(new ZdravstveniKartonDTO(noviKarton), HttpStatus.CREATED);		
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZdravstveniKartonDTO> updateZdravstveniKarton(@RequestBody ZdravstveniKartonDTO karton) {
		
		ZdravstveniKarton queryResult = zdravstveniKartonService.findOne(karton.getKartonID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZdravstveniKartonDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDatum_rodjenja(LocalDate.parse(karton.getDatum_rodjenja()));
		queryResult.setDioptrija(karton.getDioptrija());
		queryResult.setKartonID(karton.getKartonID());
		queryResult.setKrvna_grupa(karton.getKrvna_grupa());
		queryResult.setPacijentID(karton.getPacijentID());
		queryResult.setTezina_pacijenta(karton.getTezina_pacijenta());
		queryResult.setVisina_pacijenta(karton.getVisina_pacijenta());
		
		queryResult = zdravstveniKartonService.save(queryResult);
		
		return new ResponseEntity<ZdravstveniKartonDTO>(new ZdravstveniKartonDTO(queryResult), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZdravstveniKarton(@PathVariable Integer id) {
		
		ZdravstveniKarton queryResult = zdravstveniKartonService.findOne(id);
		
		if(queryResult != null) {
			zdravstveniKartonService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/pacijent/{id}")
	public ResponseEntity<ZdravstveniKartonDTO> nadjiPacijentovKarton(@PathVariable Integer id) {
		
		ZdravstveniKarton queryResult = zdravstveniKartonService.nadjiPacijentovKarton(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZdravstveniKartonDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZdravstveniKartonDTO>(new ZdravstveniKartonDTO(queryResult), HttpStatus.OK);
	}
	
	
}
