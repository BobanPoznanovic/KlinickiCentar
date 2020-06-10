package isa.klinicki_centar.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ZAHTEV_ZA_PREGLED")
public class ZahtevZaPregled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer zahtevID;
	
	private Integer klinikaID;
	
	private Integer pacijentID;
	
	private Date datum;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	private Integer lekarID;
	
	private Integer tip_pregledaID;
	
	private Integer popust;
	
	private Boolean potvrdjen;
	
	public ZahtevZaPregled() {
		
	}

	public ZahtevZaPregled(Integer tip_pregledaID, Date datum, Integer klinikaID, Integer lekarID, Integer pacijentID) {
		this.klinikaID = klinikaID;
		this.pacijentID = pacijentID;
		this.datum = datum;
		this.lekarID = lekarID;
		this.tip_pregledaID = tip_pregledaID;
		this.satnica_pocetak = LocalTime.of(datum.getHours(), datum.getMinutes());
		this.satnica_kraj = satnica_pocetak.plusMinutes(29);
		this.popust = 0;
		this.potvrdjen = false;
	}

	public ZahtevZaPregled(Integer zahtevID, Integer klinikaID, Integer pacijentID, Date datum,
			LocalTime satnica_pocetak, LocalTime satnica_kraj, Integer lekarID, Integer tip_pregledaID,
			Integer popust, Boolean potvrdjen) {
		this.zahtevID = zahtevID;
		this.klinikaID = klinikaID;
		this.pacijentID = pacijentID;
		this.datum = datum;
		this.satnica_pocetak = satnica_pocetak;
		this.satnica_kraj = satnica_kraj;
		this.lekarID = lekarID;
		this.tip_pregledaID = tip_pregledaID;
		this.popust = popust;
		this.potvrdjen = potvrdjen;
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public Integer getPacijentID() {
		return pacijentID;
	}

	public void setPacijentID(Integer pacijentID) {
		this.pacijentID = pacijentID;
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

	public Integer getPopust() {
		return popust;
	}

	public void setPopust(Integer popust) {
		this.popust = popust;
	}

	public Boolean getPotvrdjen() {
		return potvrdjen;
	}

	public void setPotvrdjen(Boolean potvrdjen) {
		this.potvrdjen = potvrdjen;
	}
}
