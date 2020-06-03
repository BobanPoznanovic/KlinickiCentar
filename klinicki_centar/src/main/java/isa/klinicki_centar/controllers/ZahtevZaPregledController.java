package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import isa.klinicki_centar.model.ZahtevZaPregled;
import isa.klinicki_centar.model.dto.ZahtevZaPregledDTO;
import isa.klinicki_centar.services.ZahtevZaPregledService;

@RestController
@RequestMapping(path = "/zahtevZaPregled")
@CrossOrigin(origins = "*")
public class ZahtevZaPregledController {

	@Autowired
	private ZahtevZaPregledService zahtevZaPregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ZahtevZaPregledDTO>> getAll() {
		List<ZahtevZaPregledDTO> retVal = new ArrayList<ZahtevZaPregledDTO>();
		
		Iterable<ZahtevZaPregled> queryResult = zahtevZaPregledService.findAll();
		
		for(ZahtevZaPregled z : queryResult) {
			retVal.add(new ZahtevZaPregledDTO(z));
		}
		
		return new ResponseEntity<List<ZahtevZaPregledDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ZahtevZaPregledDTO> getTipPregleda(@PathVariable Integer id) {
		
		ZahtevZaPregled queryResult = zahtevZaPregledService.findOne(id);
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaPregledDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ZahtevZaPregledDTO>(new ZahtevZaPregledDTO(queryResult), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaPregledDTO> saveTipPregleda(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO) {
		
		ZahtevZaPregled noviZahtevZaPregled = new ZahtevZaPregled();
		
		noviZahtevZaPregled.setKlinikaID(zahtevZaPregledDTO.getKlinikaID());
		noviZahtevZaPregled.setPacijentID(zahtevZaPregledDTO.getPacijentID());
		noviZahtevZaPregled.setDatum(zahtevZaPregledDTO.getDatum());
		noviZahtevZaPregled.setSatnica_pocetak(zahtevZaPregledDTO.getSatnica_pocetak());
		noviZahtevZaPregled.setSatnica_kraj(zahtevZaPregledDTO.getSatnica_kraj());
		noviZahtevZaPregled.setLekarID(zahtevZaPregledDTO.getLekarID());
		noviZahtevZaPregled.setTip_pregledaID(zahtevZaPregledDTO.getTip_pregledaID());
		noviZahtevZaPregled.setPopust(zahtevZaPregledDTO.getPopust());
		noviZahtevZaPregled.setPotvrdjen(false);
		
		noviZahtevZaPregled = zahtevZaPregledService.save(noviZahtevZaPregled);
		
		return new ResponseEntity<ZahtevZaPregledDTO>(new ZahtevZaPregledDTO(noviZahtevZaPregled), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<ZahtevZaPregledDTO> updateTipPregleda(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO) {
		
		ZahtevZaPregled queryResult = zahtevZaPregledService.findOne(zahtevZaPregledDTO.getZahtevID());
		
		if(queryResult == null) {
			return new ResponseEntity<ZahtevZaPregledDTO>(HttpStatus.BAD_REQUEST);
		}
		
		queryResult.setKlinikaID(zahtevZaPregledDTO.getKlinikaID());
		queryResult.setPacijentID(zahtevZaPregledDTO.getPacijentID());
		queryResult.setDatum(zahtevZaPregledDTO.getDatum());
		queryResult.setSatnica_pocetak(zahtevZaPregledDTO.getSatnica_pocetak());
		queryResult.setSatnica_kraj(zahtevZaPregledDTO.getSatnica_kraj());
		queryResult.setLekarID(zahtevZaPregledDTO.getLekarID());
		queryResult.setTip_pregledaID(zahtevZaPregledDTO.getTip_pregledaID());
		queryResult.setPopust(zahtevZaPregledDTO.getPopust());
		queryResult.setPotvrdjen(zahtevZaPregledDTO.getPotvrdjen());
		
		queryResult = zahtevZaPregledService.save(queryResult);
		
		return new ResponseEntity<ZahtevZaPregledDTO>(new ZahtevZaPregledDTO(queryResult), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTipPregleda(@PathVariable Integer id) {
		
		ZahtevZaPregled queryResult = zahtevZaPregledService.findOne(id);
		
		if(queryResult != null) {
			zahtevZaPregledService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// termin prosledjivati kao string ?
	
	@PutMapping("slanjeZahteva/{tipPregledaID}/{datum}/{klinikaID}/{lekarID}/{pacijentID}/{termin}")
	public void posaljiZahtev(
						@PathVariable Integer tipPregledaID,
						@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datum,
						@PathVariable Integer klinikaID,
						@PathVariable Integer lekarID,
						@PathVariable Integer pacijentID,
						@PathVariable String termin) {
		
        String[] time = termin.split(":");
        String hours = time[0];
        String minutes = time[1];

        Calendar cal = Calendar.getInstance();
        cal.setTime(datum);

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));

        Date d = cal.getTime();
		
		zahtevZaPregledService.posaljiZahtev(tipPregledaID, d, klinikaID, lekarID, pacijentID);

	}
}
