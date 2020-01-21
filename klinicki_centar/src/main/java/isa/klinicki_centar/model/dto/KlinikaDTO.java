package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Klinika;

public class KlinikaDTO {
	
	private Integer klinikaID;
	private String naziv;	
	private String adresa;
	private String opis;
	
	public KlinikaDTO() {
		
	}
	
	public KlinikaDTO(Klinika klinika) {
		this(klinika.getKlinikaID(), klinika.getNaziv(), klinika.getAdresa(), klinika.getOpis());
	}
	
	public KlinikaDTO(Integer id, String naziv, String adresa, String opis) {
		super();
		this.setKlinikaID(id);
		this.setNaziv(naziv);
		this.setAdresa(adresa);
		this.setOpis(opis);
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
