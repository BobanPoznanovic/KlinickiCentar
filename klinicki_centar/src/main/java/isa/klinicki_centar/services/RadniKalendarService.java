package isa.klinicki_centar.services;

import java.util.ArrayList;
import java.util.Date;

import isa.klinicki_centar.model.CalendarDay;
import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.CalendarMonth;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;
import isa.klinicki_centar.model.dto.CalendarDayDTO;
import isa.klinicki_centar.model.dto.CalendarEventDTO;

public interface RadniKalendarService {
	
	CalendarEvent fromPregled(Pregled pregled);
	
	CalendarEvent fromOperacija(Operacija operacija);

	int findMinimum(ArrayList<Pregled> lista);
	
	Date convertStringToDate(String datum);
	
	ArrayList<Date> datesInWeek(Date date);
	
	ArrayList<Pregled> populateDay(Integer lekarID, Date datum);
	
	ArrayList<Pregled> sortPregledi(ArrayList<Pregled> pregledi);
	
	ArrayList<CalendarEvent> preglediToEvents(ArrayList<Pregled> pregledi);
	
	ArrayList<CalendarEventDTO> eventsToDTO(ArrayList<CalendarEvent> events);
	
	ArrayList<CalendarDayDTO> daysToDTO(ArrayList<CalendarDay> days);
	
	ArrayList<Date> datesInMonth(Date date);
	
	int getMonth(Date date);
	
	int getYear(Date date);
	
	int dayInWeek(Date date);
	
	CalendarMonth month(Integer lekarID, String datum);
	
}
