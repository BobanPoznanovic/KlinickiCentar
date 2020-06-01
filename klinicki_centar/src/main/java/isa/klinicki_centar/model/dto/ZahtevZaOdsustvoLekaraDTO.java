package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.ZahtevZaOdsustvoLekar;

public class ZahtevZaOdsustvoLekaraDTO {

	private Integer zahtevID;
	
	private Integer lekarID;
	
	private String tip_odsustva;
	
	private String datum_pocetka;
	
	private String datum_kraja;
	
	private String status_odobrenja;
	
	private String razlog_odbijanja;

	public ZahtevZaOdsustvoLekaraDTO() { }
	
	public ZahtevZaOdsustvoLekaraDTO(ZahtevZaOdsustvoLekar zahtev) {
		this(
				zahtev.getZahtevID(),
				zahtev.getLekarID(),
				zahtev.getTip_odsustva().name(),
				zahtev.getDatum_pocetka().toString(),
				zahtev.getDatum_kraja().toString(),
				zahtev.getStatus_odobrenja().name(),
				zahtev.getRazlog_odbijanja()
				);
	}

	public ZahtevZaOdsustvoLekaraDTO(Integer zahtevID, Integer lekarID, String tip_odsustva, String datum_pocetka,
			String datum_kraja, String status_odobrenja, String razlog_odbijanja) {
		super();
		this.zahtevID = zahtevID;
		this.lekarID = lekarID;
		this.tip_odsustva = tip_odsustva;
		this.datum_pocetka = datum_pocetka;
		this.datum_kraja = datum_kraja;
		this.status_odobrenja = status_odobrenja;
		this.razlog_odbijanja = razlog_odbijanja;
	}

	public Integer getZahtevID() {
		return zahtevID;
	}

	public void setZahtevID(Integer zahtevID) {
		this.zahtevID = zahtevID;
	}

	public Integer getLekarID() {
		return lekarID;
	}

	public void setLekarID(Integer lekarID) {
		this.lekarID = lekarID;
	}

	public String getTip_odsustva() {
		return tip_odsustva;
	}

	public void setTip_odsustva(String tip_odsustva) {
		this.tip_odsustva = tip_odsustva;
	}

	public String getDatum_pocetka() {
		return datum_pocetka;
	}

	public void setDatum_pocetka(String datum_pocetka) {
		this.datum_pocetka = datum_pocetka;
	}

	public String getDatum_kraja() {
		return datum_kraja;
	}

	public void setDatum_kraja(String datum_kraja) {
		this.datum_kraja = datum_kraja;
	}

	public String getStatus_odobrenja() {
		return status_odobrenja;
	}

	public void setStatus_odobrenja(String status_odobrenja) {
		this.status_odobrenja = status_odobrenja;
	}

	public String getRazlog_odbijanja() {
		return razlog_odbijanja;
	}

	public void setRazlog_odbijanja(String razlog_odbijanja) {
		this.razlog_odbijanja = razlog_odbijanja;
	}
	
	
	
}
