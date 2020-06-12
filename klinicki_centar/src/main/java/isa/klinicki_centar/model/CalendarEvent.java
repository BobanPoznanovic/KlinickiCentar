package isa.klinicki_centar.model;

import java.time.LocalTime;
import java.util.Date;

public class CalendarEvent {
	
	private Date datum;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	//tip kalendarskog dogadjaja: Pregled(0), Operacija(1)
	private int tip;
	
	private Integer pacijentID;
	
	public CalendarEvent() {
		
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
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

}
