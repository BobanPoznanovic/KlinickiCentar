package isa.klinicki_centar.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import isa.klinicki_centar.model.Operacija;

public class OperacijaDTO {

	private Integer operacijaID;
	
	private Integer lekarID;
	
	private LocalDate datum_operacije;
	
	private LocalTime satnica_pocetka_operacije;
	
	private LocalTime satnica_kraja_operacije;
	
	private Integer salaID;
	
	private Integer pacijentID;
	
	private Boolean lekar_ocenjen;
	
	private Boolean klinika_ocenjena;

	public OperacijaDTO(Operacija operacija) {
		this(
				operacija.getOperacijaID(), operacija.getLekarID(), operacija.getDatum_operacije(),
				operacija.getSatnica_pocetka_operacije(), operacija.getSatnica_kraja_operacije(),
				operacija.getSalaID(), operacija.getPacijentID(),
				operacija.getLekar_ocenjen(), operacija.getKlinika_ocenjena()
			);
	}

	public OperacijaDTO(Integer operacijaID, Integer lekarID, LocalDate datum_operacije, LocalTime satnica_pocetka_operacije,
			LocalTime satnica_kraja_operacije, Integer salaID, Integer pacijentID, Boolean lekar_ocenjen,
			Boolean klinika_ocenjena) {
		super();
		this.operacijaID = operacijaID;
		this.lekarID = lekarID;
		this.datum_operacije = datum_operacije;
		this.satnica_pocetka_operacije = satnica_pocetka_operacije;
		this.satnica_kraja_operacije = satnica_kraja_operacije;
		this.salaID = salaID;
		this.pacijentID = pacijentID;
		this.lekar_ocenjen = lekar_ocenjen;
		this.klinika_ocenjena = klinika_ocenjena;
	}

	public Integer getOperacijaID() {
		return operacijaID;
	}

	public void setOperacijaID(Integer operacijaID) {
		this.operacijaID = operacijaID;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

	public LocalDate getDatum_operacije() {
		return datum_operacije;
	}

	public void setDatum_operacije(LocalDate datum_operacije) {
		this.datum_operacije = datum_operacije;
	}

	public LocalTime getSatnica_pocetka_operacije() {
		return satnica_pocetka_operacije;
	}

	public void setSatnica_pocetka_operacije(LocalTime satnica_pocetka_operacije) {
		this.satnica_pocetka_operacije = satnica_pocetka_operacije;
	}

	public LocalTime getSatnica_kraja_operacije() {
		return satnica_kraja_operacije;
	}

	public void setSatnica_kraja_operacije(LocalTime satnica_kraja_operacije) {
		this.satnica_kraja_operacije = satnica_kraja_operacije;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public Boolean getLekar_ocenjen() {
		return lekar_ocenjen;
	}

	public void setLekar_ocenjen(Boolean lekar_ocenjen) {
		this.lekar_ocenjen = lekar_ocenjen;
	}

	public Boolean getKlinika_ocenjena() {
		return klinika_ocenjena;
	}

	public void setKlinika_ocenjena(Boolean klinika_ocenjena) {
		this.klinika_ocenjena = klinika_ocenjena;
	}
	
}
