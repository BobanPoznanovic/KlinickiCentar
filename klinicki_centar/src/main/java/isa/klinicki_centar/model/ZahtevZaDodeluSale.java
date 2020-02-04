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
@Table( name = "ZAHTEV_ZA_DODELU_SALE")
public class ZahtevZaDodeluSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer zahtevID;
	
	private Integer zahtev_za_pregledID;
	
	private Integer salaID;
	
	private LocalDate datum_kreiranja_zahteva;
	
	private LocalTime vreme_kreiranja_zahteva;
	
	@Enumerated(EnumType.STRING)
	private StatusZahtevaZaDodeluSale status_zahteva;
	
	public ZahtevZaDodeluSale() {
		
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getZahtev_za_pregledID() {
		return zahtev_za_pregledID;
	}

	public void setZahtev_za_pregledID(Integer zahtev_za_pregledID) {
		this.zahtev_za_pregledID = zahtev_za_pregledID;
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public LocalDate getDatum_kreiranja_zahteva() {
		return datum_kreiranja_zahteva;
	}

	public void setDatum_kreiranja_zahteva(LocalDate datum_kreiranja_zahteva) {
		this.datum_kreiranja_zahteva = datum_kreiranja_zahteva;
	}

	public LocalTime getVreme_kreiranja_zahteva() {
		return vreme_kreiranja_zahteva;
	}

	public void setVreme_kreiranja_zahteva(LocalTime vreme_kreiranja_zahteva) {
		this.vreme_kreiranja_zahteva = vreme_kreiranja_zahteva;
	}

	public StatusZahtevaZaDodeluSale getStatus_zahteva() {
		return status_zahteva;
	}

	public void setStatus_zahteva(StatusZahtevaZaDodeluSale status_zahteva) {
		this.status_zahteva = status_zahteva;
	}

}
