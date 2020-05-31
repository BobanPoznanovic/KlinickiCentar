package isa.klinicki_centar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ZAHTEV_ZA_ODSUSTVO")
public class ZahtevZaOdsustvo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer zahtevID;
	
	private Integer podnosilac_zahtevaID;
	
	@Enumerated(EnumType.STRING)
	private TipOdsustva tip_odsustva;
	
	private LocalDate datum_pocetka;
	
	private LocalDate datum_kraja;
	
	@Enumerated(EnumType.STRING)
	private StatusZahtevaZaOdsustvo status_odobrenja;
	
	private String razlog_odbijanja;
	
	public ZahtevZaOdsustvo() {
		
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getPodnosilac_zahtevaID() {
		return podnosilac_zahtevaID;
	}

	public void setPodnosilac_zahtevaID(Integer podnosilac_zahtevaID) {
		this.podnosilac_zahtevaID = podnosilac_zahtevaID;
	}

	public TipOdsustva getTip_odsustva() {
		return tip_odsustva;
	}

	public void setTip_odsustva(TipOdsustva tip_odsustva) {
		this.tip_odsustva = tip_odsustva;
	}

	public LocalDate getDatum_pocetka() {
		return datum_pocetka;
	}

	public void setDatum_pocetka(LocalDate datum_pocetka) {
		this.datum_pocetka = datum_pocetka;
	}

	public LocalDate getDatum_kraja() {
		return datum_kraja;
	}

	public void setDatum_kraja(LocalDate datum_kraja) {
		this.datum_kraja = datum_kraja;
	}

	public StatusZahtevaZaOdsustvo getStatus_odobrenja() {
		return status_odobrenja;
	}

	public void setStatus_odobrenja(StatusZahtevaZaOdsustvo status_odobrenja) {
		this.status_odobrenja = status_odobrenja;
	}

	public String getRazlog_odbijanja() {
		return razlog_odbijanja;
	}

	public void setRazlog_odbijanja(String razlog_odbijanja) {
		this.razlog_odbijanja = razlog_odbijanja;
	}
	

}
