package isa.klinicki_centar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;
import isa.klinicki_centar.model.dto.AdminKlinickogCentraDTO;
import isa.klinicki_centar.model.dto.CalendarEventDTO;
import isa.klinicki_centar.services.OperacijaService;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.SpisakLekaraNaOperacijiService;

@Controller
@RequestMapping(path = "/kalendar")
@CrossOrigin(origins = "*")
public class RadniKalendarController {
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private SpisakLekaraNaOperacijiService spisakLekaraNaOperacijiService;
	
	@Autowired
	private OperacijaService operacijeService;
	
	@GetMapping(value = "/day/{lekarID}/{datum}")
	public ResponseEntity<ArrayList<CalendarEventDTO>> day(@PathVariable Integer lekarID, @PathVariable String datum) {
		//INPUTS:
		//lekarID
		//datum
		
		//COLLECT:
		//pregledi
		ArrayList<Pregled> pregledi = pregledService.sviDoktoroviPregledi(lekarID);
		//operacije
		ArrayList<SpisakLekaraNaOperaciji> spisak = spisakLekaraNaOperacijiService.findByLekarID(lekarID);
		ArrayList<Operacija> operacije = new ArrayList<Operacija>();
		
		for(SpisakLekaraNaOperaciji item : spisak) {
			operacije.add(operacijeService.findOne(item.getOperacijaID()));
		}
		
		//SORT:
		
		//CONVERT TO CALENDAR EVENT
		
		
		return new ResponseEntity<ArrayList<CalendarEventDTO>>(new ArrayList<CalendarEventDTO>(), HttpStatus.OK);
	}

}
