package isa.klinicki_centar.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

import isa.klinicki_centar.services.RadniKalendarService;
import isa.klinicki_centar.services.SalaService;

public class CalendarEvent {
	
	private LocalDate datum;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	//tip kalendarskog dogadjaja: Pregled(0), Operacija(1)
	private int tip;
	
	private Integer eventID;
	
	private Integer pacijentID;
	
	private String naziv_sale;
	
	private Integer broj_sale;
	
	public CalendarEvent() {
		
	}
	
	public CalendarEvent(Pregled pregled) {
		Date date_datum = pregled.getDatum_pregleda();
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = date_datum.toInstant();
		
		LocalDate datum = instant.atZone(defaultZoneId).toLocalDate();
		
		this.setDatum(datum);
		this.setSatnica_pocetak(pregled.getSatnica_pocetak());
		this.setSatnica_kraj(pregled.getSatnica_kraj());
		this.setTip(0);
		this.setEventID(pregled.getPregledID());
		this.setPacijentID(pregled.getPacijentID());
		
		//this.setNaziv_sale(sala.getNaziv_sale());
		//this.setBroj_sale(sala.getBroj_sale());
	}
	
	public CalendarEvent(Operacija operacija) {
		
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public LocalTime getSatnica_pocetak() {
		return satnica_pocetak;
	}

	public void setSatnica_pocetak(LocalTime satnica_pocetak) {
		this.satnica_pocetak = satnica_pocetak;
	}

	public LocalTime getSatnica_kraj() {
		return satnica_kraj;
	}

	public void setSatnica_kraj(LocalTime satnica_kraj) {
		this.satnica_kraj = satnica_kraj;
	}

	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public Integer getEventID() {
		return eventID;
	}

	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}

	public String getNaziv_sale() {
		return naziv_sale;
	}

	public void setNaziv_sale(String naziv_sale) {
		this.naziv_sale = naziv_sale;
	}

	public Integer getBroj_sale() {
		return broj_sale;
	}

	public void setBroj_sale(Integer broj_sale) {
		this.broj_sale = broj_sale;
	}

}
