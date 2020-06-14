package isa.klinicki_centar.services;

import java.util.ArrayList;
import java.util.Date;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;

public interface RadniKalendarService {
	
	CalendarEvent fromPregled(Pregled pregled);
	
	CalendarEvent fromOperacija(Operacija operacija);

	int findMinimum(ArrayList<Pregled> lista);
	
	Date convertStringToDate(String datum);
	
	ArrayList<Date> datesInWeek(Date date);
	
	ArrayList<Pregled> populateDay(Integer lekarID, Date datum);
	
	ArrayList<Pregled> sortPregledi(ArrayList<Pregled> pregledi);
	
	ArrayList<CalendarEvent> preglediToEvents(ArrayList<Pregled> pregledi);
	
	int getMonth(Date date);
	
	int getYear(Date date);
	
}
