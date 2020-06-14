package isa.klinicki_centar.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.CalendarWeek;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.SpisakLekaraNaOperaciji;
import isa.klinicki_centar.model.dto.CalendarEventDTO;
import isa.klinicki_centar.model.dto.CalendarWeekDTO;
import isa.klinicki_centar.services.OperacijaService;
import isa.klinicki_centar.services.PregledService;
import isa.klinicki_centar.services.RadniKalendarService;
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
	
	@Autowired
	private RadniKalendarService radniKalendarService;
	
	@GetMapping(value = "/day/{lekarID}/{datum}")
	public ResponseEntity<ArrayList<CalendarEventDTO>> day(@PathVariable Integer lekarID, @PathVariable String datum) {
		
		ArrayList<CalendarEventDTO> retVal = new ArrayList<CalendarEventDTO>();
		Date temp = null;
		
		temp = radniKalendarService.convertStringToDate(datum);
		
		ArrayList<Pregled> pregledi = null;
		
		pregledi = radniKalendarService.populateDay(lekarID, temp);
		
		//operacije DODAJ PRETRAGU PO DATUMU
		/*
		ArrayList<SpisakLekaraNaOperaciji> spisak = spisakLekaraNaOperacijiService.findByLekarID(lekarID);
		ArrayList<Operacija> operacije = new ArrayList<Operacija>();
		
		for(SpisakLekaraNaOperaciji item : spisak) {
			operacije.add(operacijeService.findOne(item.getOperacijaID()));
		}
		*/
		
		ArrayList<Pregled> sortedPregledi = new ArrayList<Pregled>();

		sortedPregledi = radniKalendarService.sortPregledi(pregledi);
		
		for(Pregled p : sortedPregledi) {
			CalendarEvent e = new CalendarEvent(p);
			retVal.add(new CalendarEventDTO(e));
		}
		
		
		return new ResponseEntity<ArrayList<CalendarEventDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/week/{lekarID}/{datum}")
	public ResponseEntity<CalendarWeekDTO> week(@PathVariable Integer lekarID, @PathVariable String datum) {
		
		CalendarWeekDTO retVal = new CalendarWeekDTO();
		CalendarWeek week = new CalendarWeek();
		
		Date d_datum = null;
		d_datum = radniKalendarService.convertStringToDate(datum);
		
		ArrayList<Date> datesToCheck = new ArrayList<Date>();
		
		datesToCheck = radniKalendarService.datesInWeek(d_datum);
		
		//popupi preglede za dan, sortiraj, konvertuj
		ArrayList<Pregled> temp_pregledi = new ArrayList<Pregled>();
		ArrayList<Pregled> temp_sorted_pregledi = new ArrayList<Pregled>();
		
		//Sunday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(0));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> sunday = new ArrayList<CalendarEvent>();
		sunday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Monday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(1));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> monday = new ArrayList<CalendarEvent>();
		monday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Tuesday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(2));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> tuesday = new ArrayList<CalendarEvent>();
		tuesday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Wednesday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(3));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> wednesday = new ArrayList<CalendarEvent>();
		wednesday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Thusday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(4));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> thursday = new ArrayList<CalendarEvent>();
		thursday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Friday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(5));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> friday = new ArrayList<CalendarEvent>();
		friday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		//Saturday
		temp_pregledi = radniKalendarService.populateDay(lekarID, datesToCheck.get(6));
		temp_sorted_pregledi = radniKalendarService.sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> saturday = new ArrayList<CalendarEvent>();
		saturday = radniKalendarService.preglediToEvents(temp_sorted_pregledi);
		
		week.setMonday(monday);
		week.setTuesday(tuesday);
		week.setWednesday(wednesday);
		week.setThursday(thursday);
		week.setFriday(friday);
		week.setSaturday(saturday);
		week.setSunday(sunday);
		
		week.setMonth(radniKalendarService.getMonth(datesToCheck.get(0)));
		week.setYear(radniKalendarService.getYear(datesToCheck.get(0)));
		
		//Boolean vrednosti postaviti na false
		week.setFirstWeekInMonth(false);
		week.setLastWeekInMonth(false);
		
		retVal = new CalendarWeekDTO(week);
		
		return new ResponseEntity<CalendarWeekDTO>(retVal, HttpStatus.OK);
	}
	
	

}
