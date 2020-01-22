package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Lek;

public class LekDTO {

	private Integer lekID;
	
	private String naziv;
	
	private String proizvodjac;
	
	private String doza;
	
	public LekDTO() {
		
	}
	
	public LekDTO(Lek lek) {
		this(lek.getLekID(), lek.getNaziv(), lek.getProizvodjac(), lek.getDoza());
	}
	
	public LekDTO(Integer id, String naziv, String proizvodjac, String doza) {
		super();
		this.setLekID(id);
		this.setNaziv(naziv);
		this.setProizvodjac(proizvodjac);
		this.setDoza(doza);
	}

	public Integer getLekID() {
		return lekID;
	}

	public void setLekID(Integer lekID) {
		this.lekID = lekID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getDoza() {
		return doza;
	}

	public void setDoza(String doza) {
		this.doza = doza;
	}
}
