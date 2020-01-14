package isa.klinicki_centar.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "PREDEF_PREGLED")
public class PredefPregled {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer predef_pregledID;
	
	private Integer klinikaID;
	
	private LocalDate datum_pregleda;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	private Integer salaID;
	
	private Integer lekarID;
	
	private Integer tip_pregledaID;
	
	private float popust;
	
	public PredefPregled() {
		
	}

	public Integer getPredef_pregledID() {
		return predef_pregledID;
	}

	public void setPredef_pregledID(Integer predef_pregledID) {
		this.predef_pregledID = predef_pregledID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public LocalDate getDatum_pregleda() {
		return datum_pregleda;
	}

	public void setDatum_pregleda(LocalDate datum_pregleda) {
		this.datum_pregleda = datum_pregleda;
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

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

	public Integer getTip_pregledaID() {
		return tip_pregledaID;
	}

	public void setTip_pregledaID(Integer tip_pregledaID) {
		this.tip_pregledaID = tip_pregledaID;
	}

	public float getPopust() {
		return popust;
	}

	public void setPopust(float popust) {
		this.popust = popust;
	}
}
