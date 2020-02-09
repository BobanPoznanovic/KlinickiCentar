package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Operacija;
import isa.klinicki_centar.model.Pregled;

public class SimpleEventDTO {

	private String tipDogadjaja;
	
	private Integer eventID;
	
	private String startTime;
	
	private String endTime;
	
	public SimpleEventDTO() {
		
	}
	
	public SimpleEventDTO(Operacija operacije) {
		this("Operacija", operacije.getOperacijaID(), operacije.getSatnica_pocetka_operacije().toString(), operacije.getSatnica_kraja_operacije().toString());
	}
	
	public SimpleEventDTO(Pregled pregled) {
		this("Pregled", pregled.getPregledID(), pregled.getSatnica_pocetak().toString(), pregled.getSatnica_kraj().toString());
	}
	
	public SimpleEventDTO(String type, Integer id, String startTime, String endTime) {
		super();
		this.setTipDogadjaja(type);
		this.setEventID(id);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}

	public String getTipDogadjaja() {
		return tipDogadjaja;
	}

	public void setTipDogadjaja(String tipDogadjaja) {
		this.tipDogadjaja = tipDogadjaja;
	}

	public Integer getEventID() {
		return eventID;
	}

	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
