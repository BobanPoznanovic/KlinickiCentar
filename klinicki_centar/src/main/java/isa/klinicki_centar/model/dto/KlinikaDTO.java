package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Klinika;

public class KlinikaDTO {
	
	private Integer klinikaID;
	private String naziv;	
	private String adresa;
	private String grad;
	private String opis;	
	private float prosecna_ocena = 0f;
	private Integer broj_ocena = 0;
	
	public KlinikaDTO() {
		
	}
	
	public KlinikaDTO(Klinika klinika) {
		this(klinika.getKlinikaID(), klinika.getNaziv(), klinika.getAdresa(), klinika.getGrad(), klinika.getOpis(), klinika.getProsecnaOcena(), klinika.getBrojOcena());
	}
	
	public KlinikaDTO(Integer id, String naziv, String adresa, String grad, String opis, float prosecnaOcena, Integer brojOcena) {
		super();
		this.setKlinikaID(id);
		this.setNaziv(naziv);
		this.setAdresa(adresa);
		this.setGrad(grad);
		this.setOpis(opis);
		this.setProsecnaOcena(prosecnaOcena);
		this.setBrojOcena(brojOcena);
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

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float getProsecnaOcena() {
		return prosecna_ocena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecna_ocena = prosecnaOcena;
	}

	public Integer getBrojOcena() {
		return broj_ocena;
	}

	public void setBrojOcena(Integer brojOcena) {
		this.broj_ocena = brojOcena;
	}

}
