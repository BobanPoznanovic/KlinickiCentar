package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.dto.OperacijaDTO;
import isa.klinicki_centar.services.OperacijaService;

@RestController
@RequestMapping(path = "/operacija")
@CrossOrigin(origins = "*")
public class OperacijaController {

	@Autowired
	private OperacijaService operacijaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<OperacijaDTO>> getAll() {
		
		List<OperacijaDTO> retVaI = new ArrayList<OperacijaDTO>();
		
		Iterable<Operacija> queryResult = operacijaService.findAll();
		
		for(Operacija k : queryResult) {
			retVaI.add(new OperacijaDTO(k));
		}
		
		return new ResponseEntity<>(retVaI, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OperacijaDTO> getKlinika(@PathVariable Integer id) {
		
		Operacija operacija = operacijaService.findOne(id);
		
		if(operacija == null) {
			return new ResponseEntity<OperacijaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<OperacijaDTO>(new OperacijaDTO(operacija), HttpStatus.OK);
		
	}
	
	@GetMapping("/pacijentoveOperacije/{pacijentID}")
	public ArrayList<Operacija> nadjiSvePacijentoveOperacije(@PathVariable Integer pacijentID) {
		return operacijaService.nadjiSvePacijentoveOperacije(pacijentID);
	}
	
	@GetMapping("/pacijentoveOperacijeOcenjivanje/{pacijentID}/{datumOperacije}")
	public ArrayList<Operacija> nadjiSveOperacijeZaOcenjivanje(@PathVariable Integer pacijentID, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date datumOperacije) {
		return operacijaService.nadjiSveOperacijeZaOcenjivanje(pacijentID, datumOperacije);
	}
	
}
