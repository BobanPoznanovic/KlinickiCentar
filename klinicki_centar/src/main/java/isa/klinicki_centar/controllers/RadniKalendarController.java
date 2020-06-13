package isa.klinicki_centar.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;
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
		
		ArrayList<CalendarEventDTO> retVal = new ArrayList<CalendarEventDTO>();
		
		//INPUTS:
		//lekarID
		//datum
		
		//CONVERT STRING datum TO DATE datum
		
		//COLLECT:
		//pregledi DODAJ PRETRAGU PO DATUMU
		ArrayList<Pregled> pregledi = pregledService.sviDoktoroviPregledi(lekarID);
		//operacije DODAJ PRETRAGU PO DATUMU
		ArrayList<SpisakLekaraNaOperaciji> spisak = spisakLekaraNaOperacijiService.findByLekarID(lekarID);
		ArrayList<Operacija> operacije = new ArrayList<Operacija>();
		
		for(SpisakLekaraNaOperaciji item : spisak) {
			operacije.add(operacijeService.findOne(item.getOperacijaID()));
		}
		
		//SORT:
		
		//CONVERT TO CALENDAR EVENT
		for(Pregled p : pregledi) {
			CalendarEvent e = new CalendarEvent(p);
			retVal.add(new CalendarEventDTO(e));
		}
		
		
		return new ResponseEntity<ArrayList<CalendarEventDTO>>(new ArrayList<CalendarEventDTO>(), HttpStatus.OK);
	}

}
