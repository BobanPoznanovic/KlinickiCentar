package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.TipPregleda;

public class TipPregledaDTO {

	private Integer tip_pregledaID;
	
	private String naziv;
	
	private float cena;

	public TipPregledaDTO() {	}
	
	public TipPregledaDTO(TipPregleda tip) {
		this(tip.getTip_pregledaID(), tip.getNaziv(), tip.getCena());
	}

	public TipPregledaDTO(Integer tip_pregledaID, String naziv, float cena) {
		super();
		this.tip_pregledaID = tip_pregledaID;
		this.naziv = naziv;
		this.cena = cena;
	}

	public Integer getTip_pregledaID() {
		return tip_pregledaID;
	}

	public void setTip_pregledaID(Integer tip_pregledaID) {
		this.tip_pregledaID = tip_pregledaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}
	
	
	
}
