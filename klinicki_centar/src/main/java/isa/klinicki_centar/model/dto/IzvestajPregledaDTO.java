package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.IzvestajPregleda;

public class IzvestajPregledaDTO {

	private Integer izvestaj_pregledaID;
	
	private Integer pregledID;
	
	private Integer dijagnozaID;
	
	private String opis_pregleda;
	
	public IzvestajPregledaDTO() {
		
	}
	
	public IzvestajPregledaDTO(IzvestajPregleda izvestaj) {
		this(
				izvestaj.getIzvestaj_pregledaID(), izvestaj.getPregledID(), izvestaj.getDijagnozaID(), izvestaj.getOpis_pregleda()
				);
	}
	
	public IzvestajPregledaDTO(
			Integer izvestaj_pregledaID, Integer pregledID, Integer dijagnozaID, String opis_pregleda
			) {
		super();
		this.setDijagnozaID(dijagnozaID);
		this.setIzvestaj_pregledaID(izvestaj_pregledaID);
		this.setOpis_pregleda(opis_pregleda);
		this.setPregledID(pregledID);
	}

	public Integer getIzvestaj_pregledaID() {
		return izvestaj_pregledaID;
	}

	public void setIzvestaj_pregledaID(Integer izvestaj_pregledaID) {
		this.izvestaj_pregledaID = izvestaj_pregledaID;
	}

	public Integer getPregledID() {
		return pregledID;
	}

	public void setPregledID(Integer pregledID) {
		this.pregledID = pregledID;
	}

	public Integer getDijagnozaID() {
		return dijagnozaID;
	}

	public void setDijagnozaID(Integer dijagnozaID) {
		this.dijagnozaID = dijagnozaID;
	}

	public String getOpis_pregleda() {
		return opis_pregleda;
	}

	public void setOpis_pregleda(String opis_pregleda) {
		this.opis_pregleda = opis_pregleda;
	}
}
