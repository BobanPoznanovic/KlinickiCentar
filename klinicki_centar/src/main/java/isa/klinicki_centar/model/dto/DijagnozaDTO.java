package isa.klinicki_centar.model.dto;

import isa.klinicki_centar.model.Dijagnoza;

public class DijagnozaDTO {
	
	private Integer dijagnozaID;
	
	private String naziv;
	
	public DijagnozaDTO() {
		
	}
	
	public DijagnozaDTO(Dijagnoza dijagnoza) {
		this(dijagnoza.getDijagnozaID(), dijagnoza.getNaziv());
	}
	
	public DijagnozaDTO(Integer id, String naziv) {
		super();
		this.setDijagnozaID(id);
		this.setNaziv(naziv);
	}

	public Integer getDijagnozaID() {
		return dijagnozaID;
	}

	public void setDijagnozaID(Integer dijagnozaID) {
		this.dijagnozaID = dijagnozaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
