package isa.klinicki_centar.services;

import isa.klinicki_centar.model.CalendarEvent;
import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;

public interface RadniKalendarService {
	
	CalendarEvent fromPregled(Pregled pregled);
	
	CalendarEvent fromOperacija(Operacija operacija);

}
