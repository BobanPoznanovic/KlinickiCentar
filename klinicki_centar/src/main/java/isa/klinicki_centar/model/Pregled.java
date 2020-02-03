package isa.klinicki_centar.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "PREGLED")
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pregledID;
	
	@Enumerated(EnumType.STRING)
	private KategorijaPregleda kategorija_pregleda;
	
	private Integer lekarID;
	
	private Integer pacijentID;
	
	private Integer salaID;
	
	private LocalDate datum_pregleda;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	private Integer tip_pregledaID;
	
	private float popust;
	
	private Boolean zakazan_dodatan_pregled;
	
	private Boolean zakazana_operacija;
	
	public Pregled() {
		
	}

	public Integer getPregledID() {
		return pregledID;
	}

	public void setPregledID(Integer pregledID) {
		this.pregledID = pregledID;
	}

	public KategorijaPregleda getKategorija_pregleda() {
		return kategorija_pregleda;
	}

	public void setKategorija_pregleda(KategorijaPregleda kategorija_pregleda) {
		this.kategorija_pregleda = kategorija_pregleda;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
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

	public Boolean getZakazan_dodatan_pregled() {
		return zakazan_dodatan_pregled;
	}

	public void setZakazan_dodatan_pregled(Boolean zakazan_dodatan_pregled) {
		this.zakazan_dodatan_pregled = zakazan_dodatan_pregled;
	}

	public Boolean getZakazana_operacija() {
		return zakazana_operacija;
	}

	public void setZakazana_operacija(Boolean zakazana_operacija) {
		this.zakazana_operacija = zakazana_operacija;
	}
}
