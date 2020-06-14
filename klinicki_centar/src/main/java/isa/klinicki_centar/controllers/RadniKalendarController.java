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
		Date temp = null;
		
		temp = convertStringToDate(datum);
		
		ArrayList<Pregled> pregledi = null;
		
		pregledi = populateDay(lekarID, temp);
		
		//operacije DODAJ PRETRAGU PO DATUMU
		/*
		ArrayList<SpisakLekaraNaOperaciji> spisak = spisakLekaraNaOperacijiService.findByLekarID(lekarID);
		ArrayList<Operacija> operacije = new ArrayList<Operacija>();
		
		for(SpisakLekaraNaOperaciji item : spisak) {
			operacije.add(operacijeService.findOne(item.getOperacijaID()));
		}
		*/
		
		ArrayList<Pregled> sortedPregledi = new ArrayList<Pregled>();

		sortedPregledi = sortPregledi(pregledi);
		
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
		d_datum = convertStringToDate(datum);
		
		ArrayList<Date> datesToCheck = new ArrayList<Date>();
		
		datesToCheck = datesInWeek(d_datum); //Sun - Mon
		
		//popupi preglede za dan, sortiraj, konvertuj
		ArrayList<Pregled> temp_pregledi = new ArrayList<Pregled>();
		ArrayList<Pregled> temp_sorted_pregledi = new ArrayList<Pregled>();
		
		//Sunday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(0));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> sunday = new ArrayList<CalendarEvent>();
		sunday = preglediToEvents(temp_sorted_pregledi);
		
		//Monday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(1));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> monday = new ArrayList<CalendarEvent>();
		monday = preglediToEvents(temp_sorted_pregledi);
		
		//Tuesday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(2));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> tuesday = new ArrayList<CalendarEvent>();
		tuesday = preglediToEvents(temp_sorted_pregledi);
		
		//Wednesday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(3));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> wednesday = new ArrayList<CalendarEvent>();
		wednesday = preglediToEvents(temp_sorted_pregledi);
		
		//Thusday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(4));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> thursday = new ArrayList<CalendarEvent>();
		thursday = preglediToEvents(temp_sorted_pregledi);
		
		//Friday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(5));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> friday = new ArrayList<CalendarEvent>();
		friday = preglediToEvents(temp_sorted_pregledi);
		
		//Saturday
		temp_pregledi = populateDay(lekarID, datesToCheck.get(6));
		temp_sorted_pregledi = sortPregledi(temp_pregledi);
		
		ArrayList<CalendarEvent> saturday = new ArrayList<CalendarEvent>();
		saturday = preglediToEvents(temp_sorted_pregledi);
		
		week.setMonday(monday);
		week.setTuesday(tuesday);
		week.setWednesday(wednesday);
		week.setThursday(thursday);
		week.setFriday(friday);
		week.setSaturday(saturday);
		week.setSunday(sunday);
		
		week.setMonth(getMonth(datesToCheck.get(0)));
		week.setYear(getYear(datesToCheck.get(0)));
		
		//Boolean vrednosti postaviti na false
		week.setFirstWeekInMonth(false);
		week.setLastWeekInMonth(false);
		
		retVal = new CalendarWeekDTO(week);
		
		return new ResponseEntity<CalendarWeekDTO>(retVal, HttpStatus.OK);
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
	
	Date convertStringToDate(String datum) {
		Date retVal = null;
		
		String[] datumDelovi = datum.split("-");
		String mojDatum = datumDelovi[0]+"/"+datumDelovi[1]+"/"+datumDelovi[2];
		
		try {
			retVal = new SimpleDateFormat("yyyy/MM/dd").parse(mojDatum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return retVal;
	}
	
	ArrayList<Date> datesInWeek(Date date) {
		
		ArrayList<Date> retVal = new ArrayList<Date>();
		
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		int initDayInWeek = cal.get(Calendar.DAY_OF_WEEK);
		int toStartOfTheWeek = 0;
		
		if(initDayInWeek != 1)
			toStartOfTheWeek = initDayInWeek - 1;
		
		toStartOfTheWeek *= -1;
		
		cal.add(Calendar.DATE, toStartOfTheWeek);
		
		Date sunday = cal.getTime();
		retVal.add(sunday);
		
		for(int i = 0; i < 6; i++) {
			cal.add(Calendar.DATE, 1);
			Date temp_date = cal.getTime();
			retVal.add(temp_date);
		}
		
		for(Date d : retVal) {
			System.out.println(d);
		}
		
		return retVal;
	}
	
	ArrayList<Pregled> populateDay(Integer lekarID, Date datum) {
		ArrayList<Pregled> retVal = new ArrayList<Pregled>();
		
		try {
			retVal = pregledService.sviDoktoroviPreglediTrazenogDatuma(lekarID, datum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return retVal;
	}
	
	ArrayList<Pregled> sortPregledi(ArrayList<Pregled> pregledi) {
		
		ArrayList<Pregled> retVal = new ArrayList<Pregled>();
		
		int brojPregleda = pregledi.size();
		int retIntex;
		
		while(retVal.size()<brojPregleda) {
			retIntex = findMinimum(pregledi);
			retVal.add(pregledi.get(retIntex));
			pregledi.remove(retIntex);
		}
		
		return retVal;
	}
	
	ArrayList<CalendarEvent> preglediToEvents(ArrayList<Pregled> pregledi) {
		
		ArrayList<CalendarEvent> retVal = new ArrayList<CalendarEvent>();
		
		for(Pregled p : pregledi) {
			CalendarEvent e = new CalendarEvent(p);
			retVal.add(e);
		}
		
		return retVal;
	}
	
	int getMonth(Date date) {
		
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		return cal.get(Calendar.MONTH);
	}
	
	int getYear(Date date) {
		
		Calendar cal = Calendar.getInstance(new Locale("uk","UA"));
		
		cal.setTime(date);
		
		return cal.get(Calendar.YEAR);
	}

}
