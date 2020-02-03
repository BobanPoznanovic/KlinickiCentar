package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.ZahtevZaOdsustvo;

public class ZahtevZaOdsustvoDTO {

	private Integer zahtevID;
	
	private Integer podnosilac_zahtevaID;
	
	private String tip_odsustva;
	
	private String datum_pocetka;
	
	private String datum_kraja;
	
	private String status_odobrenja;
	
	private String razlog_odbijanja;
	
	public ZahtevZaOdsustvoDTO() {
		
	}
	
	public ZahtevZaOdsustvoDTO(ZahtevZaOdsustvo zahtev) {
		this(
				zahtev.getZahtevID(),
				zahtev.getPodnosilac_zahtevaID(),
				zahtev.getTip_odsustva().name(),
				zahtev.getDatum_pocetka().toString(),
				zahtev.getDatum_kraja().toString(),
				zahtev.getStatus_odobrenja().name(),
				zahtev.getRazlog_odbijanja()
				);
	}
	
	public ZahtevZaOdsustvoDTO(
			Integer zahtevID,
			Integer podnosilac_zahtevaID,
			String tip_odsustva,
			String datum_pocetka,
			String datum_kraja,
			String status_odobrenja,
			String razlog_odbijanja
			) {
		super();
		this.setZahtevID(zahtevID);
		this.setPodnosilac_zahtevaID(podnosilac_zahtevaID);
		this.setTip_odsustva(tip_odsustva);
		this.setDatum_pocetka(datum_pocetka);
		this.setDatum_kraja(datum_kraja);
		this.setStatus_odobrenja(status_odobrenja);
		this.setRazlog_odbijanja(razlog_odbijanja);
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
