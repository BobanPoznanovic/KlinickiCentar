package isa.klinicki_centar.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		
		String[] datumDelovi = datum.split("-");
		String mojDatum = datumDelovi[0]+"/"+datumDelovi[1]+"/"+datumDelovi[2];
		

		Date temp = null;
		try {
			temp = new SimpleDateFormat("yyyy/MM/dd").parse(mojDatum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//CONVERT STRING datum TO DATE datum
		
		//COLLECT:
		//pregledi DODAJ PRETRAGU PO DATUMU
		ArrayList<Pregled> pregledi = null;
		try {
			pregledi = pregledService.sviDoktoroviPreglediTrazenogDatuma(lekarID, temp);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//operacije DODAJ PRETRAGU PO DATUMU
		ArrayList<SpisakLekaraNaOperaciji> spisak = spisakLekaraNaOperacijiService.findByLekarID(lekarID);
		ArrayList<Operacija> operacije = new ArrayList<Operacija>();
		
		for(SpisakLekaraNaOperaciji item : spisak) {
			operacije.add(operacijeService.findOne(item.getOperacijaID()));
		}
		
		//SORT:
		ArrayList<Pregled> sortedPregledi = new ArrayList<Pregled>();
		int brojPregleda = pregledi.size();
		int retIntex;
		
		while(sortedPregledi.size()<brojPregleda) {
			retIntex = findMinimum(pregledi);
			sortedPregledi.add(pregledi.get(retIntex));
			pregledi.remove(retIntex);
		}
		
		
		//CONVERT TO CALENDAR EVENT
		for(Pregled p : sortedPregledi) {
			CalendarEvent e = new CalendarEvent(p);
			retVal.add(new CalendarEventDTO(e));
		}
		
		
		return new ResponseEntity<ArrayList<CalendarEventDTO>>(retVal, HttpStatus.OK);
	}
	
	int findMinimum(ArrayList<Pregled> lista) {
		Pregled min = lista.get(0);
		int retVal = 0;
		int index = 0;
		
		for(Pregled p : lista) {
			if((min.getSatnica_pocetak().compareTo(p.getSatnica_pocetak()))>0) {
				min = p;
				retVal = index;
			}
			index++;
		}
		
		return retVal;
	}

}
