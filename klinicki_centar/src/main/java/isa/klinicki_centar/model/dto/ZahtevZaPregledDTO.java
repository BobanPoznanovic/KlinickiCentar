package isa.klinicki_centar.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import isa.klinicki_centar.model.ZahtevZaPregled;

public class ZahtevZaPregledDTO {

	private Integer zahtevID;

	private Integer klinikaID;
	
	private Integer pacijentID;
	
	private LocalDate datum;
	
	private LocalTime satnica_pocetak;
	
	private LocalTime satnica_kraj;
	
	private Integer lekarID;
	
	private Integer tip_pregledaID;
	
	private Integer popust;
	
	public ZahtevZaPregledDTO() {
	}
	
	public ZahtevZaPregledDTO(ZahtevZaPregled zahtevZaPregled) {
		this(
				zahtevZaPregled.getZahtevID(),
				zahtevZaPregled.getKlinikaID(),
				zahtevZaPregled.getPacijentID(),
				zahtevZaPregled.getDatum(),
				zahtevZaPregled.getSatnica_pocetak(),
				zahtevZaPregled.getSatnica_kraj(),
				zahtevZaPregled.getLekarID(),
				zahtevZaPregled.getTip_pregledaID(),
				zahtevZaPregled.getPopust()
			);
	}

	public ZahtevZaPregledDTO(Integer zahtevID, Integer klinikaID, Integer pacijentID, LocalDate datum,
			LocalTime satnica_pocetak, LocalTime satnica_kraj, Integer lekarID, Integer tip_pregledaID,
			Integer popust) {
		super();
		this.zahtevID = zahtevID;
		this.klinikaID = klinikaID;
		this.pacijentID = pacijentID;
		this.datum = datum;
		this.satnica_pocetak = satnica_pocetak;
		this.satnica_kraj = satnica_kraj;
		this.lekarID = lekarID;
		this.tip_pregledaID = tip_pregledaID;
		this.popust = popust;
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
	
}
