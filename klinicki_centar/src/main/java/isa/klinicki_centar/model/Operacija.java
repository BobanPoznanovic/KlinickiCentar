package isa.klinicki_centar.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "OPERACIJA")
public class Operacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer operacijaID;
	
	private Integer lekarID;
	
	private LocalDate datum_operacije;
	
	private LocalTime satnica_pocetka_operacije;
	
	private LocalTime satnica_kraja_operacije;
	
	private Integer salaID;
	
	private Integer pacijentID;
	
	private Boolean lekar_ocenjen;
	
	private Boolean klinika_ocenjena;
	
	public Operacija() {
		
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
