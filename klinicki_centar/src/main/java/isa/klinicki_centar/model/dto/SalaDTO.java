package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Sala;

public class SalaDTO {

	private Integer salaID;
	
	private Integer klinikaID;
	
	private String naziv_sale;
	
	private Integer broj_sale;
	
	public SalaDTO() {
		
	}
	
	public SalaDTO(Sala sala) {
		this(sala.getSalaID(), sala.getKlinikaID(), sala.getNaziv_sale(), sala.getBroj_sale());
	}
	
	public SalaDTO(Integer salaID, Integer klinikaID, String naziv_sale, Integer broj_sale) {
		super();
		this.setSalaID(salaID);
		this.setKlinikaID(klinikaID);
		this.setNaziv_sale(naziv_sale);
		this.setBroj_sale(broj_sale);
	}

	public Integer getSalaID() {
		return salaID;
	}

	public void setSalaID(Integer salaID) {
		this.salaID = salaID;
	}

	public Integer getKlinikaID() {
		return klinikaID;
	}

	public void setKlinikaID(Integer klinikaID) {
		this.klinikaID = klinikaID;
	}

	public String getNaziv_sale() {
		return naziv_sale;
	}

	public void setNaziv_sale(String naziv_sale) {
		this.naziv_sale = naziv_sale;
	}

	public Integer getBroj_sale() {
		return broj_sale;
	}

	public void setBroj_sale(Integer broj_sale) {
		this.broj_sale = broj_sale;
	}
}
