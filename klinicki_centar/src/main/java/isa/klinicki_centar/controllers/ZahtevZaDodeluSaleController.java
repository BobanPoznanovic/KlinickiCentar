package isa.klinicki_centar.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
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

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.StatusZahtevaZaDodeluSale;
import isa.klinicki_centar.model.ZahtevZaDodeluSale;
import isa.klinicki_centar.model.dto.ZahtevZaDodeluSaleDTO;
import isa.klinicki_centar.services.OperacijaService;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.ZahtevZaDodeluSaleService;

@Controller
@RequestMapping(path = "/zahtev/sala")
public class ZahtevZaDodeluSaleController {
	
	@Autowired
	private ZahtevZaDodeluSaleService zahtevZaDodeluSaleService;
	
	@Autowired
	private OperacijaService operacijaService;
	
	@Autowired
	private PregledService pregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaDodeluSaleDTO>> findAll() {
		
		List<ZahtevZaDodeluSaleDTO> retVal = new ArrayList<ZahtevZaDodeluSaleDTO>();
		
		Iterable<ZahtevZaDodeluSale> queryResult = zahtevZaDodeluSaleService.findAll();
		
		for(ZahtevZaDodeluSale z : queryResult) {
			retVal.add(new ZahtevZaDodeluSaleDTO(z));
		}
		
		return new ResponseEntity<List<ZahtevZaDodeluSaleDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> getZahtevZaDodeluSale(@PathVariable Integer id) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> saveZahtevZaDodeluSale(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		ZahtevZaDodeluSale noviZahtev = new ZahtevZaDodeluSale();
		
		noviZahtev.setDatum_kreiranja_zahteva(LocalDate.parse(zahtev.getDatum_kreiranja_zahteva()));
		noviZahtev.setSalaID(zahtev.getSalaID());
		noviZahtev.setStatus_zahteva(StatusZahtevaZaDodeluSale.Nije_procesuiran);
		noviZahtev.setVreme_kreiranja_zahteva(LocalTime.parse(zahtev.getVreme_kreiranja_zahteva()));
		noviZahtev.setOperacijaID(zahtev.getOperacijaID());
		noviZahtev.setZahtevID(zahtev.getZahtevID());
		
		noviZahtev = zahtevZaDodeluSaleService.save(noviZahtev);
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(noviZahtev), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> updateZahtevZaDodeluSale(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(zahtev.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setDatum_kreiranja_zahteva(LocalDate.parse(zahtev.getDatum_kreiranja_zahteva()));
		queryResult.setSalaID(zahtev.getSalaID());
		for(StatusZahtevaZaDodeluSale status : StatusZahtevaZaDodeluSale.values()) {
			if(status.name().equalsIgnoreCase(zahtev.getStatus_zahteva())) {
				queryResult.setStatus_zahteva(status);
			}
		}
		queryResult.setVreme_kreiranja_zahteva(LocalTime.parse(zahtev.getVreme_kreiranja_zahteva()));
		queryResult.setOperacijaID(zahtev.getOperacijaID());
		queryResult.setZahtevID(zahtev.getZahtevID());
		
		queryResult = zahtevZaDodeluSaleService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(new ZahtevZaDodeluSaleDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteZahtevZaDodeluSale(@PathVariable Integer id) {
		
		ZahtevZaDodeluSale queryResult = zahtevZaDodeluSaleService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaDodeluSaleService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/check")
	public ResponseEntity<ZahtevZaDodeluSaleDTO> checkSalaAvailability(@RequestBody ZahtevZaDodeluSaleDTO zahtev) {
		
		Operacija operacija = operacijaService.findOne(zahtev.getOperacijaID());
		
		List<Operacija> operacijeByDateAndSalaID = operacijaService.byDataAndSalaID(operacija.getDatum_operacije().toString(), zahtev.getSalaID());
		
		List<Pregled> preglediByDateAndSalaID = pregledService.byDateAndSalaID(operacija.getDatum_operacije().toString(), zahtev.getSalaID());
		
		return new ResponseEntity<ZahtevZaDodeluSaleDTO>(HttpStatus.OK);
	}

}
