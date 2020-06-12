package isa.klinicki_centar.model.dto;

import java.time.LocalTime;
import java.util.Date;

import isa.klinicki_centar.model.CalendarEvent;

public class CalendarEventDTO {
	
	private String datum;
	
	private String satnica_pocetak;
	
	private String satnica_kraj;
	
	private int tip;
	
	private Integer pacijentID;
	
	public CalendarEventDTO() {
		
	}
	
	public CalendarEventDTO(CalendarEvent calEvent) {
		this(
				calEvent.getDatum().toString(),
				calEvent.getSatnica_pocetak().toString(),
				calEvent.getSatnica_kraj().toString(),
				calEvent.getTip(),
				calEvent.getPacijentID()
				);
	}
	
	public CalendarEventDTO(String datum, String satnica_pocetak, String satnica_kraj, int tip, Integer pacijentID) {
		super();
		this.setDatum(datum);
		this.setSatnica_pocetak(satnica_pocetak);
		this.setSatnica_kraj(satnica_kraj);
		this.setTip(tip);
		this.setPacijentID(pacijentID);
		
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getSatnica_pocetak() {
		return satnica_pocetak;
	}

	public void setSatnica_pocetak(String satnica_pocetak) {
		this.satnica_pocetak = satnica_pocetak;
	}

	public String getSatnica_kraj() {
		return satnica_kraj;
	}

	public void setSatnica_kraj(String satnica_kraj) {
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

}
