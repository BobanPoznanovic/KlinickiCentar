package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.CalendarEvent;

public class CalendarEventDTO {
	
	private String datum;
	
	private String satnica_pocetak;
	
	private String satnica_kraj;
	
	private int tip;
	
	private Integer eventID;
	
	private Integer pacijentID;
	
	private String naziv_sale;
	
	private Integer broj_sale;
	
	public CalendarEventDTO() {
		
	}
	
	public CalendarEventDTO(CalendarEvent calEvent) {
		this(
				calEvent.getDatum().toString(),
				calEvent.getSatnica_pocetak().toString(),
				calEvent.getSatnica_kraj().toString(),
				calEvent.getTip(),
				calEvent.getEventID(),
				calEvent.getPacijentID(),
				calEvent.getNaziv_sale(),
				calEvent.getBroj_sale()
				);
	}
	
	public CalendarEventDTO(String datum, String satnica_pocetak, String satnica_kraj, int tip, Integer eventID, Integer pacijentID, String naziv_sale, Integer broj_sale) {
		super();
		this.setDatum(datum);
		this.setSatnica_pocetak(satnica_pocetak);
		this.setSatnica_kraj(satnica_kraj);
		this.setTip(tip);
		this.setEventID(eventID);
		this.setPacijentID(pacijentID);
		this.setNaziv_sale(naziv_sale);
		this.setBroj_sale(broj_sale);
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
